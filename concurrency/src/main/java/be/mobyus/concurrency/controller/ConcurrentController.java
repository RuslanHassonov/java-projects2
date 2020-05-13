package be.mobyus.concurrency.controller;

public class ConcurrentController {

	public void searchSlow() {
		System.err.println("Staring slow search...");

		// Simulating long running process that takes 20 seconds to complete
		try {
			Thread.sleep(20000);
			System.err.println("Slow search done!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchFast() {
		System.err.println("Staring fast search...");
		System.err.println("Fast search done!");
	}
}
