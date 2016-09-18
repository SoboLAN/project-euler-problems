package sobolan.projecteuler.problems;

import java.math.BigInteger;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * n! means n x (n − 1) x ... x 3 x 2 x 1
 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 */
public class ProjectEuler20 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        BigInteger number = BigInteger.ONE;

        for (int i = 2; i <= 100; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }

        String numberString = number.toString();

        int sum = 0;
        for (int i = 0; i < numberString.length(); i++) {
            sum += (numberString.charAt(i) - 48);
        }

        return Integer.toString(sum);
    }
}
