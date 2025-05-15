package usarb.lab5.fourth;

import usarb.lab5.first.Task;
import usarb.lab5.second.Container;
import usarb.lab5.third.ContainerFactory;
import usarb.lab5.third.Strategy;

public abstract class AbstractTaskRunner {
    protected Container container;

    public AbstractTaskRunner(Strategy strategy) {
        container = ContainerFactory.getInstance().createContainer(strategy);
    }

    public void addTask(Task task) {
        container.push(task);
    }

    public void executeAll() {
        while (!container.isEmpty()) {
            Task task = container.pop();
            task.execute();
            afterExecution(task);
        }
    }

    protected abstract void afterExecution(Task task);
}