package assig3_2;

public class Judge extends Thread {
    private GamePlay game;

    public Judge(GamePlay game) {
        this.game = game;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            game.makeCoinAvil(false);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            game.makeCoinAvil(true);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
