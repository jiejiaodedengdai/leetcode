class Solution {


    List<List<String>> result = new ArrayList<>();

    List<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        

        dfs( s , 0);
        return result ;
    }


    private void dfs(String s , int index )
    {
        if( index == s.length() )
        {
            result.add( new ArrayList<>(path) );
            return ;
        }

        StringBuilder tmp = new StringBuilder();
        for( int i = index ; i < s.length() ; i++ )
        {
            tmp.append( s.charAt(i) );

            if( hw(tmp) )
            {
                path.add( tmp.toString() );

                dfs(s , i + 1);

                path.removeLast();

            }
        }


    }


    private Boolean hw( StringBuilder s)
    {
        int left = 0;
        int right = s.length()  - 1;

        while(left <= right)
        {
            if( s.charAt(left) != s.charAt(right) )
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



}