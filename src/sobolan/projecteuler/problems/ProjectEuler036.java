package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class ProjectEuler036 extends AbstractExecutableProblem
{
    private final int LIMIT = 1000 * 1000;

    @Override
    public String getResult()
    {
        //if the number in base 10 is even, then in base 2 it would look like 1.....0.
        //we excluded cases like 0.....0 because the problem statement excludes them
        //therefore numbers that are even in base 10 can not be palindromes in base 2
        //which means we check only base-10-odd numbers, that is why the index increases like 1, 3, 5 etc.
        int sum = 0;
        for (int i = 1; i < this.LIMIT; i += 2) {
            if (this.isPalindrome(i, 10) && this.isPalindrome(i, 2)) {
                sum += i;
            }
        }

        return Integer.toString(sum);
    }

    private boolean isPalindrome(int number, int base)
    {
        int mirror = 0;
        int tmpNumber = number;
        while (tmpNumber > 0) {
            mirror = mirror * base + tmpNumber % base;
            tmpNumber /= base;
        }

        return (mirror == number);
    }
}
