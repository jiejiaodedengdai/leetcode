class Solution {
    public boolean canJump(int[] nums) {
        
        int cover = nums[0];
        // 从局部可达 到 整体可达 的贪心思想
        //定义cover 表示局部可达
        //不断向后 遍历 得到最大可达
        //判断最大可达是否 大于等于最后一个下标位置

        for(int i = 0 ; i < nums.length ; i++){
            
            if(cover < i){
                return false;
            }
            cover = Math.max( cover ,  nums[i] + i);
        }

        if( cover >= nums.length - 1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}