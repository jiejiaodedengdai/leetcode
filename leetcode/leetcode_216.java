class Solution {


    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> tmp  = new LinkedList<>();


    public List<List<Integer>> combinationSum3(int k, int n) {

            dfs( k , n , 1);
            return result ;

    }   



    public void  dfs(int nunmber , int target , int index )
    {
        
        if(target < 0 )
        {
            return ;
        }

        if( nunmber < 0)
        {
            return ;
        }

        if( nunmber == 0  && target == 0 )
        {
            result.add( new ArrayList<>(tmp) );
            return ;
        }

        

        for( int i = index  ;  i <= 9 ; i++  )
        {
            tmp.add(i);
            dfs(nunmber - 1 , target - i ,  i + 1);
            tmp.removeLast();


        }



    }
}