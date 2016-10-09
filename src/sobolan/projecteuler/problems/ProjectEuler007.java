package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
public class ProjectEuler007 extends AbstractExecutableProblem
{
    private final int N_TH_PRIME = 10001;

    @Override
    public String getResult()
    {
        Integer result = 0;
        for (int i = 2, primesFound = 0; i < Integer.MAX_VALUE; i++) {
            if (this.isPrime(i)) {
                primesFound++;

                if (primesFound == this.N_TH_PRIME) {
                    result = i;
                    break;
                }
            }
        }

        return result.toString();
    }

    private boolean isPrime(int number)
    {
        long squareRoot = Math.round(Math.sqrt(number));

        for (int i = 2; i <= squareRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
