class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        

     // 求得left - right = target
     //    left + right  = sum
     //    left = (sum + target) / 2

     //    转化成背包问题 或者 组合问题都可以（回溯算法）
     //  背包问题 把 left 当初背包容量 
     //  组合问题 用回溯算法 把left 当成组合的target 

    //dp[i][j]：使用 下标为[0, i]的nums[i]能够凑满j（包括j）这么大容量的包，有dp[i][j]种方法

     int sum = Arrays.stream( nums ).sum();

     int left = ( sum + target ) / 2;
     if( (sum + target) % 2 == 1){
        return 0;
     }
    
     if( Math.abs( target ) > sum ){
        return 0;
     }


     int[][] dp = new int[ nums.length ][ left + 1];

        // 刚好 0号物品的值 为 容量 一种方法
        if (nums[0] <= left) {
            dp[0][nums[0]] = 1;
        }

        // 初始化最左列（dp[i][0])
        // 当从nums数组的索引0到i的部分有n个0时（n > 0)，每个0可以取+/-，因此有2的n次方中可以取到j = 0的方案
        // n = 0说明当前遍历到的数组部分没有0全为正数，因此只有一种方案可以取到j = 0（就是所有数都不取）
        int numZeros = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);

        }

     for(int i = 1; i < nums.length ; i++){
        for(int j = 0; j <= left ; j++){
            if( nums[i] > j){
                dp[i][j] = dp[i-1][j];
            }
            else
            {
                dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i]];
            }
        }
     }
    
   

     return dp[ nums.length - 1 ] [ left ];

    }
}