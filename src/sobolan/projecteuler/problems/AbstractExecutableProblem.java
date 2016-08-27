package sobolan.projecteuler.problems;

import sobolan.projecteuler.main.ProblemResult;

/**
 * @author Radu Murzea
 */
public abstract class AbstractExecutableProblem
{
    public ProblemResult execute()
    {
        long start = System.currentTimeMillis();

        String result = this.getResult();

        long end = System.currentTimeMillis();

        ProblemResult problemResult = new ProblemResult(result, (end - start));

        return problemResult;
    }

    abstract String getResult();
}
