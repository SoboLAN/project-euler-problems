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
        problemMap.put("4", ProjectEuler4.class);
        problemMap.put("5", ProjectEuler5.class);
        problemMap.put("6", ProjectEuler6.class);
        problemMap.put("7", ProjectEuler7.class);
        problemMap.put("8", ProjectEuler8.class);
        problemMap.put("9", ProjectEuler9.class);
        problemMap.put("10", ProjectEuler10.class);
        problemMap.put("11", ProjectEuler11.class);
        problemMap.put("12", ProjectEuler12.class);
        problemMap.put("13", ProjectEuler13.class);
        problemMap.put("14", ProjectEuler14.class);
        problemMap.put("15", ProjectEuler15.class);
        problemMap.put("16", ProjectEuler16.class);
        problemMap.put("17", ProjectEuler17.class);
        problemMap.put("19", ProjectEuler19.class);
        problemMap.put("20", ProjectEuler20.class);
    }
}
