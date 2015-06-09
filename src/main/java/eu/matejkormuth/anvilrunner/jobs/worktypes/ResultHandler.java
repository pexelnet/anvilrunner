package eu.matejkormuth.anvilrunner.jobs.worktypes;

public interface ResultHandler<P, R> {
    void onResult(P parameter, R result);
}
