package be.mobyus.concurrency;

import java.util.ArrayList;

public class Ex3 {

	private static int toCheck = 100000000;
	private static int threads = 10;

	public static void main(String[] args) {

		ArrayList<Range> list = new ArrayList<>();

		//---------------------------------
		//TODO divide the work to be be done in 'ranges'. A range is defined in function of the number of threads available.
		// For example, if we would need to scan 100 numbers for primes with 10 threads, each thread would receive a range of 10 numbers.
		// thread 1 would start with range 0-9, thread 2 from 10 till 19 , till thread 10 going from 90 till 99.
		// This has to be 'dynamic', if we change the number of threads or the amount of numbers to check, the list will contain more or fewer ranges.
		// You may assume that the numbers to check is always even and multiples of 10 (like 10, 100, 1000 etc)
		//---------------------------------
	}

	public static class Range {
		int start;
		int end;

		public Range(final int start, final int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n % 2 == 0) {
			return false;
		}
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
