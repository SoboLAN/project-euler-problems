package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * Euler discovered the remarkable quadratic formula: n^2+n+41
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0<=n<=39.
 * However, when n=40,40^2+40+41=40(40+1)+41 is divisible by 41,
 * and certainly when n=41,41^2+41+41 is clearly divisible by 41.
 * The incredible formula n^2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0<=n<=79.
 * The product of the coefficients, −79 and 1601, is −126479.
 * Considering quadratics of the form: n^2+an+b, where |a|<1000 and |b|<=1000
 * where |n| is the modulus/absolute value of n e.g. |11|=11 and |−4|=4
 * Find the product of the coefficients, a and b, for the quadratic expression that produces
 * the maximum number of primes for consecutive values of n, starting with n=0.
 */
public class ProjectEuler27 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        int maxprimelength = 0;
        int maxa = 0;
        int maxb = 0;

        for (int a = -999; a <= 999; a++) {
            for (int b = -999; b <= 999; b++) {
                int n;
                for (n = 0; n < Integer.MAX_VALUE; n++) {
                    if (! this.isPrime(n * n + a * n + b)) {
                        break;
                    }
                }

                if (n > maxprimelength) {
                    maxprimelength = n;
                    maxa = a;
                    maxb = b;
                }
            }
        }

        return String.format("%d x %d = %d (%d consecutive primes)", maxa, maxb, maxa * maxb, maxprimelength);
    }

    private boolean isPrime(int number)
    {
        if (number < 2) {
            return false;
        }

        long squareRoot = Math.round(Math.sqrt(number));

        for (long i = 2; i <= squareRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
