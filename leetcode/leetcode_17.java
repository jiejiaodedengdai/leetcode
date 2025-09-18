class Solution {
    


     String[] data = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    } ; 

    List<String> result = new ArrayList<>();

    StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {

        
        dfs(digits , 0);

        return result ; 

    }


    private void dfs( String digits ,  int index  )
    {
        if(digits.length() == 0)
        {
            return ;
        }

        if( path.length() == digits.length() )
        {
            result.add( path.toString() );
            return ;
        }

        
        int tmp = digits.charAt(index) - '0';

        String chara = data[tmp] ;

        for(int i = 0 ; i < chara.length() ; i++)
        {
            char s  = chara.charAt(i) ;

            path.append( s );

            dfs( digits , index  + 1);

            path.deleteCharAt(path.length() - 1);


        }





    }

}