import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiplicaMatriz {

    public static void main(String[] args) {
        int[][] matrixA = null;
        int[][] matrixB = null;
        boolean isMatrixB = false;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\ws-java\\q4_SaulMarinho\\src\\matrizesss.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("Matrix A:")) {	
                    isMatrixB = false;
                    continue;
                } else if (line.equals("Matrix B:")) {
                    isMatrixB = true;
                    continue;
                }

                String[] values = line.split(" ");
                if (values.length == 0) {
                    // Skip empty lines
                    continue;
                }

                int[] row = new int[values.length];
                boolean isValid = true;
                for (int i = 0; i < values.length; i++) {
                    try {
                        row[i] = Integer.parseInt(values[i]);
                    } catch (NumberFormatException e) {
                        // Handle invalid input (non-integer value)
                        isValid = false;
                        break;
                    }
                }

                if (!isValid) {
                    // Handle invalid input (non-integer value)
                    System.out.println("Entrada inválida no arquivo.");
                    return;
                }

                if (!isMatrixB) {
                    matrixA = addToMatrix(matrixA, row);
                } else {
                    matrixB = addToMatrix(matrixB, row);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (matrixA != null && matrixB != null && matrixA[0].length == matrixB.length) {
            int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
            printMatrix(resultMatrix);
        } else {
            System.out.println("Matrizes inválidas para multiplicação.");
        }
    }

    public static int[][] addToMatrix(int[][] matrix, int[] row) {
        if (matrix == null) {
            matrix = new int[1][row.length];
            matrix[0] = row;
        } else {
            int[][] newMatrix = new int[matrix.length + 1][row.length];
            System.arraycopy(matrix, 0, newMatrix, 0, matrix.length);
            newMatrix[matrix.length] = row;
            matrix = newMatrix;
        }
        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
