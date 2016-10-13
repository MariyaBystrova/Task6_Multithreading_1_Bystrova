package by.epam.tr.task61.starter.helper;

import by.epam.tr.task61.lock.Lock;
import by.epam.tr.task61.thread.CalcThread;

public class Helper {

	public static void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static Thread[] createNumberThreads(int n, int[][] m1, int[][] m2, int[][] res, Lock lock) {
		Thread[] thread = new CalcThread[n];
		for (int i = 0; i < n; i++) {
			thread[i] = new CalcThread(m1, m2, res, lock);
			thread[i].setName("Thread" + (i+1));
		}
		return thread;
	}

	public static void startNumberThreads(Thread[] thread) {
		for (int i = 0; i < thread.length; i++) {
			thread[i].start();
		}
	}

	public static void joinNumberThreads(Thread[] thread) {
		try {
			for (int i = 0; i < thread.length; i++) {
				thread[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
