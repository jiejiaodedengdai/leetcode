class Solution {

    public int largestSumAfterKNegations(int[] nums, int k) {
        
        while(k > 0){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0 ; i < nums.length ; i++){
                if( nums[i] < min ){
                    
                    min = nums[i];
                    index = i;
                }
            }
            //剪枝优化 如果全为正数 且k为偶数 即可跳出循环
             if( nums[index] > 0 && (k % 2 == 0) ){
                break;
            }
            nums[index] = nums[index] - 2*nums[index];
            k--;
        }
        int sum = 0;
        for(int i = 0; i < nums.length ; i++){
            sum += nums[i];
        }
        return sum;
    }
}