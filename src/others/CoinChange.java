package others;

//incorrect
//http://www.techiedelight.com/coin-change-making-problem-unlimited-supply-coins/
public class CoinChange {
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[]{1,3,5,7}, 16, 4));
        System.out.println(cc.coinChange(new int[]{1,3,5,7}, 18, 4));
        System.out.println(cc.coinChange(new int[]{1,3,5,7}, 10, 4));
    }

    private int coinChange(int denominations[], int changeRequired, int totalCoins) {
        if(changeRequired < 0 || totalCoins < 1)
            return 0;
        int include = 1 + coinChange(denominations, changeRequired - denominations[totalCoins-1], totalCoins);
        int exclude = include + coinChange(denominations, changeRequired, totalCoins-1);
        return Math.min(include, exclude);
    }
}
