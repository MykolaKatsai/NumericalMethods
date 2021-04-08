package task2;

import java.util.Arrays;

public class LinearEquationsSolver {

    private static final double SCALE = Math.pow(10, 5);

    private static final double[][] EXTENDED_MATRIX_A = {
            {-8, 5, 3, 0, 1, -14},
            {-7, 3, -4, -1, 9, -34},
            {-6, 7, -3, 9, -6, -124},
            {-2, 9, -1, -4, -9, -48},
            {-3, -2, 0, 9, -7, -77}
    }; // input matrix A

    private static final double[][] EXTENDED_MATRIX_A1 = {
            {-6, -8, 0, 36},
            {3, -5, -7, 44},
            {5, -10, -1, 25}
    }; // input matrix A1

    public static void main(String[] args) {
        double[] answers = getAnswers(reduceToUpDiagonalMatrix(EXTENDED_MATRIX_A1));
        System.out.println(Arrays.toString(answers));

    }

    private static double[][] reduceToUpDiagonalMatrix(double[][] matrixA) {
        double[][] matrixRes = new double[matrixA.length][matrixA.length - 1];
        for (int i = 0; i < matrixA.length; i++) {
            matrixRes[i] = matrixA[i].clone();
        }

        //TODO: implement specific matrixE sort

        for (int k = 0; k < matrixRes.length; k++) {
            double kof1 = matrixRes[k][k];
            for (int j = k; j <= matrixRes.length; j++) {
                matrixRes[k][j] /= kof1;
            }

            for (int j = k + 1; j < matrixRes.length; j++) {

                double kof2 = matrixRes[j][k];
                for (int i = k; i <= matrixRes.length; i++) {
                    matrixRes[j][i] -= kof2 * matrixRes[k][i];

                }
            }

        }

        return matrixRes;
    }

    private static double[] getAnswers(double[][] matrixRes) {
        double[] answers = new double[matrixRes.length];

        answers[answers.length - 1] = Math.round(matrixRes[matrixRes.length - 1][matrixRes.length] * SCALE) / SCALE;

        for (int i = matrixRes.length - 2; i >= 0; i--) {
            double x_i = matrixRes[i][matrixRes.length];

            for (int j = i + 1; j < matrixRes.length; j++) {
                x_i -= matrixRes[i][j] * answers[j];
            }

            answers[i] = Math.round(x_i * SCALE) / SCALE;

        }

        return answers;
    }
}


//        -8 x1 + 5 x2 + 3 x3 + x5 = -14
//        -7 x1 + 3 x2 - 4 x3 - x4 + 9 x5 = -34
//        -6 x1 + 7 x2 - 3 x3 + 9 x4 - 6 x5 = -124
//        -2 x1 + 9 x2 - x3 - 4 x4 - 9 x5 = -48
//        -3 x1 - 2 x2 + 9 x4 - 7 x5 = -77