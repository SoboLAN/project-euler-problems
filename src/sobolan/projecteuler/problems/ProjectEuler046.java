package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * It was proposed by Christian Goldbach that every odd composite number can be written as
 * the sum of a prime and twice a square.
 * 9 = 7 + 2x1^2
 * 15 = 7 + 2x2^2
 * 21 = 3 + 2x3^2
 * 25 = 7 + 2x3^2
 * 27 = 19 + 2x2^2
 * 33 = 31 + 2x1^2
 * It turns out that the conjecture was false.
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
public class ProjectEuler046 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        for (int i = 33; true; i += 2) {
            if (this.isPrime(i)) {
                continue;
            }

            /**
             * first prime
             */
            int prime = 2;

            boolean valid = false;

            /**
             * Our prime + 2 * 1^2 should not overshoot i
             */
            while (prime + 2 <= i) {
                /**
                 * We're checking to see if there exists natural number j such that prime + 2 * j^2 = i.
                 * This means j = sqrt((i - prime) / 2), which means j^2 must be a perfect square
                 */
                int formulaValue = i - prime;
                if (formulaValue % 2 == 0) {
                    int sqrt = (int) Math.sqrt(formulaValue / 2);
                    if (sqrt * sqrt == formulaValue / 2) {
                        valid = true;
                        break;
                    }
                }

                /**
                 * We go to the next prime if the current one did not satisfy our conditions
                 */
                prime = this.getNextPrime(prime);
            }

            if (! valid) {
                return Integer.toString(i);
            }
        }
    }

    private boolean isPrime(int number)
    {
        if (number % 2 == 0) {
            return false;
        }

        int squareRoot = (int) Math.sqrt(number);

        for (int i = 3; i <= squareRoot; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int getNextPrime(int currentPrime)
    {
        if (currentPrime == 2) {
            return 3;
        }

        int p = currentPrime + 2;
        while (true) {
            if (this.isPrime(p)) {
                return p;
            }

            p += 2;
        }
    }
}
