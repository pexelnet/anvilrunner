package eu.matejkormuth.anvilrunner.tasks;

public abstract class TaskExecutor {
    protected Iterable workParameterProvider;
    protected WorkResultCouple workDefinition;

    public void setTask(WorkResultCouple workDefinition) {
        this.workDefinition = workDefinition;
    }

    public abstract void start();

    public void setWorkParameterProvider(Iterable workParameterProvider) {
        this.workParameterProvider = workParameterProvider;
    }
}
