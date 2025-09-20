class Solution {


    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {


        result.add( new ArrayList<>(path) );

        dfs(nums , 0);



        return result;
        
    }

    private void dfs(int[] nums , int index){

        if( path.size() != 0 )
        {
            result.add( new ArrayList<>(path) );
        }

        for(int i = index ;  i < nums.length ; i++){

            path.add( nums[i] );

            dfs( nums , i+1) ;

            path.removeLast();
        }
    }

}