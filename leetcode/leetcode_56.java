class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> result = new ArrayList<>();

        Arrays.sort( intervals , (a , b) -> Integer.compare( a[0] , b[0]) );

        int curcover = intervals[0][1];
        int startIndex = intervals[0][0];
        
        for( int i = 0 ; i < intervals.length ; i++){

            if( curcover >= intervals[i][0] ){
                curcover = Math.max( curcover , intervals[i][1] );
                startIndex = Math.min( startIndex , intervals[i][0] );
            }
            else
            {
                result.add( new int[]{ startIndex ,curcover }  ); 
                startIndex = intervals[i][0];
                curcover = intervals[i][1];
            }
        }

        // 合并最后一个区间
        result.add(new int[]{startIndex, curcover});

        return result.toArray(new int[ result.size() ][] );

    }
}