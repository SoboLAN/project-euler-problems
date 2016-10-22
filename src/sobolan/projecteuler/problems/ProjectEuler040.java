package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * An irrational decimal fraction is created by concatenating the positive integers:
 * 0.123456789101112131415161718192021...
 * It can be seen that the 12th digit of the fractional part is 1.
 * If d(n) represents the nth digit of the fractional part, find the value of the following expression.
 * d(1) x d(10) x d(100) x d(1000) x d(10000) x d(100000) x d(1000000)
 */
public class ProjectEuler040 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        int result =
            this.d(1)
            * this.d(10)
            * this.d(100)
            * this.d(1000)
            * this.d(10000)
            * this.d(100000)
            * this.d(1000000);

        return Integer.toString(result);
    }

    private int d(int index)
    {
        int totalLength = 0, currentIndex = 1;
        while(true) {
            String currentNumberAsString = Integer.toString(currentIndex);
            int currentLength = currentNumberAsString.length();

            if (totalLength + currentLength >= index) {
                int result = ((int) currentNumberAsString.charAt(index - totalLength - 1)) - 48;
                return result;
            } else {
                totalLength += currentLength;
            }

            currentIndex++;
        }
    }
}
