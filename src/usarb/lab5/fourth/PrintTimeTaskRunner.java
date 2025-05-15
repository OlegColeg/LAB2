package usarb.lab5.fourth;

import usarb.lab5.first.Task;
import usarb.lab5.third.Strategy;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class PrintTimeTaskRunner extends AbstractTaskRunner {
    private SimpleDateFormat timeFormat;

    public PrintTimeTaskRunner(Strategy strategy) {
        super(strategy);
        timeFormat = new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    protected void afterExecution(Task task) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Task executed at: " + timeFormat.format(calendar.getTime()));
    }
}