package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Super_egg_drop_887 {
    Map<Integer, Integer> depth = new HashMap<>();

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

//    private int dp(int k, int n) {
//        Integer key = n*100 +k;
//        if (depth.containsKey(key)) {
//            return depth.get(key);
//        }
//        if (n == 0) {
//            return 0;
//        }
//        if (k == 1) {
//            return n;
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i <= n; i++) {
//            res = Math.min(res, Math.max(dp(k, n - i), dp(k - 1, i - 1)) + 1);
//        }
//        depth.put(key, res);
//        return res;
//    }

    Map<Integer, Integer> memo = new HashMap();
    public int dp(int K, int N) {
        Integer key = N * 100 + K;
        if (!memo.containsKey(key)) {
            int ans;
            if (N == 0)
                ans = 0;
            else if (K == 1)
                ans = N;
            else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(K-1, x-1);
                    int t2 = dp(K, N-x);

                    if (t1 < t2)
                        lo = x;
                    else if (t1 > t2)
                        hi = x;
                    else
                        lo = hi = x;
                }

                ans = 1 + Math.min(Math.max(dp(K-1, lo-1), dp(K, N-lo)),
                        Math.max(dp(K-1, hi-1), dp(K, N-hi)));
            }
            memo.put(key, ans);
        }

        return memo.get(key);
    }
}
