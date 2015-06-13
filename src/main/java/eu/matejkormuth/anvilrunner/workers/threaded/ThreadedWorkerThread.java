package eu.matejkormuth.anvilrunner.workers.threaded;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadedWorkerThread {
    private static final AtomicInteger counter = new AtomicInteger();

    private final Thread thread;
    final Deque<Runnable> workBuffer;

    public ThreadedWorkerThread(int workBufferSize) {
        thread = new Thread(this::work);
        thread.setName("ThreadedWorkerThread-" + counter.getAndIncrement());

        workBuffer = new ArrayDeque<>(workBufferSize);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    private void work() {
        if (!workBuffer.isEmpty()) {
            try {
                workBuffer.pop().run();
            } catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
