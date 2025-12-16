package stocks;

public class StockReader extends Thread {
    private String personName;
    private StockServer server;


    public StockReader(String personName, StockServer server) {
        this.personName = personName;
        this.server = server;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            StockServer.Stock stock = getRandomStock();
            int val = server.GetStock(stock);
            System.out.println("Name: " + personName + ", " + stock + " Stock: " + val + " USD");
            try {
                int sleepMs = 1000 + (int)(Math.random() * 2000);
                Thread.sleep(sleepMs);
            } catch (InterruptedException e) {}
        }
    }


    private  StockServer.Stock getRandomStock() {
        StockServer.Stock[] stocks = StockServer.Stock.values();
         int index = (int)(Math.random() * stocks.length);
            return stocks[index];
        // שינוי של בדיקה
}
}