package usarb.lab5.second;

import usarb.lab5.first.Task;


public class Queue extends AbstractContainer {

    @Override
    public Task pop() {
        if (isEmpty()) {
            return null;
        }
        // Pentru queue (FIFO), scoatem primul element adăugat
        return tasks.remove(0);
    }
}