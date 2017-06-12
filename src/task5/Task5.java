package task5;

/**
 * Created by Anastasia on 11.06.2017.
 */
public class Task5 {

    public static int[][] getMatrix(int n){
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            matrix[i][i] = 1;
            matrix[i][n-i-1] = 1;
        }

        return matrix;
    }

    public static void printMatrix(int matrix[][]){
        for (int i = 0, lengthDim1 = matrix.length; i < lengthDim1; i++){
            for (int j = 0, lengthDim2 = matrix[0].length ; j < lengthDim2; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }
}
