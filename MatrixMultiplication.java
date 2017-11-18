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
		
		for(int i=0; i<order; ++i) 
			for(int j=0; j<order; ++j) 
				matrix1[i][j] = rand.nextInt(50)+1;
		
		for(int i=0; i<order; ++i) 
			for(int j=0; j<order; ++j) 
				matrix2[i][j] = rand.nextInt(50)+1;
		
		Thread threads[] = new Thread[order];
		for(int i=0; i<order; ++i){
			threads[i] = new Thread(new Multiply(i,order));
			threads[i].start();
		}
		long startTime2 = System.nanoTime();
		for(int i=0; i<order; ++i){
			try{threads[i].join();}
			catch(Exception e){
				System.out.println("Exception caught");
			}
		}
		long endTime2 = System.nanoTime();

		printMatrix(result,order);

		long startTime1 = System.nanoTime();
		for(int row_no=0; row_no<order; ++row_no){
			for(int i=0; i<order; ++i){
				result[row_no][i] = 0;
				for(int j=0; j<order; ++j)
					result[row_no][i] = result[row_no][i] + matrix1[row_no][j]*matrix2[j][i];
			}
		}
		long endTime1 = System.nanoTime();

		System.out.println("First Matrix is");
		printMatrix(matrix1, order);
		System.out.println("Second matrix is");
		printMatrix(matrix2, order);
		System.out.println("The product is:");
		printMatrix(result, order);
		
		System.out.println("Running time of the program normally  is "+(endTime1-startTime1)+ " nanoseconds");
		System.out.println("Running time of the program using Multithreading is " + (endTime2-startTime2) + " nanoseconds");
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