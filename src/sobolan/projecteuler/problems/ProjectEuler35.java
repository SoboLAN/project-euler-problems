package sobolan.projecteuler.problems;

import java.util.Arrays;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The number, 197, is called a circular prime because all rotations of the digits:
 * 197, 971, and 719, are themselves prime.
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * How many circular primes are there below one million?
 */
public class ProjectEuler35 extends AbstractExecutableProblem
{
    private int[] primes;
    private final int PRIMES_LIMIT = 1000 * 1000;

    @Override
    public String getResult()
    {
        this.generatePrimes();

        //We already know from the statement that the first 7 prime numbers (2,3,5,7,11,13,17) respect the condition
        //Therefore that's where we start our search.
        int count = 7;
        for (int i = 7; i < this.primes.length; i++) {
            int nrDigits = this.getNrOfDigits(this.primes[i]);

            //We start with the prime number and we will keep rotating it
            //The number of rotations is equal to the number of digits of the number - 1
            int rotated = this.primes[i];
            boolean circularPrime = true;
            for (int j = 1; j < nrDigits; j++) {
                rotated = this.rotateNumber(rotated, nrDigits);

                //We're lucky that "primes" contains the prime numbers in sorted order
                //Means we can very very fast find if rotated form of the number is prime
                //by looking for it in "primes" using binary-search (maximum of log2(primes.length) = ~17 steps)
                int binaryResult = Arrays.binarySearch(this.primes, rotated);
                if (binaryResult < 0) {
                    circularPrime = false;
                    break;
                }
            }

            if (circularPrime) {
                count++;
            }
        }

        return Integer.toString(count);
    }

    //fills the "primes" field with all prime numbers smaller than "PRIMES_LIMIT"
    private void generatePrimes()
    {
        //placeholder for every number up to PRIMES_LIMIT
        boolean[] allNumbers = new boolean[this.PRIMES_LIMIT];

        //allNumbers[i] is true if the number i is a prime
        //at first, let's assume every number is prime
        Arrays.fill(allNumbers, true);

        //since we'll start with 2, let's mark the first 2 manually,
        //so as not to disturb us in the loop :)
        allNumbers[0] = allNumbers[1] = false;

        //we start counting downwards.
        //the "- 2" is because the first 2 primes are manually marked above
        int primesSize = this.PRIMES_LIMIT - 2;

        //implementation of the Sieve of Eratosthenes
        for (int i = 2; i < (int) Math.sqrt (this.PRIMES_LIMIT) + 1; i++) {
            if (allNumbers[i]) {
                for (int j = i * i; j < this.PRIMES_LIMIT; j += i) {
                    if (allNumbers[j]) {
                        allNumbers[j] = false;
                        primesSize--;
                    }
                }
            }
        }

        //now we know how many primes there are up to PRIMES_LIMIT
        //so the "primes" array can be created.
        primes = new int[primesSize];

        //store all primes in the "primes" array
        for (int i = 0, currentIndex = 0; i < this.PRIMES_LIMIT; i++) {
            if (allNumbers[i]) {
                primes[currentIndex++] = i;
            }
        }
    }

    //rotates "number" by 1 digit (moves first digit to the end)
    private int rotateNumber(int number, int sizeOfNumber)
    {
        int divider = 1;
        for (int i = 1; i <= sizeOfNumber - 1; i++) {
            divider *= 10;
        }

        int firstDigit = number / divider;
        int restOfNumber = number % divider;

        return (restOfNumber * 10 + firstDigit);
    }

    //returns number of digits of "number"
    private int getNrOfDigits(int number)
    {
        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }

        return count;
    }
}
