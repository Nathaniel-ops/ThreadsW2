package assig3_3;

public class CucumbersThread extends Thread {
    private SlicerMachine machine;
    private int n;

    public CucumbersThread(SlicerMachine machine,int n) {
        this.n = n;
        this.machine = machine;
    }
    public void run() {
        while (machine.getNumOfPreparedSalads() < n) {
            machine.addOneCucumber();
        }
    }
}
