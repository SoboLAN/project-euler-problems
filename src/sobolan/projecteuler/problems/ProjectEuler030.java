package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 1^4 is not a sum it is not included.
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class ProjectEuler030 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        /**
         * The biggest part of the sum is 9^5 = 59,049 because 9 is the biggest digit.
         * For 6-digit numbers it still proportional, but not for 7-digit ones.
         * This is because 7 x (9^5) = 413,343, which an order of magnitude smaller than 9,999,999.
         * This means the biggest numbers we check are 6-digit ones, more specifically 6 x (9^5) = 354,294.
         */
        int sum = 0;
        for (int i = 2; i < 354294; i++) {
            if (i == this.getFifthPowerSumOfDigits(i)) {
                sum += i;
            }
        }

        return Integer.toString(sum);
    }

    private int getFifthPowerSumOfDigits(int number)
    {
        int result = 0;

        while (number > 0) {
            int digit = number % 10;

            result += (digit * digit * digit * digit * digit);

            number /= 10;
        }

        return result;
    }
}
