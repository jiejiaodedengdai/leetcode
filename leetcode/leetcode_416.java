class Solution {
    public boolean canPartition(int[] nums) {
        

        //  分割成两个数组  数组元素和相等
        // 拆分成 sum/2 的0 1 背包问题
        // 能否采用数字 把 sum/2 装满  装满的最大价值是sum/2

        //i表示 数字（物品）  j表示背包承重
        //dp[i][j] 表示 前i个物品 承重为j的最大价值

        // dp[i][j] = max( dp[i-1][j] , dp[i-1][ j - weight[i] ] + v[i] );

        //初始化
        int sum = Arrays.stream( nums ).sum();
        if( sum % 2 == 1){
            return false;
        }
        int[][] dp  = new int[nums.length][ sum/2 + 1 ];

        //初始化 dp
        for(int j = nums[0] ; j <= sum/2 ; j++){
            dp[0][j] = nums[0] ;
        }


        // weight[i] = value[i] = nums[i]

        for(int i = 1 ; i < nums.length ; i++){
            for( int j = 0; j <= sum/2 ; j++){
                if( j < nums[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i-1][ j - nums[i] ] + nums[i] );
                }
            }

        }

        if( dp[ nums.length -1 ][ sum/2 ] == sum/2)
        {
            return true;
        }
        else
        {
            return false;
        }




    }
}