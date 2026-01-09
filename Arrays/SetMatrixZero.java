package Arrays;

import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 }
        };

        int[][] matrixBF = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixBF[i] = matrix[i].clone();
        }
        matrixBF = makeZeroBF(matrixBF);
        System.out.println("Brute Force");
        display(matrixBF);

        int[][] matrixBA = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixBA[i] = matrix[i].clone();
        }
        matrixBA = makeZeroBA(matrixBA);
        System.out.println("Better Approach");
        display(matrixBA);

        int[][] matrixOA = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixOA[i] = matrix[i].clone();
        }
        matrixOA = makeZeroOA(matrixOA);
        System.out.println("Optimal Approach");
        display(matrixOA);
    }

    public static int[][] makeZeroBF(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    markRow(i, mat);
                    markCol(j, mat);
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }

    public static void markRow(int i, int[][] mat) {
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[i][j] != 0) {
                mat[i][j] = -1;
            }
        }
    }

    public static void markCol(int j, int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][j] != 0) {
                mat[i][j] = -1;
            }
        }
    }

    public static int[][] makeZeroBA(int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }

    public static int[][] makeZeroOA(int[][] mat) {
        int col1 = 1;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        col1 = 0;
                    } else {
                        mat[0][j] = 0;
                    }
                    mat[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    if (mat[0][j] == 0 || mat[i][0] == 0) {
                        mat[i][j] = 0;
                    }
                }
            }
        }

        if (mat[0][0] == 0) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[0][j] = 0;
            }
        }

        if (col1 == 0) {
            for (int i = 0; i < mat.length; i++) {
                mat[i][0] = 0;
            }
        }
        return mat;
    }

    public static void display(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}
