package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers
 * and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class ProjectEuler6 extends AbstractExecutableProblem
{
    private final int LIMIT = 100;

    @Override
    public String getResult()
    {
        long sumOfSquares = 0;
        for (int i = 1; i <= this.LIMIT; i++) {
            sumOfSquares += (i * i);
        }

        long sum = this.LIMIT * (this.LIMIT + 1) / 2;
        long squareOfSum = sum * sum;

        Long result = squareOfSum - sumOfSquares;

        return result.toString();
    }
}
