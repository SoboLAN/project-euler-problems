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
            System.err.println("Invalid number of arguments");
            System.exit(-1);
        }

        ProjectEuler.fillProblemMap();

        Class problemClass = ProjectEuler.problemMap.get(args[0]);
        if (problemClass == null) {
            System.err.println("Invalid or not found problem ID");
            System.exit(-2);
        }

        AbstractExecutableProblem executable;
        ProblemResult result = null;
        try {
            executable = (AbstractExecutableProblem) problemClass.newInstance();
            result = executable.execute();
        } catch (Exception ex) {
            System.err.println("There was an error while executing. Please try again");
            System.exit(-3);
        }

        System.out.println(String.format("Result: %s", result.getResult()));
        System.out.println(String.format("Duration: %d ms", result.getDuration()));
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
        problemMap.put("18", ProjectEuler18.class);
        problemMap.put("19", ProjectEuler19.class);
        problemMap.put("20", ProjectEuler20.class);
        problemMap.put("22", ProjectEuler22.class);
        problemMap.put("24", ProjectEuler24.class);
        problemMap.put("25", ProjectEuler25.class);
        problemMap.put("27", ProjectEuler27.class);
        problemMap.put("206", ProjectEuler206.class);
    }
}
