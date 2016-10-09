package sobolan.projecteuler.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * Each character on a computer is assigned a unique code and the preferred standard is
 * ASCII (American Standard Code for Information Interchange). For example, uppercase A = 65, asterisk (*) = 42,
 * and lowercase k = 107.
 * A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value,
 * taken from a secret key. The advantage with the XOR function is that using the same encryption key on the cipher text,
 * restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
 * For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of
 * random bytes. The user would keep the encrypted message and the encryption key in different locations,
 * and without both "halves", it is impossible to decrypt the message.
 * Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key.
 * If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message.
 * The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.
 * Your task has been made easy, as the encryption key consists of three lower case characters.
 * Using cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes,
 * and the knowledge that the plain text must contain common English words, decrypt the message
 * and find the sum of the ASCII values in the original text.
 */
public class ProjectEuler059 extends AbstractExecutableProblem
{
    //file where the encrypted message is found
    private final String FILE_PATH = "src/sobolan/projecteuler/problems/59.txt";

    //minimum nr. of common words in decrypted message so that we consider it valid
    private final int WORD_REQUIREMENT = 4;

    @Override
    public String getResult()
    {
        int[] smallLettersAscii = this.getSmallLettersAscii();
        Integer[] encryptedMessage = this.getEncryptedMessageFromFile();
        String[] commonEnglishWords = this.getCommonEnglishWords();

        int[] key = new int[3];
        for (int i = 0; i < smallLettersAscii.length; i++) {
            key[0] = smallLettersAscii[i];
            for (int j = 0; j < smallLettersAscii.length; j++) {
                key[1] = smallLettersAscii[j];
                for (int k = 0; k < smallLettersAscii.length; k++) {
                    key[2] = smallLettersAscii[k];

                    int[] decryptedMessage = this.getDecryptedMessage(encryptedMessage, key);

                    if (this.messageHasCommonEnglishWords(commonEnglishWords, decryptedMessage)) {
                        int result = this.getAsciiSum(decryptedMessage);
                        String keyAsWord = this.getPrettyPrintedKey(key);

                        return String.format("%d (key: %s)", result, keyAsWord);
                    }
                }
            }
        }

        return "NO RESULT FOUND";
    }

    private int[] getSmallLettersAscii()
    {
        int[] smallLettersAscii = new int[26];
        for (int i = 0; i < 26; i++) {
            //small letters start with ASCII code 97
            smallLettersAscii[i] = i + 97;
        }

        return smallLettersAscii;
    }

    private int[] getDecryptedMessage(Integer[] encryptedMessage, int[] key)
    {
        int[] result = new int[encryptedMessage.length];

        for (int i = 0; i < encryptedMessage.length; i += key.length) {
            for (int j = 0; j < key.length && i + j < encryptedMessage.length; j++) {
                result[i + j] = encryptedMessage[i + j] ^ key[j];
            }
        }

        return result;
    }

    private boolean messageHasCommonEnglishWords(String[] englishWords, int[] message)
    {
        char[] messageChars = new char[message.length];
        for (int i = 0; i < message.length; i++) {
            messageChars[i] = (char) message[i];
        }

        String messageAsString = new String(messageChars);

        int foundWords = 0;
        for (String englishWord : englishWords) {
            if (messageAsString.contains(englishWord)) {
                foundWords++;
            }

            if (foundWords >= this.WORD_REQUIREMENT) {
                return true;
            }
        }

        return false;
    }

    private Integer[] getEncryptedMessageFromFile()
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new FileReader(this.FILE_PATH))) {
            String line;
            while ((line = buff.readLine()) != null) {
                String[] elements = line.split(",");
                for (String element : elements) {
                    Integer x = Integer.parseInt(element);
                    numbers.add(x);
                }
            }
        } catch (IOException|NumberFormatException ex) {
            System.err.println("There was a problem while reading and parsing the file");
            System.exit(-10);
        }

        Integer[] result = new Integer[numbers.size()];
        numbers.toArray(result);

        return result;
    }

    private int getAsciiSum(int[] sequence)
    {
        int result = 0;
        for (int element : sequence) {
            result += element;
        }

        return result;
    }

    private String getPrettyPrintedKey(int[] key)
    {
        char[] keyChars = new char[key.length];
        for (int i = 0; i < key.length; i++) {
            keyChars[i] = (char) key[i];
        }

        return new String(keyChars);
    }

    /**
     * Returns a few of the most used words in English.
     * With very few exceptions, words returned are at least 4 letters long, to reduce chance of false positives.
     * @see https://en.wikipedia.org/wiki/Most_common_words_in_English
     */
    private String[] getCommonEnglishWords()
    {
        return new String[]{
            "the",
            "and",
            "that",
            "have",
            "with",
            "you",
            "this",
            "from",
            "they",
            "will",
            "would",
            "there",
            "their",
            "what",
            "about",
            "which",
            "when",
            "make",
            "time",
            "know",
            "take",
        };
    }
}
