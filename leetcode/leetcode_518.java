class Solution {


    // 完全背包 处理该问题
    // dp[i][j] 表示 针对coins数组下标 0——i 之间的数 总金额为j的 方法组合数量
    public int change(int amount, int[] coins) {

        // 状态转移  放入当前硬币 和 不放入当前硬币
        // dp[i][j] = dp[i-1][j]  + dp[i][ j - coins[i] ]

        // 初始化 横向
        int[][] dp = new int[ coins.length ][ amount + 1];

        // coins[i] >= 1  所以背包重量为0 即 方法数为 1  不装
        
        for(int i = 0; i < coins.length; i++){
            dp[i][0] = 1;
        } 

        
        for(int j = coins[0] ; j <= amount ; j++)
        {
            if( j % coins[0] == 0){
                dp[0][j] = 1 ;
            }
            else{
                dp[0][j] = 0;
            }
        }

        for(int i = 1; i < coins.length ; i++){
            for(int j = 0; j <= amount; j++){
                if( j < coins[i] ){
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][ j-coins[i] ];
                }
            }
        }

        return dp[ coins.length - 1][ amount ];


    }




}