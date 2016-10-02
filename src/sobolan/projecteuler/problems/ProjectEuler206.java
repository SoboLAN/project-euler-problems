package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
 * where each "_" is a single digit.
 */
public class ProjectEuler206 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        /**
         * We notice that the pattern ends in *9_0.
         * The only way a square ends in zero is if its root also ends in zero, which means the square actually ends in 00.
         * This is great: we can remove those last 2 zeros and search only in the smaller number, then multiply by 10.
         * We start the search from the square root of the maximum number (which is the pattern filled only with nines)
         * and we go down checking only odd numbers (because our square ends in "9").
         */
        long startNumber = 138902663L; //sqrt(19293949596979899)
        long square = startNumber * startNumber;
        while (! this.matchesPattern(square)) {
            startNumber -= 2;
            square = startNumber * startNumber;
        }

        startNumber *= 10;

        return Long.toString(startNumber);
    }

    //Returns true if x looks like 1_2_3_4_5_6_7_8_9
    private boolean matchesPattern(long x)
    {
        String numberAsString = Long.toString(x);

        if (numberAsString.length() != 17) {
            return false;
        }

        for (int i = 9; i >= 1; i--) {
            int position = 2 * i - 2;   //16 - 2 * (9 - i)
            int digit = ((int) numberAsString.charAt(position)) - 48;
            if (digit != i) {
                return false;
            }
        }

        return true;
    }
}
