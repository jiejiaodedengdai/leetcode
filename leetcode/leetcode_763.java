class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] indexLast = new int[26] ;

        // 顺序遍历一次 得到每个字母的最后下标
        for(int i = 0 ; i < s.length() ; i++){
            indexLast[  s.charAt( i ) - 'a' ] = i;
        }

        // 顺序遍历一次 根据当前字母的下标 是否等于最后的下标 进行分割

        Integer count = 1;
        List<Integer> result = new ArrayList<>();

        //创建临时字符串 存储当前字符串 
        StringBuilder tmp = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            
            tmp.append( s.charAt(i) );
            int j = 0;
            //遍历临时字符串
            for(  j = 0; j < tmp.length() ; j++){
                //如果存在字母下标 大于 当前下标 不能分割
                if( indexLast[ tmp.charAt(j) - 'a'] > i )
                {
                   break;
                } 
            }
            if( j == tmp.length() ){
                result.add( count );
                count = 1;
                tmp.setLength(0);
            }
            else{
                count++;
            }
        }

        return result;
    }
}