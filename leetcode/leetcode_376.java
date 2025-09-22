class Solution {
    public int wiggleMaxLength(int[] nums) {
        

        if( nums.length < 2){
            return nums.length;
        }

        int result = 1; //默认第一个数为波峰或者波谷

        //贪心思想 
        /* 局部最优解为每一次 波峰和波谷 除去掉无效的中间上升和下降部分
            整体得到了最优解
            注意水平时需要 只能剩下一个值
            还要排除掉单调值的影响
        */

        int prediff =  nums[1] - nums[0];
        int curdiff = 0;

        for(int i = 0; i < nums.length - 1 ; i++){
            curdiff = nums[i] - nums[i + 1];
            if( (prediff <= 0 && curdiff > 0)
                || (prediff >= 0 && curdiff < 0) )
            {
                result++;
                prediff = curdiff; // 排除掉单调序列的影响 
            }
            
        }

        return result;

    }
}