class Solution {
    public int rob(int[] nums) {
        
        
       // 两种情况
       // 考虑首元素 则不考虑尾元素 0 - nums.length-2 的最大
       // 考虑尾元素 不考虑首部元素 1 - nums.length-1 的最大
      // 比较最大值即可
        
       

        if( nums.length == 1){
            return nums[0];
        }

        if( nums.length == 2){
            return Math.max( nums[0] , nums[1] );
        }

        int left = rob1( nums , 0 , nums.length - 2);
        int right = rob1( nums , 1, nums.length - 1);

        return Math.max( left , right );


    }


     public int rob1(int[] nums , int start , int end) {
        
        
        // dp[ i ] = max( dp[i-1] , dp[ i - 2] + nums[i])
        if( end - start == 1){
            return Math.max( nums[start] , nums[end] );
        }

         int[] dp = new int[  end - start + 1 ];
          dp[ 0 ] = nums[ start ];
          dp[ 1 ] = Math.max( nums[ start ] , nums[ start + 1] );

        for(int i = 2 ; i < end - start + 1 ; i++){
            dp[ i ] = Math.max( dp[ i - 1] , dp[ i - 2 ] + nums[start + i] );
        } 

        return dp[ end  - start ];

    }

}