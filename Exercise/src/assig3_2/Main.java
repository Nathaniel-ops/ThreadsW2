package assig3_2;

public class Main {
    public static void main(String[] args) {
        GamePlay game = new GamePlay();

        Gamer g1 = new Gamer(game);
        Gamer g2 = new Gamer(game);

        Thread t1 = new Thread(g1, "0");
        Thread t2 = new Thread(g2, "1");

        Judge judge = new Judge(game);

        // התחלת המשחק
        t1.start();
        t2.start();
        judge.start();

        // מחכים שהשחקנים יסיימו לשחק (10 סיבובים)
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // עוצרים את השופט אחרי שהמשחק נגמר
        judge.interrupt();

        // הדפסת תוצאה – רק אחרי שהשחקנים סיימו
        if (g1.getScore() > g2.getScore()) {
            System.out.println("player 1 wins");
        } else if (g2.getScore() > g1.getScore()) {
            System.out.println("player 2 wins");
        } else {
            System.out.println("tie");
        }
    }
}
