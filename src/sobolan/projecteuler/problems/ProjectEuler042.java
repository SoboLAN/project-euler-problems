package sobolan.projecteuler.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The nth term of the sequence of triangle numbers is given by, t(n) = 1/2 * n(n+1);
 * so the first ten triangle numbers are:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * By converting each letter in a word to a number corresponding to its alphabetical position
 * and adding these values we form a word value.
 * For example, the word value for SKY is 19 + 11 + 25 = 55 = t(10).
 * If the word value is a triangle number then we shall call the word a triangle word.
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly
 * two-thousand common English words, how many are triangle words?
 */
public class ProjectEuler042 extends AbstractExecutableProblem
{
    private final String FILE_PATH = "src/sobolan/projecteuler/problems/42.txt";
    private int[] triangles;

    @Override
    public String getResult()
    {
        String[] words = this.readWordsFromFile();
        this.generateTriangleNumbers();

        int triangleWords = 0;
        for (String word : words) {

            int sumOfLetters = 0;
            for (int i = 0; i < word.length(); i++) {
                sumOfLetters += this.getLetterValue(word.charAt(i));
            }

            if (this.isTriangleNumber(sumOfLetters)) {
                triangleWords++;
            }
        }

        return Integer.toString(triangleWords);
    }

    private String[] readWordsFromFile()
    {
        String[] words = new String[0];

        try (BufferedReader buff = new BufferedReader(new FileReader(this.FILE_PATH))) {
            String line = buff.readLine();
            words = line.split(",");
        } catch (Exception e) {
            System.err.println("There was an error while reading and parsing the file");
            System.exit(-10);
        }

        return words;
    }

    private void generateTriangleNumbers()
    {
        //26 because there are 26 uppercase ASCII letters
        //extra slot for triangles[0]
        this.triangles = new int[27];

        for (int i = 0; i < 27; i++) {
            this.triangles[i] = (i * i + i) / 2;
        }
    }

    private int getLetterValue(char letter)
    {
        switch(letter) {
            case 'A': return 1;
            case 'B': return 2;
            case 'C': return 3;
            case 'D': return 4;
            case 'E': return 5;
            case 'F': return 6;
            case 'G': return 7;
            case 'H': return 8;
            case 'I': return 9;
            case 'J': return 10;
            case 'K': return 11;
            case 'L': return 12;
            case 'M': return 13;
            case 'N': return 14;
            case 'O': return 15;
            case 'P': return 16;
            case 'Q': return 17;
            case 'R': return 18;
            case 'S': return 19;
            case 'T': return 20;
            case 'U': return 21;
            case 'V': return 22;
            case 'W': return 23;
            case 'X': return 24;
            case 'Y': return 25;
            case 'Z': return 26;
            default: return 0;
        }
    }

    private boolean isTriangleNumber(int number)
    {
        int searchResult = Arrays.binarySearch(this.triangles, number);

        return (searchResult >= 0);
    }
}
