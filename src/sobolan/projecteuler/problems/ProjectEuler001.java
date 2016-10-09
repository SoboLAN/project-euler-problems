package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class ProjectEuler001 extends AbstractExecutableProblem
{
    private final int LIMIT = 1000;

    @Override
    public String getResult()
    {
        Integer result = 0;
        for (int i = 1; i < LIMIT; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                result += i;
            }
        }

        return result.toString();
    }
}
