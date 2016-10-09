package sobolan.projecteuler.problems;

import java.util.HashSet;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product
 * is 1 through 9 pandigital.
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class ProjectEuler032 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        HashSet<Integer> products = new HashSet<>();

        //The number 9,999 is chosen as limit because it can be the maximum value that respects the conditions
        //5-digit (or more) numbers would generate too big products for our problem statement.
        for (int i = 1; i <= 9999; i++) {
            for (int j = i + 1; j <= 9999; j++) {
                String bigN = Integer.toString(i) + Integer.toString(j) + Integer.toString(i * j);

                if (bigN.length() > 9) {
                    break;
                }

                if (bigN.length() < 9) {
                    continue;
                }

                if (this.isPandigital(bigN)) {
                    products.add(i * j);
                }
            }
        }

        int sum = 0;
        Integer[] productsArray = new Integer[products.size()];
        products.toArray(productsArray);
        for (int product : productsArray) {
            sum += product;
        }

        return Integer.toString(sum);
    }

    //checks if number is pandigital
    //assumes length to be 9
    private boolean isPandigital(String number)
    {
        return (number.indexOf('1') != -1 &&
            number.indexOf('2') != -1 &&
            number.indexOf('3') != -1 &&
            number.indexOf('4') != -1 &&
            number.indexOf('5') != -1 &&
            number.indexOf('6') != -1 &&
            number.indexOf('7') != -1 &&
            number.indexOf('8') != -1 &&
            number.indexOf('9') != -1);
    }
}
