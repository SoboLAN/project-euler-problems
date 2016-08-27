package sobolan.projecteuler.problems;

import sobolan.projecteuler.main.ProblemResult;

/**
 * @author SoboLAN
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
