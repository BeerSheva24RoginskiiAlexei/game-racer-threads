package telran.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Race {
    private int distance;
    private int minSleepTime = 100; 
    private int maxSleepTime = 300; 
    private AtomicInteger winner = new AtomicInteger(0); 

    public Race(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getRandomSleepTime() {
        return minSleepTime + (int) (Math.random() * (maxSleepTime - minSleepTime));
    }

    public void setWinner(int racerNumber) {
        winner.compareAndSet(0, racerNumber); 
    }

    public int getWinner() {
        return winner.get();
    }
}
