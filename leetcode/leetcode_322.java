class Solution {
    public int coinChange(int[] coins, int amount) {
        

        // dp[j]：凑足总额为j所需钱币的最少个数为dp[j]

        int[] dp = new int[ amount + 1];

          for (int j = 0; j < dp.length; j++) {
            dp[j] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        // dp[ j ] = dp[j] = min(dp[j - coins[i]] + 1, dp[j])

        for(int i = 0; i < coins.length ; i++){
            for(int j = coins[i] ; j <= amount; j++){
                if( dp[ j - coins[i] ] != Integer.MAX_VALUE){
                    dp[j] = Math.min( dp[ j - coins[i] ] + 1, dp[j]);
                }
                
                
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;

        return dp[amount];

    }
}