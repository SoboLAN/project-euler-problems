package sobolan.projecteuler.main;

import java.util.HashMap;
import sobolan.projecteuler.problems.*;

/**
 * @author SoboLAN
 */
public class ProjectEuler
{
    private static HashMap<String, Class> problemMap;

    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments");
        }

        ProjectEuler.fillProblemMap();

        String problemId = args[0];

        Class problemClass = ProjectEuler.problemMap.get(problemId);
        if (problemClass == null) {
            System.out.println("Invalid problem ID");
        }

        ProjectEulerExecutable executable = null;
        try {
            executable = (ProjectEulerExecutable) problemClass.newInstance();
        } catch (Exception ex) {
            System.out.println("Invalid problem ID");
            System.exit(-1);
        }

        ProblemResult result = executable.execute();

        System.out.println("Result: " + result.getResult());
        System.out.println("Duration: " + result.getDuration() + " ms");
    }

    private static void fillProblemMap()
    {
        ProjectEuler.problemMap = new HashMap<>();

        problemMap.put("1", ProjectEuler1.class);
    }
}
