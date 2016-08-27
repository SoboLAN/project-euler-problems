package sobolan.projecteuler.main;

import java.util.HashMap;
import sobolan.projecteuler.problems.*;

/**
 * @author Radu Murzea
 */
public class ProjectEuler
{
    private static HashMap<String, Class> problemMap;

    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments");
            System.exit(-1);
        }

        ProjectEuler.fillProblemMap();

        String problemId = args[0];

        Class problemClass = ProjectEuler.problemMap.get(problemId);
        if (problemClass == null) {
            System.out.println("Invalid or not found problem ID");
            System.exit(-2);
        }

        AbstractExecutableProblem executable = null;
        try {
            executable = (AbstractExecutableProblem) problemClass.newInstance();
        } catch (Exception ex) {
            System.out.println("There was an error while executing. Please try again");
            System.exit(-3);
        }

        ProblemResult result = executable.execute();

        System.out.println("Result: " + result.getResult());
        System.out.println("Duration: " + result.getDuration() + " ms");
    }

    private static void fillProblemMap()
    {
        ProjectEuler.problemMap = new HashMap<>();

        problemMap.put("1", ProjectEuler1.class);
        problemMap.put("2", ProjectEuler2.class);
        problemMap.put("3", ProjectEuler3.class);
    }
}
