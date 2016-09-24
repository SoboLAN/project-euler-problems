package sobolan.projecteuler.problems;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 * Find the maximum total from top to bottom of the triangle below:
 *                 75
 *               95 64
 *              17 47 82
 *            18 35 87 10
 *           20 04 82 47 65
 *          19 01 23 75 03 34
 *         88 02 77 73 07 63 67
 *        99 65 04 28 06 16 70 92
 *       41 41 26 56 83 40 80 70 33
 *      41 48 72 33 47 32 37 16 94 29
 *     53 71 44 65 25 43 91 52 97 51 14
 *    70 11 33 28 77 73 17 78 39 68 17 57
 *   91 71 52 38 17 14 91 43 58 50 27 29 48
 *  63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows;
 * it cannot be solved by brute force, and requires a clever method! ;o)
 */
public class ProjectEuler18 extends AbstractExecutableProblem
{
    private final String FILE_PATH = "src/sobolan/projecteuler/problems/18.txt";

    @Override
    public String getResult()
    {
        int[][] numbers = this.readTriangleFromFile();

        /**
         * The algorithm has a complexity of O(n^2), where n is the number of rows of the triangle
         * Starting from the top and going through every path possible is...a trap
         * A reverse thinking fits better here, which is why we start from the bottom and go to the top
         * To each number, we will add the biggest of the 2 numbers below
         * This way, the top-most number will have the maximum total that we're looking for
         */
        for (int i = numbers.length - 1; i >= 1; i--) {
            int[] aboveLine = numbers[i - 1];
            int[] currentLine = numbers[i];

            for (int j = 0; j < aboveLine.length; j++) {
                aboveLine[j] += Math.max(currentLine[j], currentLine[j + 1]);
            }
        }

        return Integer.toString(numbers[0][0]);
    }

    private int[][] readTriangleFromFile()
    {
        int[][] numbers = new int[15][1];

        try (BufferedReader buff = new BufferedReader(new FileReader(this.FILE_PATH))) {
            String line;
            int i = 0;

            while ((line = buff.readLine ()) != null) {
                String[] elements = line.split(" ");

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
