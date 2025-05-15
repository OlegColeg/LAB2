package usarb.lab5.fourth;



import usarb.lab5.first.Task;
import usarb.lab5.second.Container;
import usarb.lab5.third.ContainerFactory;
import usarb.lab5.third.Strategy;

public class RedoBackTaskRunner extends AbstractTaskRunner {
    private Container redoContainer;

    public RedoBackTaskRunner(Strategy strategy) {
        super(strategy);
        this.redoContainer = ContainerFactory.getInstance().createContainer(Strategy.LIFO);
    }

    @Override
    protected void afterExecution(Task task) {
        // Salvăm task-ul executat în containerul de redo
        redoContainer.push(task);
    }

    public void redoTasks() {
        System.out.println("Redoing tasks in reverse order:");
        while (!redoContainer.isEmpty()) {
            Task task = redoContainer.pop();
            task.execute();
        }
    }
}