class Solution {


    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();



    public List<List<Integer>> subsetsWithDup(int[] nums) {


        Arrays.sort( nums );
        dfs( nums , 0);
        
        return result ;


    }


    private void dfs( int[] nums , int index){
        
        
        result.add( new ArrayList<>( path ) );




        for(int i = index ; i < nums.length ; i++){

            if(i > index && nums[ i ] == nums[i - 1])
            {
                continue;
            }
            
            path.add( nums[i] );
            dfs( nums ,  i + 1);

            path.removeLast();


        }





    }


}