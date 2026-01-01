package assig3_3;

public class OnionThread extends Thread {
    private SlicerMachine machine;
    private int num;

    public OnionThread(SlicerMachine machine,int n) {
        this.num = n;
        this.machine = machine;
    }
    public void run() {
        while (machine.getNumOfPreparedSalads() < num) {
            machine.addOneOnion();
        }
    }
}
