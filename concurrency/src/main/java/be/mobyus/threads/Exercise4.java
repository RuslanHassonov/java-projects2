package be.mobyus.threads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class Exercise4 {

	public static String[] words = new String[] { "this", "that", "some", "succ", "poss", "frei", "ligh", "heav", "over", "unde", "upsi", "neve", "besi", "luck", "neok",
			"neaj", "nonj", "eood", "rand", "hous", "gard", "tele", "comp" };

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();

		//---------------------------------
		//TODO You can change this variable to control how many threads the thread pool will use
		// 	   when your solution is done, you can 'play' with this value to see how the performance of the application changes
		//	   you will notice that there is a threshhold (depending on your machine) after which performance does no longer increase.
		//     however, the performance should increase a lot between '1' (single threaded) and 'thresshold value'. The threshhold value
		//     is mostly around the number of cores your CPU has (including Hyperthreads)
		//---------------------------------
		int numberOfThreads = 2;

		//We create a ExecutorService with a custom ThreadFactory just so we can give the created threads a name
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads, new ThreadFactory() {
			private final ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
			private int threadNumber = 1;

			public Thread newThread(Runnable r) {
				Thread thread = defaultThreadFactory.newThread(r);
				thread.setName("mobyus-thread-pool-" + threadNumber++);
				System.err.println("Creating thread:" + thread.getName());
				return thread;
			}
		});

		System.err.println("Firing up " + numberOfThreads + " threads, for " + words.length + " words");
		executeSearchAndDisplayResults(executorService);
		long duration = System.currentTimeMillis() - start;
		System.err.println("All done. Took:" + duration / 1000 + " seconds and " + duration % 1000 + " milliseconds");
	}

	public static void executeSearchAndDisplayResults(ExecutorService executorService) {

		Collection<Future<Result>> results = new ArrayList<>();

		//---------------------------------
		//TODO submit 'FileScanner' jobs to the executor service
		//---------------------------------

		results.forEach((f) -> {
			try {
				System.err.println(f.get().getWord() + " - " + f.get().getMatches());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	static class FileScanner implements Callable<Result> {
		public Result call() throws Exception {

			//---------------------------------
			//TODO process word (ie. check if word exists in file and how many times)
			//     return a result instead of null
			//---------------------------------
			return null;
		}
	}

	static class Result {
		private String word;
		private int matches;

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

		public int getMatches() {
			return matches;
		}

		public void setMatches(int matches) {
			this.matches = matches;
		}
	}
}
