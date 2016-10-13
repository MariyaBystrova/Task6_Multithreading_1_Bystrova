package by.epam.tr.task61.lock;

public class Lock {
	private int[][] lock;
	private int row = 0;
	private int col = 0;
	private int count = 0;

	public Lock(int n) {
		lock = new int[n][n];
	}

	public int[] nextElementIndexes() {
		if (isProcessed()) {
			throw new IllegalStateException("Already fully done.");
		}
		int[] res = new int[2];
		if(count == 0){
			res[0] = row;
			res[1] = col;
			count++;
			return res;
		}
		if (col + 1 < lock.length) {
			res[0] = row;
			col++;
			res[1] = col;
		}else{
			row++;
			res[0] = row;
			col=0;
			res[1] = col;
		}
		count++;
		return res;
		
	}

	public boolean isProcessed() {
		if (count==lock.length*lock.length) {
			return true;
		}
		return false;
	}
}
