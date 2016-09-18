package sobolan.projecteuler.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
 * is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * What is the total of all the name scores in the file?
 */
public class ProjectEuler22 extends AbstractExecutableProblem
{
    private final String FILE_PATH = "src/sobolan/projecteuler/problems/22.txt";
    @Override
    public String getResult()
    {
        String[] names = this.getListOfNamesFromFile();

        this.sortNames(names);

        int totalValue = 0;

        for (int i = 0; i < names.length; i++) {
            int sum = 0;
            for (int j = 0; j < names[i].length(); j++) {
                //given all the letters are uppercase ASCII letters,
                //we can safely subtract 64 to obtain their position in the alphabet
                sum += (names[i].charAt(j) - 64);
            }

            totalValue += (sum * (i + 1));
        }

        return Integer.toString(totalValue);
    }

    private String[] getListOfNamesFromFile()
    {
        ArrayList<String> namesList = new ArrayList<>();

        try (BufferedReader buff = new BufferedReader(new FileReader(this.FILE_PATH))) {
            String line;

            while ((line = buff.readLine()) != null) {
                namesList.add(line);
            }
        } catch (Exception ex) {
            System.err.println("There was an error while reading and parsing the file");
            System.exit(-10);
        }

        String[] names = namesList.toArray(new String[namesList.size()]);

        return names;
    }

    private void sortNames(String[] names)
    {
        for (int i = 0; i < names.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < names.length; j++) {
                if (names[minIndex].compareTo(names[j]) > 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                String ax = names[i];
                names[i] = names[minIndex];
                names[minIndex] = ax;
            }
        }
    }
}
