package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * An irrational decimal fraction is created by concatenating the positive integers:
 * 0.123456789101112131415161718192021...
 * It can be seen that the 12th digit of the fractional part is 1.
 * If d(n) represents the nth digit of the fractional part, find the value of the following expression.
 * d(1) x d(10) x d(100) x d(1000) x d(10000) x d(100000) x d(1000000)
 */
public class ProjectEuler040 extends AbstractExecutableProblem
{
    private final int LIMIT = 1000 * 1000;

    @Override
    public String getResult()
    {
        StringBuilder fraction = new StringBuilder();

        int i = 1;
        while (fraction.length() <= this.LIMIT) {
            fraction.append(Integer.toString(i));
            i++;
        }

        int d1 = ((int) fraction.charAt(1 - 1)) - 48;
        int d10 = ((int) fraction.charAt(10 - 1)) - 48;
        int d100 = ((int) fraction.charAt(100 - 1)) - 48;
        int d1000 = ((int) fraction.charAt(1000 - 1)) - 48;
        int d10000 = ((int) fraction.charAt(10000 - 1)) - 48;
        int d100000 = ((int) fraction.charAt(100000 - 1)) - 48;
        int d1000000 = ((int) fraction.charAt(1000000 - 1)) - 48;

        return Integer.toString(d1 * d10 * d100* d1000 * d10000 * d100000 * d1000000);
    }
}
