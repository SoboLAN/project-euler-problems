package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class ProjectEuler34 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        int sum = 0;

        //the numbers the problem is reffering to are called Factorions: http://mathworld.wolfram.com/Factorion.html
        //and we know there are only 4 such numbers, each smaller than 41,000, which is why we choose that limit
        for (int i = 3; i < 41000; i++) {
            if (this.isEqualToFactorialDigits(i)) {
                sum += i;
            }
        }

        return Integer.toString(sum);
    }

    private boolean isEqualToFactorialDigits(int n)
    {
        int tmpN = n;
        int sum = 0;
        while (tmpN > 0) {
            sum += this.factorial(tmpN % 10);
            tmpN /= 10;
        }

        return (n == sum);
    }

    private int factorial(int digit)
    {
        switch (digit) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 24;
            case 5:
                return 120;
            case 6:
                return 720;
            case 7:
                return 5040;
            case 8:
                return 40320;
            case 9:
                return 362880;
            default:
                return 0;
        }
    }
}
