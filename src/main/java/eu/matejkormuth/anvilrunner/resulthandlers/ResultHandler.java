package eu.matejkormuth.anvilrunner.resulthandlers;

public interface ResultHandler<P, R> {
    void onResult(P parameter, R result);
}
