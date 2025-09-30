class Solution {
    public int maxProfit(int k, int[] prices) {
        
        // dp[ prices.length ][k][2];
        
        // dp[ prices.length ][ j ][0] 在最多j次交易时没有股票 最大利润
        // dp[ prices.length ][ j ][1] 在最多j次交易时拥有股票 最大利润

        int[][][] dp = new int[ prices.length ][ k + 1][ 2 ];



        // dp[ i ][ j ][ 0 ] = max ( dp[ i - 1 ][ j ][ 0 ] , dp[ i - 1 ][ j ][ 1 ] + prices[ i ] )
        // dp[ i ][ j ][ 1 ] = max ( dp[ i - 1 ] [ j - 1][ 0 ] - prices[i] , dp[ i - 1][ j ][ 1 ] )

         // dp数组初始化
        // 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }

        for( int i = 1; i < prices.length ; i++){
            for(int j = 1; j <= k ; j++){
                dp[ i ][ j ][ 0 ] = Math.max( dp[ i - 1 ][ j ][ 0 ] , dp[ i - 1 ][ j ][ 1 ] + prices[ i ] );
                dp[ i ][ j ][ 1 ] = Math.max(  dp[ i - 1 ] [ j - 1][ 0 ] - prices[i] , dp[ i - 1][ j ][ 1 ]);
            }
        }

        return dp[  prices.length - 1][ k ][ 0 ];


    }
}