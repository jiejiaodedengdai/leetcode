class Solution {
    public int findLengthOfLCIS(int[] nums) {
        

        // 贪心思想  遍历一遍 从左往右 记录最大长度即可
        if( nums.length == 1){
            return 1;
        }
        int max = 1;

        int count = 1;

        for(int i = 1 ; i < nums.length ; i++){
            if( nums[ i ] > nums[i - 1] ){
                count++;
                max = Math.max( count , max );
            }
            else
            {
                count = 1;
            }
        }

        return max;
    }
}