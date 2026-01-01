package Race;

public class Racer implements Runnable {
    private int globalId = 1;
    private int id = globalId;
    private int speed;
    private Track track;

    public Racer(int speed,Track track) {
        if (speed>= 1 && speed <= 10) {
            this.speed = speed;
        } else {
            System.err.println("Speed must be between 1-10");
            this.speed = 1;
        }
        this.track = track;
        this.id = globalId;
        globalId++;
    }
    public void go() {
        Thread.currentThread().setPriority(this.speed);
        for (int i = 1; i < 100; i++) {
            System.out.println("Runner " + this.id + " ran " + i + " meters");
        }
        synchronized (this.track) {
            this.track.finishedRacers++;
            int place = this.track.finishedRacers;
            String suffix;
            if (place == 1) {
                suffix = "st";
            } else if (place == 2) {
                suffix = "nd";
            } else if (place == 3) {
                suffix = "rd";
            } else {
                suffix = "th";
            }
            System.out.println("Runner " + this.id + " finished " + place + suffix);
        }
    }

    public void run() {
        go();
    }
}