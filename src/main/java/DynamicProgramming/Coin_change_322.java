package DynamicProgramming;

import org.junit.Test;

import java.util.Map;

public class Coin_change_322 {
    public int coinChange(int[] coins, int amount) {
        return subCoin(coins,amount, new int[amount]);
    }
    /*
    想好结束条件：1.当钱为0那么就返回0个；2.如果前述是小于0的那说明这条路行不通，返回-1；
    如果这个钱的已经算过了，返回这个的数量；
     */
    public int subCoin(int[] coins, int amount, int[] counts) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (counts[amount-1] != 0)
            return counts[amount-1];
        int coinNum = Integer.MAX_VALUE;
        //这个是在amount钱数下的说有子问题
        for (int coin : coins) {
//            if ((amount - coin) <0) //这个不能写在这，如果有一个行不通，最后一层会直接返回结束，
//                return -1;
            int subProblem = subCoin(coins, amount-coin, counts);
            if (subProblem != -1){
                coinNum = Math.min(coinNum,subProblem+1);
            }
        }
        counts[amount-1] = coinNum<Integer.MAX_VALUE ? coinNum : -1;
        return counts[amount-1];
    }

    @Test
    public void test(){
        int[] coin = {1,2147483647};
        System.out.println(coinChange(coin,2));
        System.out.println(Integer.MAX_VALUE);
    }
}
