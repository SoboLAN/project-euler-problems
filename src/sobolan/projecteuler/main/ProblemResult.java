package sobolan.projecteuler.main;

/**
 * @author SoboLAN
 */
public class ProblemResult
{
    private String result;
    private long duration;
    
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
