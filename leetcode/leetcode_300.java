class Solution {
    public int lengthOfLIS(int[] nums) {
        
        // dp[ i ] 表示以下标i为结尾的最长递增子序列

        // 0<= j < i num[j] < nums[i] dp[ i ] = max( dp[j] + 1 , dp[i])

        // 初始化 dp[ i ]  = 1

        int[] dp = new int[ nums.length ];
        Arrays.fill( dp , 1);

        int max = 1;

        for(int i = 1; i < nums.length; i++ )  
        {
            for(int j = 0; j < i; j++){
                if( nums[j] < nums[i] ){
                    dp[ i ] = Math.max( dp[i] , dp[j] + 1 );
                }
            }
            max = Math.max( dp[i] , max);
        }

        return max;
    }
}