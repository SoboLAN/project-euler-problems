package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 * What is the largest n-digit pandigital prime that exists?
 */
public class ProjectEuler041 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        /**
         * A 9-digit pandigital number has the sum of digits 1+2+3+4+5+6+7+8+9 = 45, which means it's divisible by 3,
         * which means it's not a prime.
         * This also applies to 8-digit pandigital numbers because 1+2+3+4+5+6+7+8 = 36, which is also divisible by 3.
         * This only leaves 7-digit pandigital numbers, which is the reason we start our count from 7654321.
         */
        for (int i = 7654321; i >= 1234567; i--) {
            if (this.is7DigitPandigital(i)) {
                if (this.isPrime(i)) {
                    return Integer.toString(i);
                }
            }
        }

        return Integer.toString(0);
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

    private boolean is7DigitPandigital(int number)
    {
        String numberAsString = Integer.toString(number);

        return numberAsString.indexOf('1') != -1 &&
            numberAsString.indexOf('2') != -1 &&
            numberAsString.indexOf('3') != -1 &&
            numberAsString.indexOf('4') != -1 &&
            numberAsString.indexOf('5') != -1 &&
            numberAsString.indexOf('6') != -1 &&
            numberAsString.indexOf('7') != -1;
    }
}
