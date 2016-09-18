package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a <> b,
 * then a and b are an amicable pair and each of a and b are called amicable numbers.
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class ProjectEuler21 extends AbstractExecutableProblem
{
    private final int LIMIT = 10 * 1000;

    @Override
    public String getResult()
    {
        int amicableSum = 0;
        for (int a = 1; a < this.LIMIT; a++) {
            int divisorsSum = this.getSumOfDivisors(a);

            //it's important to compare the number to its divisors-sum as the first member of the AND expression
            //this speeds up the execution speed by making good use of boolean short-circuit
            if (a != divisorsSum && this.getSumOfDivisors(divisorsSum) == a) {
                amicableSum += a;
            }
        }

        return Integer.toString(amicableSum);
    }

    private int getSumOfDivisors(int number)
    {
        int sum = 1;

        int limit = (number / 2) + 1;

        for (int i = 2; i < limit; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
