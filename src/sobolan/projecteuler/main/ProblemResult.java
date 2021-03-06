package sobolan.projecteuler.main;

/**
 * @author Radu Murzea
 */
public class ProblemResult
{
    private final String result;
    private final long duration;

    public ProblemResult(String result, long duration)
    {
        this.result = result;
        this.duration = duration;
    }

    public String getResult()
    {
        return this.result;
    }

    public long getDuration()
    {
        return this.duration;
    }
}
