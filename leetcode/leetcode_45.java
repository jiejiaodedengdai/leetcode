class Solution {
    public int jump(int[] nums) {
        
        if(nums.length < 2){
            return 0;
        }
        
        //贪心算法 维护两个值
        //一个是当前最大覆盖范围
        //一个是下一个最大覆盖范围
        //如果当前最大覆盖范围无法达到最后面 走一步
        //得到走一步后的最大覆盖范围

        // 以最小的步数增加覆盖范围，覆盖范围一旦覆盖了终点，得到的就是最少步数！

        int curCover = nums[0]; 
        int count = 1; //至少需要1步
        int nextCover = 0;
        for(int i = 0 ; i < nums.length ; i++){

            if(curCover >= nums.length - 1){
                return count;
            }
            
            count++;
            for(int j = i ; j <= curCover ; j++)
            {
                nextCover = Math.max(nextCover , nums[j] + j);
            }
            curCover  = nextCover;
        }

        return count;
    }
}