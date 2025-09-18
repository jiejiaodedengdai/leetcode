class Solution {


    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path  = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs( candidates , target , 0);
        return result ;
        
    }


    private void dfs(int[] candidates ,  int target , int start )
    {
        if(target < 0)
        {
            return;
        }

        if( target == 0 )
        {
            result.add( new ArrayList<>(path) );
            return ;
        }

        for(int i = start; i < candidates.length ; i++)
        {
            path.add( candidates[i] );
            target = target - candidates[i];

            dfs(candidates , target , i  );

            target = target + candidates[i];
            path.removeLast();

        }

    }

}