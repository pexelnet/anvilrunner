package eu.matejkormuth.anvilrunner.tasks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkerThread {
    private static final AtomicInteger counter = new AtomicInteger();

    private final Thread thread;
    final Deque<Runnable> workBuffer;

    public WorkerThread(int workBufferSize) {
        thread = new Thread(this::work);
        thread.setName("WorkerThread-" + counter.getAndIncrement());

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
