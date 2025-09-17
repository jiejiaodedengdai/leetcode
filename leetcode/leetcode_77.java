class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> tmp  =  new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        
        combineK( n , k , 1);

        return result;
    }

    private void combineK(int n , int k , int index ){

        if( tmp.size() == k)
        {
            result.add( new ArrayList<Integer>(tmp) );
            return ;
        }

        for(int i = index ; i <= n - (k - tmp.size()) + 1 ; i++ ) // 优化剪枝  把递归树的空节点减去
        {
            tmp.addLast( i );
            combineK( n , k , i + 1 );
            tmp.removeLast();
        }


    }
}