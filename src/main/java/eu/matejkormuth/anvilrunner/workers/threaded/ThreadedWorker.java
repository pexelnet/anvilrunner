package eu.matejkormuth.anvilrunner.workers.threaded;

import eu.matejkormuth.anvilrunner.Block;
import eu.matejkormuth.anvilrunner.worktypes.BlockTest;
import eu.matejkormuth.anvilrunner.resulthandlers.BlockTestResultHandler;
import eu.matejkormuth.anvilrunner.workers.Worker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public final class ThreadedWorker extends Worker {
    private final int threadCount;
    private final int workerBufferSize;
    private RunnableFactory runnableFactory;
    private ThreadedWorkerThread[] threads;

    public ThreadedWorker(int threadCount, int workerBufferSize) {
        this.threadCount = threadCount;
        this.workerBufferSize = workerBufferSize;

        threads = new ThreadedWorkerThread[threadCount];

        // Create thread objects.
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new ThreadedWorkerThread(workerBufferSize);
        }

        // Create runnable factory.
        this.createRunnableFactory();
    }

    @Override
    public void start() {
        // Until the whole work isn't done.
        final int readyWorkBufferSize = threadCount * workerBufferSize;
        Deque<Runnable> readyWorkBuffer = new ArrayDeque<>(readyWorkBufferSize);
        Iterator workProvider = this.workParameterProvider.iterator();
        boolean hasMoreWork = true;
        // How much work we need to push to worker.
        int workerWorkDelta;
        // How much work we need to load to main buffer.
        int readyBufferWorkDelta;

        while (hasMoreWork) {
            // If local work buffer is not full, decode more work.
            readyBufferWorkDelta = readyWorkBufferSize - readyWorkBuffer.size();
            if (readyBufferWorkDelta > 0) {

                // Invalid param detection.
                if (readyBufferWorkDelta == readyWorkBufferSize) {
                    System.out.println("Can't load new data fast enough, try changing parameters or optimizing code!");
                }

                // Decode more work.

                // We get decoded work from iterator.
                for (int h = 0; h < readyBufferWorkDelta; h++) {
                    if (workProvider.hasNext()) {
                        // Use factory to create Runnable based on parameter processor type.
                        readyWorkBuffer.addLast(this.runnableFactory.create(workProvider.next()));
                    } else {
                        // We run out of data to work on. Get last parts of work, then leave the while cycle.
                        hasMoreWork = false;
                        break;
                    }
                }
            }

            // Give work to workers. Loop from 0 to n-threads.
            for (int i = 0; i < threadCount; i++) {
                // If thread buffer is not full, push some work.
                workerWorkDelta = workerBufferSize - threads[i].workBuffer.size();
                if (workerWorkDelta > 0) {
                    // Pop delta work from readyWorkBuffer and push it to thread buffer.
                    for (int j = 0; j < workerWorkDelta; j++) {
                        // addLast() = push_back()
                        if (readyWorkBuffer.size() > 0) {
                            threads[i].workBuffer.addLast(readyWorkBuffer.pop());
                        } else {
                            // Something is wrong, or we are at the end of work.
                        }
                    }
                }
            }
        }
        // Work is done!


        // Shutdown the worker threads.
        for (int i = 0; i < threadCount; i++) {
            threads[i].stop();
        }
    }

    /**
     * Determinate which RunnableFactory will be used to transform work to Runnables by resultProcessor type.
     */
    private final void createRunnableFactory() {
        Object processor = workDefinition.resultProcessor;

        // Long list of if-else statements to provide correct RunnableFactory.
        if (processor instanceof BlockTest) {
            this.runnableFactory = new BlockInvocationRunnableFactory();
        }
    }

    private interface RunnableFactory {
        // Creates runnable with specified parameter.
        Runnable create(Object parameter);
    }

    public final class BlockInvocationRunnableFactory implements RunnableFactory {
        @Override
        public Runnable create(Object parameter) {
            return () -> {
                final boolean result = ((BlockTest) workDefinition.resultHandler).testBlock((Block) parameter);
                ((BlockTestResultHandler) workDefinition.resultProcessor).onResult((Block) parameter, result);
            };
        }
    }
}
