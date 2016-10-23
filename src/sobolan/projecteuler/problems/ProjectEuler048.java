package sobolan.projecteuler.problems;

import java.math.BigInteger;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class ProjectEuler048 extends AbstractExecutableProblem
{
    private final int NR_DIGITS = 10;

    @Override
    public String getResult()
    {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }

        String bigString = sum.toString();

        return bigString.substring(bigString.length() - NR_DIGITS);
    }
}
