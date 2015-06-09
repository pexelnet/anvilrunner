package eu.matejkormuth.anvilrunner.tasks;

public class WorkResultCouple {
    final Object resultProcessor;
    final Object resultHandler;

    public WorkResultCouple(final Object resultProcessor, final Object resultHandler) {
        this.resultProcessor = resultProcessor;
        this.resultHandler = resultHandler;
    }
}
