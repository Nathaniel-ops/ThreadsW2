package assig3_3;

public class TomatoesThread extends Thread {
        private SlicerMachine machine;
        private int num;

        public TomatoesThread(SlicerMachine machine,int n) {
            this.num = n;
            this.machine = machine;
        }
        public void run() {
            while (machine.getNumOfPreparedSalads() < num) {
                machine.addOneTomato();
            }
        }
    }


