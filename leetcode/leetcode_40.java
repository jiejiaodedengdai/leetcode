class Solution {


    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates); // 先排序，方便去重
        dfs(candidates , target , 0);
        return result;

    }

    private void dfs( int[] candidates , int target , int index  )
    {   
        if(target < 0)
        {
            return ;
        }

        if(target == 0)
        {
            result.add( new ArrayList<>(path) );

            return ;
        }


        for( int i = index ; i < candidates.length ; i++)
        {
             // **去重逻辑**：同一层中，相同数字只取第一个
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add( candidates[i] );

            dfs(candidates , target - candidates[i] , i + 1);

            path.removeLast();

        }


    }


}