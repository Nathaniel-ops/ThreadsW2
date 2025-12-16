package stocks;

public class Main {

    public static void main(String[] args) {

        // a. יצירת אובייקט StockServer
        StockServer server = new StockServer();

        // b. 3 תהליכים שקוראים מניות (אחד לכל אחד מהאנשים)
        StockReader r1 = new StockReader("Alice", server);
        StockReader r2 = new StockReader("Bob", server);
        StockReader r3 = new StockReader("Charlie", server);

        // c. תהליך אחד שמעדכן מניות
        StockUpdateThread updater = new StockUpdateThread(server);

        // הפעלת כל התהליכים
        r1.start();
        r2.start();
        r3.start();
        updater.start();
    }
}
