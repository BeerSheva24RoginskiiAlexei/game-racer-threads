package telran.multithreading;

public class RaceResult {
    private final int racerNumber;
    private final long runningTime;

    public RaceResult(int racerNumber, long runningTime) {
        this.racerNumber = racerNumber;
        this.runningTime = runningTime;
    }

    public int getRacerNumber() {
        return racerNumber;
    }

    public long getRunningTime() {
        return runningTime;
    }
}
