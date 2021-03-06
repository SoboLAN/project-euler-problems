package sobolan.projecteuler.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * Let us list the factors of the first seven triangle numbers:
 *  1: 1
 *  3: 1,3
 *  6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * We can see that 28 is the first triangle number to have over five divisors.
 * What is the value of the first triangle number to have over five hundred divisors?
 */
public class ProjectEuler012 extends AbstractExecutableProblem
{
    private final int NR_MAX_DIVISORS = 500;
    private final int MAX_VAL_OF_PRIMES = 1 * 1000 * 1000;
    private boolean[] primes;
    private int primeCursor = 0;

    @Override
    public String getResult()
    {
        int maxNrOfDivisors = 0;
        int triangle = 0;

        this.generatePrimes();

        //we start at 5 because, from the problem statement, we know that the 5th triangle number has only 6 divisors
        for (int i = 5; i < Integer.MAX_VALUE; i++) {
            //calculate the triangle value
            triangle = (i * i + i) / 2;

            /**
             * If N can be written as N = p^a x q^b x r^c (where p, q and r are prime factors),
             * then the number of divisors of N is (a + 1) x (b + 1) x (c + 1)
             * This is known as the Tau function.
             * @see http://mathschallenge.net/library/number/number_of_divisors
             */
            int[][] primeFactors = this.getPrimeFactors(triangle);
            int nrOfDivisors = 1;
            for (int[] primeFactor : primeFactors) {
                nrOfDivisors *= (primeFactor[1] + 1);
            }

            if (nrOfDivisors > this.NR_MAX_DIVISORS) {
                break;
            }
        }

        return Integer.toString(triangle);
    }

    private void generatePrimes()
    {
        this.primes = new boolean[this.MAX_VAL_OF_PRIMES];

        //primes[i] is true if the number i is a prime
        //at first, let's assume every number is prime
        Arrays.fill(this.primes, 0, this.MAX_VAL_OF_PRIMES, true);

        //since we'll start with 2, let's mark the first 2 manually,
        //so as not to disturb us in the loop :)
        this.primes[0] = this.primes[1] = false;

        //implementation of the Sieve of Eratosthenes
        int limit = (int) Math.sqrt(this.MAX_VAL_OF_PRIMES) + 1;
        for (int i = 2; i < limit; i++) {
            if (this.primes[i]) {
                for (int j = i * i; j < this.MAX_VAL_OF_PRIMES; j += i) {
                    if (this.primes[j]) {
                        this.primes[j] = false;
                    }
                }
            }
        }
    }

    private int getNextPrimeFactor()
    {
        for (int i = this.primeCursor + 1; i < this.primes.length; i++) {
            if (this.primes[i] == true) {
                this.primeCursor = i;
                return i;
            }
        }

        if (this.primeCursor % 2 == 0) {
            this.primeCursor++;
        }

        return this.primeCursor;
    }

    private void resetSieveCursor()
    {
        this.primeCursor = 0;
    }

    private int[][] getPrimeFactors(int x)
    {
        //check if x is a perfect square
        int sqrtX = (int) Math.sqrt(x);
        if (sqrtX * sqrtX == x) {
            int[][] result = new int[1][2];
            result[0][0] = sqrtX;
            result[0][1] = 2;

            return result;
        }

        this.resetSieveCursor();

        ArrayList<Integer> factors = new ArrayList<>();
        ArrayList<Integer> powers = new ArrayList<>();
        int factor = this.getNextPrimeFactor();
        while (x > 1) {
            if (x % factor == 0) {
                factors.add(factor);
                int power = 0;
                while (x % factor == 0) {
                    x /= factor;
                    power++;
                }
                powers.add(power);
            }

            factor = this.getNextPrimeFactor();
        }

        int[][] result = new int[factors.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = factors.get(i);
            result[i][1] = powers.get(i);
        }

        return result;
    }
}
