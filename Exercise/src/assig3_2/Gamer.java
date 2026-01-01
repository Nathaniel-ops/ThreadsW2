package assig3_2;

public class Gamer implements Runnable {
    private int goodFlipsCounter = 0;
    private GamePlay game;

    public Gamer(GamePlay game) {
        this.game = game;
    }

    public void run() {
        play();
    }
    public void play() {
        while (!Thread.currentThread().isInterrupted() && game.getNumOfRounds() < 10) {
            int result = game.flipCoin();
            if (result == 1) {
                goodFlipsCounter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
    public int getScore() {
        return goodFlipsCounter;
    }
}
