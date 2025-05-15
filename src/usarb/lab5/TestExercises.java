package usarb.lab5;

import usarb.lab5.first.*;

import usarb.lab5.second.*;
import usarb.lab5.third.*;
import usarb.lab5.fourth.*;

public class TestExercises {
    public static void main(String[] args) {
        // Test exercitiul 1 - Task implementations
        System.out.println("=== Testing Task implementations ===");
        Task outTask = new OutTask("Hello, World!");
        Task randomTask = new RandomOutTask();
        Task counterTask1 = new CounterOutTask();
        Task counterTask2 = new CounterOutTask();

        outTask.execute();
        randomTask.execute();
        counterTask1.execute();
        counterTask2.execute();

        // Test exercitiul 2 - Container implementations
        System.out.println("\n=== Testing Container implementations ===");
        // Folosind factory pentru a crea containere
        ContainerFactory factory = ContainerFactory.getInstance();
        Container stack = factory.createContainer(Strategy.LIFO);
        Container queue = factory.createContainer(Strategy.FIFO);

        // Adăugare task-uri în stack
        System.out.println("Adding tasks to stack...");
        stack.push(new OutTask("Task 1"));
        stack.push(new OutTask("Task 2"));
        stack.push(new OutTask("Task 3"));

        // Extragere și execuție task-uri din stack (LIFO)
        System.out.println("\nPopping and executing tasks from stack (LIFO):");
        while (!stack.isEmpty()) {
            Task task = stack.pop();
            task.execute();
        }

        // Adăugare task-uri în queue
        System.out.println("\nAdding tasks to queue...");
        queue.push(new OutTask("Task 1"));
        queue.push(new OutTask("Task 2"));
        queue.push(new OutTask("Task 3"));

        // Extragere și execuție task-uri din queue (FIFO)
        System.out.println("\nPopping and executing tasks from queue (FIFO):");
        while (!queue.isEmpty()) {
            Task task = queue.pop();
            task.execute();
        }

        // Test exercitiul 4 - TaskRunner implementations
        System.out.println("\n=== Testing TaskRunner implementations ===");

        // Test PrintTimeTaskRunner
        System.out.println("\nTesting PrintTimeTaskRunner:");
        PrintTimeTaskRunner printTimeRunner = new PrintTimeTaskRunner(Strategy.FIFO);
        printTimeRunner.addTask(new OutTask("PrintTime Task 1"));
        printTimeRunner.addTask(new OutTask("PrintTime Task 2"));
        printTimeRunner.executeAll();

        // Test CounterTaskRunner
        System.out.println("\nTesting CounterTaskRunner:");
        CounterTaskRunner counterRunner = new CounterTaskRunner(Strategy.FIFO);
        counterRunner.addTask(new OutTask("Counter Task 1"));
        counterRunner.addTask(new OutTask("Counter Task 2"));
        counterRunner.addTask(new OutTask("Counter Task 3"));
        counterRunner.executeAll();
        System.out.println("Total tasks executed: " + counterRunner.getCounter());

        // Test RedoBackTaskRunner
        System.out.println("\nTesting RedoBackTaskRunner:");
        RedoBackTaskRunner redoRunner = new RedoBackTaskRunner(Strategy.FIFO);
        redoRunner.addTask(new OutTask("Redo Task 1"));
        redoRunner.addTask(new OutTask("Redo Task 2"));
        System.out.println("Executing tasks first time:");
        redoRunner.executeAll();
        System.out.println("\nRedoing tasks:");
        redoRunner.redoTasks();
    }
}