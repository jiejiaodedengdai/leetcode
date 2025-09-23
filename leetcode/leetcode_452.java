class Solution {
    public int findMinArrowShots(int[][] points) {

        //依据x start排序 根据x end 和 后一个 start 进行判断是否射箭
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 1;
        int curcover = points[0][1];
        for(int i = 0; i < points.length  ; i++){
            if( curcover < points[i][0] ){
                result++;
                curcover = points[i][1];
            } else {
                // 否则，更新覆盖范围为两个气球终点的较小值
                // 范围需要缩小 
                curcover = Math.min(curcover, points[i][1]);
            }
        }
        return result;
    }
}