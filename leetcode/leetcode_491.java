class Solution {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        dfs( nums , 0);
        return result;
    }



    private void dfs( int[] nums , int index){

        if( path.size() > 1 ){

            result.add( new ArrayList<>(path) );
        }

        HashSet<Integer> hs = new HashSet<>();

        //List<Integer> list = new ArrayList<>();
        for( int i = index ; i < nums.length ; i++){
            
            if(  (path.size()!=0)  && path.get( path.size() - 1) > nums[i] ||
                 hs.contains( nums[i]) )
            {
                continue ;
            }

                hs.add( nums[i] );

                path.add( nums[i] );

                dfs(nums , i + 1);

                path.removeLast();
            
        }
    }




}