class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        

        
        // 按起点排序，使用Integer.compare避免整数溢出
        Arrays.sort(intervals , (a, b) -> Integer.compare(a[0], b[0]));

        int result = 0;

        //设置当前右边覆盖范围
        int curcover = intervals[0][1];
        for(int i = 1 ; i < intervals.length ; i++){
            //如果当前覆盖范围 比 当前节点的左边界大
            if( curcover > intervals[i][0]){
                //需要移除一个数组
                result++;
                //更新当前覆盖范围 取右边界的较小值
                curcover = Math.min( curcover , intervals[i][1] );
            }
            else {
                //直接更新当前覆盖范围
                curcover = intervals[i][1];
            }
        } 

        return result;
       
    }

}
