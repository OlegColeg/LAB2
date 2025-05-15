package usarb.lab5.first;


import java.util.Random;

public class RandomOutTask implements Task {
    private final int randomNumber;

    public RandomOutTask() {
        Random random = new Random();
        this.randomNumber = random.nextInt(100); // Generează un număr între 0 și 99
    }

    @Override
    public void execute() {
        System.out.println("Random number generated: " + randomNumber);
    }
}