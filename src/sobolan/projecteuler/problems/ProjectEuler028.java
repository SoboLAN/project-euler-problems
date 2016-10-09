package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class ProjectEuler028 extends AbstractExecutableProblem
{
    private final int SPIRAL_SIZE = 1001;

    @Override
    public String getResult()
    {
        int oldRightDown = 3;
        int oldLeftDown = 5;
        int oldLeftUp = 7;
        int oldRightUp = 9;

        int sum = 1 + oldRightDown + oldLeftDown + oldLeftUp + oldRightUp;

        for (int i = 2; i <= (this.SPIRAL_SIZE - 1) / 2; i++) {
            int newRightDown = oldRightDown + 8 * (i - 1) + 2;
            int newLeftDown = oldLeftDown + 8 * (i - 1) + 4;
            int newLeftUp = oldLeftUp + 8 * (i - 1) + 6;
            int newRightUp = oldRightUp + 8 * (i - 1) + 8;

            sum += (newRightDown + newLeftDown + newLeftUp + newRightUp);

            oldRightDown = newRightDown;
            oldLeftDown = newLeftDown;
            oldLeftUp = newLeftUp;
            oldRightUp = newRightUp;
        }

        return Integer.toString(sum);
    }
}
