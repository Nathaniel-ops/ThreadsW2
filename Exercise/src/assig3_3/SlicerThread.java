package assig3_3;

public class SlicerThread extends Thread {
	private SlicerMachine machine;
    private int n;

    public SlicerThread(SlicerMachine machine,int n) {
        this.machine = machine;
        this.n = n;
    }
	public void run() {
        while (machine.getNumOfPreparedSalads() < n) {
            machine.sliceVegetables();
        }
    }

}
