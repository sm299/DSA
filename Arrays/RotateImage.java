package Arrays;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        int[][] matrixBF = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixBF[i] = matrix[i].clone();
        }
        matrixBF = rotateBF(matrixBF);
        System.out.println("Brute Force");
        display(matrixBF);

        int[][] matrixOA = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixOA[i] = matrix[i].clone();
        }
        matrixOA = rotateOA(matrixOA);
        System.out.println("Optimal Approach");
        display(matrixOA);
    }

    public static int[][] rotateBF(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][m - 1 - i] = mat[i][j];

            }
        }
        return res;
    }

    // we will transpose and reverse
    // transpose means rows will be converted to column
    public static int[][] rotateOA(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // int[][] res = new int[n][m];
        for (int i = 0; i < n - 1; i++) { // we need to go till n-2, as last corner element
                                          // is diagonal, which won't be replaced
            for (int j = i + 1; j < m; j++) { // same logic as above for j starting at 1
                if (i != j) {
                    swap(mat, i, j);
                }
            }
        }
        reverseRows(mat);
        return mat;
    }

    private static void reverseRows(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    private static void swap(int[][] mat, int i, int j) {
        // TODO Auto-generated method stub
        mat[i][j] = mat[j][i] + mat[i][j];
        mat[j][i] = mat[i][j] - mat[j][i];
        mat[i][j] = mat[i][j] - mat[j][i];
    }

    public static void display(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}
