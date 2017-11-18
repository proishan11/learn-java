import java.util.Scanner;

public class MatrixMultiplication extends Thread{
	public static int[][] matrix1,matrix2,result;
	static int order, row_no;

	MatrixMultiplication(int i) {
		row_no = i;
		this.start();
	}

	public void run() {
		for(int i=0; i<order; ++i){
			result[row_no][i] = 0;
			for(int j=0; j<order; ++j)
				result[row_no][i] = result[row_no][i] + matrix1[row_no][i]*matrix2[j][i];
		}
		//printMatrix(matrix1, order);
	}

	public static void printMatrix(int matrix[][], int n) {
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j)
				System.out.print(matrix[i][j]+" ");
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the order of square matrix");
		order = input.nextInt();

		int[][] matrix1 = new int[order][order];
		int[][] matrix2 = new int[order][order];
		int[][] result = new int[order][order];

		System.out.println("Enter the entries of matrix1");
		for(int i=0; i<order; ++i) {
			for(int j=0; j<order; ++j) {
				matrix1[i][j] = input.nextInt();
			}
		}

		System.out.println("Enter the entries of matrix2");
		for(int i=0; i<order; ++i) {
			for(int j=0; j<order; ++j) {
				matrix2[i][j] = input.nextInt();
			}
		}
		System.out.println("First Matrix is");
		printMatrix(matrix1, order);
		System.out.println("Second matrix is");
		printMatrix(matrix2, order);
		MatrixMultiplication[] threads = new MatrixMultiplication[order];
		for(int i=0; i<order; ++i)
			threads[i] = new MatrixMultiplication(i);
		//printMatrix(result, order);

	}
}

/*class Multiply implements Runnable {
	public void run(){
		System.out.println("HEllo");
	}
}*/

