class Solution {



    List<String> result = new ArrayList<>();

    StringBuilder path = new StringBuilder();
    

    public List<String> restoreIpAddresses(String s) {

        dfs( s , 0 , 0);
        return result;
    }


    private void dfs( String s, int index , int count ){

        if( count > 4){
            return ;
        }
        if( count == 4 && s.length() == index){

            StringBuilder m = new StringBuilder(path);
            m.deleteCharAt( m.length() - 1);
            result.add(  m.toString()  );

            return ;

        }

        StringBuilder kk = new StringBuilder();

        for(int i = index ; i < s.length()  ; i++){
            
            kk.append( s.charAt( i ) );
           
            if( val( kk )  ){
                
                path.append( kk );
                path.append('.');
                count++;
                dfs( s , i+1 , count);
                count--;
                path.delete(path.length() - kk.length() - 1, path.length());

            }
        }
    }
    private boolean val( StringBuilder s )
    {
        if(s.length() > 1 && s.charAt(0) == '0') return false;  //处理前导 0 问题



        if(s.length() > 3)
        {
            return false;
        }

        int ip = Integer.parseInt( s.toString() );

        if( ip < 256 && ip >=0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }


}