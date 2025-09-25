class Solution {
    public int minCostClimbingStairs(int[] cost) {


        // dp[i] 表示爬到第i个台阶的最小花费

        // dp[i] = min( dp[i-1]+ cost[i-1] , dp[i-2]+ cost[i-2]);
        int dp[] = new int[ cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= cost.length ; i++){
            dp[i] = Math.min(dp[i-1]+ cost[i-1] , dp[i-2]+ cost[i-2] );
        }

        return dp[cost.length ];
    }
}