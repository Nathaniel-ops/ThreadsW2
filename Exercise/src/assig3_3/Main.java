package assig3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		SlicerMachine slicer = new SlicerMachine();

		CucumbersThread c1 = new CucumbersThread(slicer,numOfSaladsToPrepare);
		OnionThread o1 = new OnionThread(slicer,numOfSaladsToPrepare);
		TomatoesThread t1 = new TomatoesThread(slicer,numOfSaladsToPrepare);
		SlicerThread s1 = new SlicerThread(slicer,numOfSaladsToPrepare);

		c1.start();
		o1.start();
		t1.start();
		s1.start();
		try {
			c1.join();
			o1.join();
			t1.join();
			s1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
		scan.close();
	}

}
