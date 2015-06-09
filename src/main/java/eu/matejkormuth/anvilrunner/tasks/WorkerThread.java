package eu.matejkormuth.anvilrunner.tasks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkerThread {
    private static final AtomicInteger counter = new AtomicInteger();

    private final Thread thread;
    private final Deque<Runnable> deque;

    public WorkerThread() {
        thread = new Thread(this::work);
        thread.setName("WorkerThread-" + counter.getAndIncrement());

        deque = new ArrayDeque<>();
    }

    private void work() {
        if(!deque.isEmpty()) {
            try {
                deque.peek().run();
            } catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
