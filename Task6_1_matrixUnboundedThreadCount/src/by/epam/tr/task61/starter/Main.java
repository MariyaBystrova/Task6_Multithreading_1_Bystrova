package by.epam.tr.task61.starter;

import by.epam.tr.task61.lock.Lock;
import by.epam.tr.task61.starter.helper.Helper;

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

		int threadNumber = 8;
		
		Thread[] thread = Helper.createNumberThreads(threadNumber, m1, m2, res, lock);
		Helper.startNumberThreads(thread);
		Helper.joinNumberThreads(thread);
		
		Helper.printMatrix(res);
	}
}
