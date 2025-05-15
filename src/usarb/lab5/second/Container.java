package usarb.lab5.second;

import usarb.lab5.first.Task;


public interface Container {
    Task pop();
    void push(Task task);
    int size();
    boolean isEmpty();
    void transferFrom(Container container);
}