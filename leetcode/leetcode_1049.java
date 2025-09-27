class Solution {
    public int lastStoneWeightII(int[] stones) {
        

        //把问题 划分成0 / 1背包问题
        //把石头当成物品  物品重量等于物品价值 把石头 sum/2 当初背包容量

        int sum = Arrays.stream( stones ).sum();

        int[][] dp = new int[ stones.length ][ sum/2 + 1];

        // 注意 sum/2 向下取整 所以s
        for(int j = stones[0] ; j <= sum/2 ; j++){
            dp[0][j] = stones[0]; 
        }

        for(int i = 1; i < stones.length ; i++){
            for(int j = 0 ; j <= sum/2 ; j++){
                if( j < stones[i] ){
                    dp[i][j] = dp[i-1][j];
                }else
                {
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i-1][j - stones[i]] + stones[i] );
                }
            }
        }

        return sum - dp[stones.length - 1][sum / 2]  - dp[stones.length - 1][sum / 2] ;
    }
}