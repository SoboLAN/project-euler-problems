package sobolan.projecteuler.problems;

import java.math.BigInteger;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * How many such routes are there through a 20×20 grid?
 */
public class ProjectEuler15 extends AbstractExecutableProblem
{
    private final int HEIGHT = 20;
    private final int WIDTH = 20;

    @Override
    public String getResult()
    {
        //formula is (HEIGHT + WIDTH) ! / (HEIGHT ! x WIDTH !)

        BigInteger result = factorial(this.HEIGHT + this.WIDTH)
            .divide(factorial(this.HEIGHT))
            .divide(factorial(this.WIDTH));

        return result.toString();
    }
    
    private BigInteger factorial(int limit)
    {
        BigInteger result = BigInteger.valueOf(2);
        
        for (int i = 3; i <= limit; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        return result;
    }
}
