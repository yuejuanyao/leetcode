package DynamicProgramming;

public class Edit_distance_72 {

    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;
        if (word1.length()==0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int length = dp.length;
        int length2 = dp[0].length;
        for (int i =0; i<length; i++){
            dp[i][0] = i;
        }
        for (int i =0; i<length2; i++){
            dp[0][i] = i;
        }

        for (int i =1; i<length; i++){
            for (int j = 1; j<length2; j++){
                int row = dp[i-1][j];
                int col = dp[i][j-1];
                int before = dp[i-1][j-1];
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(row,Math.min(col,before-1))+1;
                }else {
                    dp[i][j] = Math.min(row,Math.min(col,before))+1;
                }
            }
        }
        return dp[length-1][length2-1];
    }
}
