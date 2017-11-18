import java.util.Scanner;
import java.util.Random;


public class MatrixMultiplication{
	public static int[][] matrix1,matrix2,result;
	static int order;
	public static void printMatrix(int matrix[][], int n) {
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j)
				System.out.print(matrix[i][j]+" ");
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the order of square matrix");
		order = input.nextInt();

		matrix1 = new int[order][order];
		matrix2 = new int[order][order];
		result = new int[order][order];

		System.out.println("Enter the entries of matrix1");
		for(int i=0; i<order; ++i) 
			for(int j=0; j<order; ++j) 
				//matrix1[i][j] = input.nextInt();
				matrix1[i][j] = rand.nextInt(50)+1;
		System.out.println("Enter the entries of matrix2");
		for(int i=0; i<order; ++i) 
			for(int j=0; j<order; ++j) 
				//matrix2[i][j] = input.nextInt();
				matrix2[i][j] = rand.nextInt(50)+1;
		/*Thread thread1 = new Thread(new Multiply(0,order));
		Thread thread2 = new Thread(new Multiply(1,order));
		Thread thread3 = new Thread(new Multiply(2,order));
		thread1.start();
		thread2.start();
		thread3.start();*/
		long startTime = System.nanoTime();
		Thread threads[] = new Thread[order];
		for(int i=0; i<order; ++i){
			threads[i] = new Thread(new Multiply(i,order));
			threads[i].start();
		}

		
		System.out.println("First Matrix is");
		printMatrix(matrix1, order);
		System.out.println("Second matrix is");
		printMatrix(matrix2, order);
		System.out.println("The product is:");
		printMatrix(result, order);
		//timer.stop();
		//System.out.println(timer.getElapsedTime());
		long endTime = System.nanoTime();
		System.out.println("Running time of the program is " + (endTime-startTime) + " nanoseconds");
		/*Thread threads = new Thread[order];
		for(int i=0; i<order; ++i)
			threads[i] = new MatrixMultiplication(i);
		//printMatrix(result, order);*/

	}
}

class Multiply implements Runnable {
	private int row_no, order;
	public Multiply(int row_no, int order){
		this.row_no = row_no;
		this.order = order;
	}

	public void run(){
		for(int i=0; i<order; ++i){
			MatrixMultiplication.result[row_no][i] = 0;
			for(int j=0; j<order; ++j)
				MatrixMultiplication.result[row_no][i] = MatrixMultiplication.result[row_no][i] + MatrixMultiplication.matrix1[row_no][j]*MatrixMultiplication.matrix2[j][i];
		}
	}
}


