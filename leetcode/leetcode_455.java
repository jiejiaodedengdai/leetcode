class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort( g );
        Arrays.sort( s );
        int j = s.length - 1 ;
        int count = 0;
        for(int i = g.length - 1 ;  i >=0 ; i--){
            if( j>=0 && g[i] <= s[j] )
            {
                j--;
                count++;
            }
        }
        return count;
    }
}