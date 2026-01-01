package assig3_3;

public class SlicerMachine {
	
	private int numOfCucumbers = 0;
	private int numOfTomatoes = 0;
	private int numOfOnions = 0;
	private int numOfPreparedSalads = 0;
	
	final int cucumbersNeededForOneSalad = 5;
	final int tomatoesNeededForOneSalad = 3;
	final int onionsNeededForOneSalad = 1;
	
	// add one cucumber into the slicer chamber
	public synchronized void addOneCucumber() {
		while (numOfCucumbers >= cucumbersNeededForOneSalad) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
			System.out.println("adding one cucumber to the machine");
			numOfCucumbers++;
			notifyAll();

	}


	// add one onion into the slicer chamber
	public synchronized void addOneOnion() {
		while (numOfOnions >= onionsNeededForOneSalad) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("adding one onion to the machine");
		numOfOnions++;
		notifyAll();
	}

	// add one tomato into the slicer chamber
	public synchronized void addOneTomato() {
		while (numOfTomatoes >= tomatoesNeededForOneSalad) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("adding one tomato to the machine");
		numOfTomatoes++;
		notifyAll();
	}
	
	// if there are enough vegetables in the slicer
	// chamber, make another salad
	public synchronized void sliceVegetables() {
		while ((numOfOnions < onionsNeededForOneSalad) || (numOfCucumbers < cucumbersNeededForOneSalad) || (numOfTomatoes < tomatoesNeededForOneSalad)) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		makeNewSalad();
		notifyAll();
	}

	public synchronized void makeNewSalad() {
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++; 
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
		numOfOnions = numOfOnions - onionsNeededForOneSalad;
	}

	public synchronized int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}

}
