package telran.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private int distance;
    private int minSleep;
    private int maxSleep;
    private long startTime;
    private List<RaceResult> results = Collections.synchronizedList(new ArrayList<>());

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

    public void addResult(int racerNumber, long runningTime) {
        synchronized (this) {
            results.add(new RaceResult(racerNumber, runningTime));
        }
    }

    public List<RaceResult> getResults() {
        return results;
    }
}
