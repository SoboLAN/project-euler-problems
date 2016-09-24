package sobolan.projecteuler.problems;

import java.util.Arrays;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
 * which means that 28 is a perfect number.
 * A number n is called deficient if the sum of its proper divisors is less than n
 * and it is called abundant if this sum exceeds n.
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
 * the smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis
 * even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class ProjectEuler23 extends AbstractExecutableProblem
{
    private final int LIMIT = 28123;

    @Override
    public String getResult()
    {
        boolean[] abundentNumbers = new boolean[this.LIMIT + 1];
        Arrays.fill(abundentNumbers, false);

        //from the problem statement we know that 12 is abundent
        abundentNumbers[12] = true;

        //if X is abundent, then abudentNumbers[X] will be TRUE
        for (int i = 13; i <= this.LIMIT; i++) {
            if (this.isAbundent(i)) {
                abundentNumbers[i] = true;
            }
        }

        boolean[] abundentSumNumbers = new boolean[this.LIMIT + 1];
        Arrays.fill(abundentSumNumbers, false);

        //if X can be written as sum of 2 abundent numbers, then numbers[X] will be TRUE
        for (int i = 0; i <= this.LIMIT; i++) {
            if (! abundentNumbers[i]) {
                continue;
            }

            for (int j = i; i + j <= this.LIMIT; j++) {
                if (abundentNumbers[j]) {
                    abundentSumNumbers[i + j] = true;
                }
            }
        }

        //if abundentSumNumbers[X] is false (can NOT be written as sum of 2 abundent numbers), then add it to the sum
        int sum = 0;
        for (int i = 0; i <= this.LIMIT; i++) {
            if (! abundentSumNumbers[i]) {
                sum += i;
            }
        }

        return Integer.toString(sum);
    }

    private boolean isAbundent(int number)
    {
        return this.getProperDivisorsSum(number) > number;
    }

    private int getProperDivisorsSum(int number)
    {
        int limit = (int) Math.round(Math.sqrt(number));
        int sum = 1;

        for (int i = 2; i <= limit; i++) {
            //the order of the 2 cases is important here, as the 2nd one is a more general case of the 1st one
            if (i * i == number) {
                sum += i;
            } else if (number % i == 0) {
                sum += (i + number / i);
            }
        }

        return sum;
    }
}
