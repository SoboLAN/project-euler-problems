package sobolan.projecteuler.problems;

import java.util.Arrays;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The first two consecutive numbers to have two distinct prime factors are:
 * 14 = 2 x 7
 * 15 = 3 x 5
 * The first three consecutive numbers to have three distinct prime factors are:
 * 644 = 2^2 x 7 x 23
 * 645 = 3 x 5 x 43
 * 646 = 2 x 17 x 19.
 * Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
 */
public class ProjectEuler047 extends AbstractExecutableProblem
{
    private int[] primes;
    private final int PRIME_COUNT = 9000;

    @Override
    public String getResult()
    {
        this.primes = new int[this.PRIME_COUNT];

        for (int i = 2, count = 0; i < Integer.MAX_VALUE && count < this.PRIME_COUNT; i++) {
            if (this.isPrime(i)) {
                this.primes[count++] = i;
            }
        }

        int[] cache = new int[200000];
        Arrays.fill(cache, -1);

        //since I know that the sequence 644,645,646 has only 3 distinct prime factors,
        //let's start here (save some time :) )
        //i make i++ instead of i += 4 in order not to miss the result because of
        //too big of a jump
        for (int i = 644; i < Integer.MAX_VALUE; i++) {
            int pos1 = i;
            int pos2 = i + 1;
            int pos3 = i + 2;
            int pos4 = i + 3;

            cache[pos1] = (cache[pos1] == -1) ? this.getNrOfDistinctPrimeFactors(pos1) : cache[pos1];
            cache[pos2] = (cache[pos2] == -1) ? this.getNrOfDistinctPrimeFactors(pos2) : cache[pos2];
            cache[pos3] = (cache[pos3] == -1) ? this.getNrOfDistinctPrimeFactors(pos3) : cache[pos3];
            cache[pos4] = (cache[pos4] == -1) ? this.getNrOfDistinctPrimeFactors(pos4) : cache[pos4];

            if (cache[pos1] == 4 && cache[pos2] == 4 && cache[pos3] == 4 && cache[pos4] == 4) {
                return Integer.toString(pos1);
            }
        }

        return Integer.toString(0);
    }

    private int getNrOfDistinctPrimeFactors(int number)
    {
        int result = 0;
        int count = 0;
        int divisor = this.primes[count];

        while (number != 1) {
            if (number % divisor == 0) {
                while (number % divisor == 0) {
                    number /= divisor;
                }

                result++;
            }

            count++;

            divisor = (count < this.PRIME_COUNT) ? this.primes[count] : divisor + 2;
        }

        return result;
    }

    private boolean isPrime(int number)
    {
        if (number < 6) {
            return (number == 2 || number == 3 || number == 5);
        }

        if (number % 2 == 0 || number % 10 == 5) {
            return false;
        }

        if ((number - 1) % 6 != 0 && (number + 1) % 6 != 0) {
            return false;
        }

        int squareRoot = (int) Math.sqrt (number);

        for (int i = 3; i <= squareRoot; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
