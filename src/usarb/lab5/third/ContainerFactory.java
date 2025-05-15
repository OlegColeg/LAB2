package usarb.lab5.third;

import usarb.lab5.second.Container;
import usarb.lab5.second.Stack;
import usarb.lab5.second.Queue;

public class ContainerFactory implements IFactory {
    // Singleton pattern implementation
    private static ContainerFactory instance = null;

    // Private constructor pentru a împiedica instanțierea directă
    private ContainerFactory() {}

    // Metoda pentru a obține instanța unică
    public static ContainerFactory getInstance() {
        if (instance == null) {
            instance = new ContainerFactory();
        }
        return instance;
    }

    @Override
    public Container createContainer(Strategy strategy) {
        switch (strategy) {
            case LIFO:
                return new Stack();
            case FIFO:
                return new Queue();
            default:
                return null;
        }
    }
}