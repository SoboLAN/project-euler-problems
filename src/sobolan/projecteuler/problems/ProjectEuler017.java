package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters
 * and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 */
public class ProjectEuler017 extends AbstractExecutableProblem
{
    private final int WORD_AND = 3;        //and
    private final int WORD_HUNDRED = 7;    //hundred
    private final int WORD_THOUSAND = 8;    //thousand

    private final int[] DIGITS = {
        0,    //zero (won't be used, so won't have any effect)
        3,    //one
        3,    //two
        5,    //three
        4,    //four
        4,    //five
        3,    //six
        5,    //seven
        5,    //eight
        4    //nine
    };

    private final int[] TENS = {
        0,    //zero (won't be used, so won't have any effect)
        3,    //ten
        6,    //twenty
        6,    //thirty
        5,    //forty
        5,    //fifty
        5,    //sixty
        7,    //seventy
        6,    //eighty
        6    //ninety
    };

    private final int[] SPECIALS = {
        0,    //zero (won't be used, so won't have any effect)
        6,    //eleven
        6,    //twelve
        8,    //thirteen
        8,    //fourteen
        7,    //fifteen
        7,    //sixteen
        9,    //seventeen
        8,    //eighteen
        8    //nineteen
    };

    @Override
    public String getResult()
    {
        //start at zero
        int result = 0;
        
        result += this.getCountFromOneToNineteen();

        //count from 20 to 1000
        for (int i = 20; i <= 1000; i++) {
            //numbers made up of 2 digits
            if (i <= 99) {
                result += this.getCountForTwoDigitNumbers(i);

            //numbers made up of 3 digits
            } else if (i >= 100 && i <= 999) {
                result += this.getCountForThreeDigitNumbers(i);

            //add the one thousand...
            } else if (i == 1000) {
                result += (this.DIGITS[1] + this.WORD_THOUSAND);
            }
        }

        return Integer.toString(result);
    }
    
    private int getCountFromOneToNineteen()
    {
        int result = 0;
        
        //count from 1 to 9
        for (int i = 1; i <= 9; i++) {
            result += this.DIGITS[i];
        }

        //count 10
        result += this.TENS[1];

        //count from 11 to 19
        for (int i = 1; i < 10; i++) {
            result += this.SPECIALS[i];
        }
        
        return result;
    }
    
    private int getCountForTwoDigitNumbers(int number)
    {
        int tens = number / 10;
        int digit = number % 10;

        //count the tens part and the digits part
        return this.TENS[tens] + this.DIGITS[digit];
    }
    
    private int getCountForThreeDigitNumbers(int number)
    {
        int result = 0;
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int digit = number % 10;

        //add the hundreds part ("five hundred")
        result += this.DIGITS[hundreds];
        result += this.WORD_HUNDRED;

        //if it's not 200 or 300 or 400, then the word "and" must be added
        if (tens != 0 || digit != 0) {
            result += this.WORD_AND;
        }

        switch (tens) {
            //if we're in the ten/eleven/twelve/etc. zone, then it's
            //a little more special
            case 1:
                result += (digit == 0) ? this.TENS[1] : this.SPECIALS[digit];
                break;

            //if the number is of the form 304, 506 etc.,
            //only the digit counts
            case 0:
                result += this.DIGITS[digit];
                break;

            //if it's a "normal" number (342 :D ), then count
            //the tens and the digit
            default:
                result += (this.TENS[tens] + this.DIGITS[digit]);
        }
        
        return result;
    }
}
