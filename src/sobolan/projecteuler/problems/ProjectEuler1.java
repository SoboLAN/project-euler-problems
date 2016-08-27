package sobolan.projecteuler.problems;

import sobolan.projecteuler.main.ProblemResult;

/**
 * @author SoboLAN
 *
 * @problemstatement
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class ProjectEuler1 implements ProjectEulerExecutable
{
    @Override
    public ProblemResult execute()
    {
        long start = System.currentTimeMillis();

        Integer result = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                result += i;
            }
        }

        long end = System.currentTimeMillis();

        ProblemResult problemResult = new ProblemResult(result.toString(), (end - start));

        return problemResult;
    }
}
