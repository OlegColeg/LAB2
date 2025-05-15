package usarb.lab5.second;

import usarb.lab5.first.Task;


public class Stack extends AbstractContainer {

    @Override
    public Task pop() {
        if (isEmpty()) {
            return null;
        }
        // Pentru stack (LIFO), scoatem ultimul element adăugat
        return tasks.remove(tasks.size() - 1);
    }
}