package eu.matejkormuth.anvilrunner.workers;

public final class WorkResultCouple {
    public final Object resultProcessor;
    public final Object resultHandler;

    public WorkResultCouple(final Object resultProcessor, final Object resultHandler) {
        this.resultProcessor = resultProcessor;
        this.resultHandler = resultHandler;
    }
}
