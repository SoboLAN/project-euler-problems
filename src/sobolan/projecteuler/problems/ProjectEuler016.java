package sobolan.projecteuler.problems;

import java.math.BigInteger;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */
public class ProjectEuler016 extends AbstractExecutableProblem
{
    private final int POWER = 1000;
    
    @Override
    public String getResult()
    {
        String twoToPowerX = BigInteger.valueOf(2).pow(this.POWER).toString();

        int result = 0;
        for (int i = 0; i < twoToPowerX.length(); i++) {
            result += (twoToPowerX.charAt(i) - 48);
        }
    
        return Integer.toString(result);
    }
}
