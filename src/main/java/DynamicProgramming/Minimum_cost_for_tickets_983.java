package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class Minimum_cost_for_tickets_983 {
    int lastDay;
    int[] costs;
    Integer[] dp;
    Set<Integer> daySet = new HashSet<>();

    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length <= 0)
            return 0;
        this.costs = costs;
        lastDay = days[days.length - 1];
        dp = new Integer[lastDay + 1];
        for (int day : days) {
            daySet.add(day);
        }
        return dp(1);
    }

    private int dp(int i) {
        if (i > lastDay)
            return 0;
        if (dp[i] != null)
            return dp[i];
        if (daySet.contains(i)) {
            dp[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
            return dp[i];
        } else {
            return dp(i + 1);
        }
    }
    int[] durations = new int[]{1, 7, 30};
    int[] days;
    public int mincostTickets_1(int[] days, int[] costs) {
        if (days == null || days.length <= 0)
            return 0;
        this.days = days;
        this.costs = costs;
        dp = new Integer[days.length];
        return dp_1(0);
    }
    private int dp_1(int curIndex) {
        if (curIndex >= dp.length)
            return 0;
        if (dp[curIndex] != null)
            return dp[curIndex];
        dp[curIndex] = Integer.MAX_VALUE;
        for (int i = 0; i< 3; i++){
            int deadline = days[curIndex] + durations[i];
            int buyNewIndex = curIndex;
            while (buyNewIndex < days.length && days[buyNewIndex] < deadline){
                buyNewIndex ++;
            }
            dp[curIndex] = Math.min(dp[curIndex], dp_1(buyNewIndex) + costs[i]);
        }
        return dp[curIndex];
    }
}
