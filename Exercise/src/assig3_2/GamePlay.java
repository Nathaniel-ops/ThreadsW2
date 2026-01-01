package assig3_2;

public class GamePlay {
    private boolean coin_avaliable_;
    private int rounds_counter_;


    public synchronized void makeCoinAvil(boolean val) {
            coin_avaliable_ = val;

            if(val) {
                notifyAll();
        }

    }
    public synchronized int flipCoin() {
        while (!coin_avaliable_) {
            System.out.println("Thread-" + Thread.currentThread().getName() + " is waiting for coin");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Thread-" + Thread.currentThread().getName() + " is flipping coin");
        makeCoinAvil(false);
        rounds_counter_++;
        int result = (int)(Math.random() * 2);
        makeCoinAvil(true);

        return result;

    }
    public synchronized int getNumOfRounds() {
        return rounds_counter_;
    }
}
