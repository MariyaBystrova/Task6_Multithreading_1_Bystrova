package by.epam.tr.task62.starter;


import by.epam.tr.task61.lock.Lock;
import by.epam.tr.task61.thread.CalcThread;

import by.epam.tr.task62.starter.helper.MatrixHelper;

public class Main {

	public static void main(String[] args) {

			int[][] m1 = new int[][]{
										{1,2,3,4},
										{4,5,6,5},
										{7,8,9,6},
										{1,2,3,7}
									};
			int[][] m2 = new int[][]{
										{9,8,7,6},
										{6,5,4,7},
										{3,2,1,8},
										{9,8,7,9}
									};
			int[][] res = new int[m1.length][m1[0].length];
			Lock lock = new Lock(m1.length);

			
			CalcThread thr1 = new CalcThread(m1, m2, res, lock);
			CalcThread thr2 = new CalcThread(m1, m2, res, lock);
			
			thr1.setName("Thread_1");
			thr2.setName("Thread_2");

			thr1.start();
			thr2.start();
			
			try {
				thr1.join();
				thr2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			MatrixHelper.printMatrix(res);
	}

}
