package telran.multithreading;

public class Racer extends Thread {
    private Race race;
    private int number;

    public Racer(Race race, int number) {
        this.race = race;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < race.getDistance(); i++) {
            try {
                Thread.sleep(race.getRandomSleepTime()); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Racer #%d completed step %d%n", number, i + 1);
        }

        race.setWinner(number);
    }
}
