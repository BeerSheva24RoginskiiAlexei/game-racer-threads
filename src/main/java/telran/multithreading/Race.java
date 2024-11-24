package telran.multithreading;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Race {
    private int distance;
    private int minSleep;
    private int maxSleep;
    private long startTime;
    private List<RaceResult> results = new CopyOnWriteArrayList<>();

    public Race(int distance, int minSleep, int maxSleep) {
        this.distance = distance;
        this.minSleep = minSleep;
        this.maxSleep = maxSleep;
    }

    public synchronized void startRace() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public int getDistance() {
        return distance;
    }

    public int getMinSleep() {
        return minSleep;
    }

    public int getMaxSleep() {
        return maxSleep;
    }

    public void addResult(RaceResult result) {
        synchronized (results) {
            results.add(result);
        }
    }

    public List<RaceResult> getResults() {
        return results;
    }
}
