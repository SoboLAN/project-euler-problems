package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * 1x£1 + 1x50p + 2x20p + 1x5p + 1x2p + 3x1p
 * How many different ways can £2 be made using any number of coins?
 */
public class ProjectEuler31 extends AbstractExecutableProblem
{
    private int[] coins;

    @Override
    public String getResult()
    {
        this.coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};

        int result = this.count(200, this.coins.length);

        return Integer.toString(result);
    }

    private int count(int sum, int nrCoins)
    {
        if (sum == 0) {
            return 1;
        } else if (sum < 0) {
            return 0;
        } else if (nrCoins <= 0 && sum >= 1) {
            return 0;
        }

        return this.count(sum, nrCoins - 1)
            + this.count(sum - this.coins[nrCoins - 1], nrCoins);
    }
}
