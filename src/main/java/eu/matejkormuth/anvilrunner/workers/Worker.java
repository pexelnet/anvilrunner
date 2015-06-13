package eu.matejkormuth.anvilrunner.workers;

public abstract class Worker {
    protected Iterable workParameterProvider;
    protected WorkResultCouple workDefinition;

    public void setWork(WorkResultCouple workDefinition) {
        this.workDefinition = workDefinition;
    }

    public abstract void start();

    public void setWorkParameterProvider(Iterable workParameterProvider) {
        this.workParameterProvider = workParameterProvider;
    }
}
