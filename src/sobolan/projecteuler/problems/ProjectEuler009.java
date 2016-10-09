package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class ProjectEuler009 extends AbstractExecutableProblem
{
    private final int LIMIT = 1000;

    @Override
    public String getResult()
    {
        //from the conditions a<b<c and a+b+c=LIMIT,
        //we deduce the following condition given max value of a: a+a+1+a+2=LIMIT => a=(LIMIT-3)/3
        for (int a = 1; a <= (this.LIMIT - 3) / 3; a++) {
            //we start from a+1 because we know a<b<c.
            //also, from the condition a+b+c=LIMIT, we deduce the following condition for max value of b:
            //a+b+b+1=LIMIT => b=(LIMIT-a-1)/2
            for (int b = a + 1; b <= (this.LIMIT - a - 1) / 2; b++) {
                int c = this.LIMIT - a - b;
                if (a * a + b * b == c * c) {
                    return Integer.toString(a * b * c);
                }
            }
        }

        return Integer.toString(-1);
    }
}
