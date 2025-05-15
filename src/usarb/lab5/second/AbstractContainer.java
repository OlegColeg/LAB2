package usarb.lab5.second;

import usarb.lab5.first.Task;
import java.util.ArrayList;

public abstract class AbstractContainer implements Container {
    protected ArrayList<Task> tasks;

    public AbstractContainer() {
        tasks = new ArrayList<>();
    }

    @Override
    public abstract Task pop();

    @Override
    public void push(Task task) {
        tasks.add(task);
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    @Override
    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            push(container.pop());
        }
    }
}