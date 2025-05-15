package usarb.lab5.fourth;

import usarb.lab5.first.Task;
import usarb.lab5.third.Strategy;

public class CounterTaskRunner extends AbstractTaskRunner {
    private int counter;

    public CounterTaskRunner(Strategy strategy) {
        super(strategy);
        counter = 0;
    }

    @Override
    protected void afterExecution(Task task) {
        counter++;
        System.out.println("Tasks executed so far: " + counter);
    }

    public int getCounter() {
        return counter;
    }
}