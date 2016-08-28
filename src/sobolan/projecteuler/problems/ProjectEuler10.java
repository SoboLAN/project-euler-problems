package sobolan.projecteuler.problems;

import java.util.Arrays;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
public class ProjectEuler10 extends AbstractExecutableProblem
{
    private final int PRIMES_LIMIT = 2 * 1000 * 1000;

    @Override
    public String getResult()
    {
        //placeholder for every number up to PRIMES_LIMIT
        boolean[] allNumbers = new boolean[this.PRIMES_LIMIT];

        //allNumbers[i] is true if the number i is a prime
        //at first, let's assume every number is prime
        Arrays.fill(allNumbers, 0, PRIMES_LIMIT, true);

        //since we'll start with 2, let's mark the first 2 manually,
        //so as not to disturb us in the loop :)
        allNumbers[0] = allNumbers[1] = false;

        //implementation of the Sieve of Eratosthenes
        int limit = (int) Math.sqrt(this.PRIMES_LIMIT) + 1;
        for (int i = 2; i < limit; i++) {
            if (allNumbers[i]) {
                for (int j = i * i; j < this.PRIMES_LIMIT; j += i) {
                    if (allNumbers[j]) {
                        allNumbers[j] = false;
                    }
                }
            }
        }

        long sum = 0;
        //go through the numbers. if we find a prime, we add it to the sum
        for (int i = 0; i < this.PRIMES_LIMIT; i++) {
            if (allNumbers[i]) {
                sum += i;
            }
        }

        return Long.toString(sum);
    }
}
