package telran.multithreading;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of racers:");
        int numberOfRacers = scanner.nextInt();

        System.out.println("Enter the distance (number of iterations):");
        int distance = scanner.nextInt();

        System.out.println("Race is starting...");

        Race race = new Race(distance);

        Racer[] racers = new Racer[numberOfRacers];
        for (int i = 0; i < numberOfRacers; i++) {
            racers[i] = new Racer(race, i + 1); 
            racers[i].start();
        }

        for (Racer racer : racers) {
            try {
                racer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("The winner is Racer #%d!%n", race.getWinner());
    }
}
