class Solution {


    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new LinkedList<>();

    boolean[] used ; 

    public List<List<Integer>> permuteUnique(int[] nums) {
        
        used = new boolean[ nums.length ];

        dfs( nums );

        return result;

    }

    private void dfs( int[] nums ){

        if( path.size() == nums.length )
        {
            result.add( new ArrayList<>( path ) );
            return ;
        }

        
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++ ){
            
            if( hs.size()!=0 && hs.contains( nums[i] ) 
                || used[i] ){
                continue;
            }
            hs.add( nums[i] );
            used[i] = true;
            path.add( nums[i] );
            dfs( nums );
            path.removeLast();
            used[i] = false;
        } 



    }



}