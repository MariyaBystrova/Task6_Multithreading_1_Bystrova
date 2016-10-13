package by.epam.tr.task61.thread;

import by.epam.tr.task61.lock.Lock;

public class CalcThread extends Thread {

	private int[][] matrix1;
	private int[][] matrix2;
	private int[][] res;
	private Lock lock;

	public CalcThread(int[][] matr1, int[][] matr2, int[][] res, Lock lock) {
		this.matrix1 = matr1;
		this.matrix2 = matr2;
		this.res = res;
		this.lock = lock;
	}

	@Override
	public void run() {
		int i = 0;
		int j = 0;
		while (true) {
			
			int[] elem = getNextElementToCalculate();
			if(elem == null){
				break;
			}
			i = elem[0];
			j = elem[1];
			
			showCalculatingThread(i,j);
			
			for (int k = 0; k < res.length; k++) {
				res[i][j] += matrix1[i][k] * matrix2[k][j];
			}
		}
	}
	
	private int[] getNextElementToCalculate(){
		synchronized (lock) {
			if(lock.isProcessed()){
				return null;
			}
			int[] elem = lock.nextElementIndexes();
			return elem;
		}
	}
	
	private void showCalculatingThread(int i, int j){
		System.out.println("(" + i + "," + j + ") " + Thread.currentThread().getName());
	}
}
