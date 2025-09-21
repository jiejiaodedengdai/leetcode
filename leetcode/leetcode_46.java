class Solution {


    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        
        dfs( nums );
        return result;

    }


    private void dfs(int[] nums )
    {
        if( path.size() == nums.length ){

            result.add( new ArrayList<>(path) );
            return ;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(!path.isEmpty()  && path.contains(nums[i]) ){
                continue;
            } 
            path.add( nums[i] );
            dfs( nums ) ;
            path.removeLast();
        }


    }


}