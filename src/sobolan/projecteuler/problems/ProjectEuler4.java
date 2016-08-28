package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class ProjectEuler4 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        Integer biggestPalindrome = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int product = i * j;

                if (this.isPalindrome(product)) {
                    biggestPalindrome = (product > biggestPalindrome) ? product : biggestPalindrome;
                }
            }
        }

        return biggestPalindrome.toString();
    }

    private boolean isPalindrome (int nr)
    {
        int reversenr = 0;
        int tmp_nr = nr;

        while (tmp_nr > 0)
        {
            int digit = tmp_nr % 10;

            reversenr = reversenr * 10 + digit;

            tmp_nr /= 10;
        }

        return (reversenr == nr);
    }
}
