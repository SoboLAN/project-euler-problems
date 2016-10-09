package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The number 3797 has an interesting property.
 * Being prime itself, it is possible to continuously remove digits from left to right,
 * and remain prime at each stage: 3797, 797, 97, and 7.
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class ProjectEuler037 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        int truncatableFound = 0;
        int sum = 0;

        //we don't know how big the numbers will get, so we'll go up to maximum value of ints
        for (int i = 10; i < Integer.MAX_VALUE; i++) {
            if (this.isTruncatablePrime(i)) {
                truncatableFound++;
                sum += i;

                if (truncatableFound == 11) {
                    break;
                }
            }
        }

        return Integer.toString(sum);
    }

    private boolean isPrime(int number)
    {
        if (number < 2) {
            return false;
        }

        int squareRoot = (int) Math.sqrt(number);
        for (int i = 2; i <= squareRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isTruncatablePrime(int number)
    {
        /**
         * All truncatable primes end in 3 or 7
         * They cannot end in anything else since that would make them not prime at some point during removal of digits
         */
        if (number % 10 != 3 && number % 10 != 7) {
            return false;
        }

        int rightToLeft = number;
        int leftToRight = 0;
        int multiplier = 1;
        while (rightToLeft != 0) {

            leftToRight += (multiplier * (rightToLeft % 10));
            if (! this.isPrime(leftToRight)) {
                return false;
            }

            if (! this.isPrime(rightToLeft)) {
                return false;
            }

            rightToLeft /= 10;
            multiplier *= 10;
        }

        return true;
    }
}
