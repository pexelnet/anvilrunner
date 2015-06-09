package eu.matejkormuth.anvilrunner.tasks;

public class ThreadedWorker extends TaskExecutor {
    private WorkerThread[] threads;

    public ThreadedWorker(int threadCount) {
        threads = new WorkerThread[threadCount];
    }

    @Override
    public void start() {
        //somehow do the work
    }
}
