package sobolan.projecteuler.problems;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right,
 * by only moving to the right and down, is indicated in bold red and is equal to 2427.
 * 131 673 234 103 018
 * 201 096 342 965 150
 * 630 803 746 422 111
 * 537 699 497 121 956
 * 805 732 524 037 331
 * Find the minimal path sum, in matrix.txt (right click and "Save Link/Target As..."),
 * a 31K text file containing a 80 by 80 matrix, from the top left to the bottom right by only moving right and down.
 */
public class ProjectEuler81 extends AbstractExecutableProblem
{
    private final String FILE_PATH = "src/sobolan/projecteuler/problems/81.txt";
    private final int MATRIX_SIZE = 80;

    @Override
    public String getResult()
    {
        int[][] numbers = this.readMatrixFromFile();

        int[][] solutionMatrix = new int[this.MATRIX_SIZE][this.MATRIX_SIZE];

        solutionMatrix[0][0] = numbers[0][0];

        for (int i = 1; i < this.MATRIX_SIZE; i++) {
            solutionMatrix[0][i] = numbers[0][i] + solutionMatrix[0][i - 1];
        }

        for (int i = 1; i< this.MATRIX_SIZE; i++) {
            solutionMatrix[i][0] = numbers[i][0] + solutionMatrix[i - 1][0];
        }

        for (int i = 1; i < this.MATRIX_SIZE; i++) {
            for (int j = 1; j < this.MATRIX_SIZE; j++) {
                solutionMatrix[i][j] = numbers[i][j] + Math.min(solutionMatrix[i - 1][j], solutionMatrix[i][j - 1]);
            }
        }

        return Integer.toString(solutionMatrix[this.MATRIX_SIZE - 1][this.MATRIX_SIZE - 1]);
    }

    private int[][] readMatrixFromFile()
    {
        int[][] numbers = new int[this.MATRIX_SIZE][this.MATRIX_SIZE];

        try (BufferedReader buff = new BufferedReader(new FileReader(this.FILE_PATH))) {
            String line;
            int i = 0;

            while ((line = buff.readLine ()) != null) {
                String[] elements = line.split(",");

                numbers[i] = new int[elements.length];

                for (int j = 0; j < elements.length; j++) {
                    numbers[i][j] = Integer.parseInt(elements[j]);
                }

                i++;
            }
        }
        catch (Exception e) {
            System.err.println("There was an error while reading and parsing the file");
            System.exit(-1);
        }

        return numbers;
    }
}
