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

        problemMap.put("1", ProjectEuler001.class);
        problemMap.put("2", ProjectEuler002.class);
        problemMap.put("3", ProjectEuler003.class);
        problemMap.put("4", ProjectEuler004.class);
        problemMap.put("5", ProjectEuler005.class);
        problemMap.put("6", ProjectEuler006.class);
        problemMap.put("7", ProjectEuler007.class);
        problemMap.put("8", ProjectEuler008.class);
        problemMap.put("9", ProjectEuler009.class);
        problemMap.put("10", ProjectEuler010.class);
        problemMap.put("11", ProjectEuler011.class);
        problemMap.put("12", ProjectEuler012.class);
        problemMap.put("13", ProjectEuler013.class);
        problemMap.put("14", ProjectEuler014.class);
        problemMap.put("15", ProjectEuler015.class);
        problemMap.put("16", ProjectEuler016.class);
        problemMap.put("17", ProjectEuler017.class);
        problemMap.put("18", ProjectEuler018.class);
        problemMap.put("19", ProjectEuler019.class);
        problemMap.put("20", ProjectEuler020.class);
        problemMap.put("21", ProjectEuler021.class);
        problemMap.put("22", ProjectEuler022.class);
        problemMap.put("23", ProjectEuler023.class);
        problemMap.put("24", ProjectEuler024.class);
        problemMap.put("25", ProjectEuler025.class);
        problemMap.put("27", ProjectEuler027.class);
        problemMap.put("28", ProjectEuler028.class);
        problemMap.put("29", ProjectEuler029.class);
        problemMap.put("30", ProjectEuler030.class);
        problemMap.put("32", ProjectEuler032.class);
        problemMap.put("34", ProjectEuler034.class);
        problemMap.put("35", ProjectEuler035.class);
        problemMap.put("36", ProjectEuler036.class);
        problemMap.put("37", ProjectEuler037.class);
        problemMap.put("39", ProjectEuler039.class);
        problemMap.put("40", ProjectEuler040.class);
        problemMap.put("41", ProjectEuler041.class);
        problemMap.put("59", ProjectEuler059.class);
        problemMap.put("206", ProjectEuler206.class);
    }
}
