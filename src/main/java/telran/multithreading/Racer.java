package telran.multithreading;

import java.util.Random;

public class Racer extends Thread {
    private Race race;
    private int number;

    public Racer(Race race, int number) {
        this.race = race;
        this.number = number;
    }

    @Override
    public void run() {
        int minSleep = race.getMinSleep();
        int maxSleep = race.getMaxSleep();
        int distance = race.getDistance();
        Random random = new Random();

        for (int i = 0; i < distance; i++) {
            try {
                sleep(random.nextInt(minSleep, maxSleep + 1));
                System.out.printf("Racer %d - step %d\n", number, i + 1);
            } catch (InterruptedException e) {}
        }

        long finishTime = System.currentTimeMillis();
        long runningTime = finishTime - race.getStartTime();

        race.addResult(number, runningTime);
    }
}
