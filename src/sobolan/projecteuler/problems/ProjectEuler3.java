package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
public class ProjectEuler3 extends AbstractExecutableProblem
{
    private final long NUMBER = 600851475143L;

    @Override
    public String getResult()
    {
        long number = NUMBER;

        //we start with a really small result, one that is surely NOT the correct answer
        Integer maxfactor = -1;

        //the smallest possible prime factor is 2
        int factor = 2;

        while (number != 1) {
            if (number % factor == 0) {
                while (number % factor == 0) {
                    number /= factor;
                }

                maxfactor = factor;
            }

            factor++;
        }

        return maxfactor.toString();
    }
}
