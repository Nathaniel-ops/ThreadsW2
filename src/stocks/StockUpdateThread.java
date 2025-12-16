package stocks;

import java.util.concurrent.ThreadLocalRandom;

public class StockUpdateThread extends Thread {

    private final StockServer server;

    public StockUpdateThread(StockServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            // עדכון כל סוגי המניות
            for (StockServer.Stock stock : StockServer.Stock.values()) {
                int value = ThreadLocalRandom.current().nextInt(100, 501); // 100..500
                server.UpdateStock(stock, value);
            }

            // ישן 1 שנייה
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
