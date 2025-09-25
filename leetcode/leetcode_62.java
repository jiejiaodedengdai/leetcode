class Solution {
    public int uniquePaths(int m, int n) {
        
        //dp[m]][n] 表示到达m行 n列的方法数
        //dp[m][n] = dp[m-1][n] + dp[m][n-1] 前提要n>1 m > 1
        if(m== 1 || n==1){
            return 1;
        }

        int[][] dp = new int[m][n];

        dp[0][0] = 0;
        dp[1][0] = 1;
        dp[0][1] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if( i==0 || j==0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];

    }
}