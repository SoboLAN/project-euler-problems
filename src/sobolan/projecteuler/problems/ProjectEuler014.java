package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even)
 * n -> 3*n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class ProjectEuler014 extends AbstractExecutableProblem
{
    private final int START_TERM_LIMIT = 1 * 1000 * 1000;

    @Override
    public String getResult()
    {
        int longestChainLength = 0;
        long longestChainStartTerm = 0;

        for (int startTerm = 2; startTerm < this.START_TERM_LIMIT; startTerm++) {
            long term = startTerm;
            int currentChainLength = 0;

            while (term != 1) {
                term = term % 2 == 0 ? term / 2 : 3 * term + 1;
                currentChainLength++;
            }

            if (currentChainLength > longestChainLength) {
                longestChainLength = currentChainLength;
                longestChainStartTerm = startTerm;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(Long.toString(longestChainStartTerm));
        result.append(" (");
        result.append(Integer.toString(longestChainLength));
        result.append(" terms)");

        return result.toString();
    }
}
