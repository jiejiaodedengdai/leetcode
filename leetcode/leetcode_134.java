class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int result = -1;
        int tmp = 0;
        int j = 0;
        for(int i = 0; i < gas.length ; i++){
            
            for( j = 0 ; j < cost.length; j++){
                int idx = (i + j) % cost.length; // 环形取模
                tmp += gas[idx];
                tmp -= cost[idx];
                if(tmp < 0){
                    break;
                }
            }
            if( j == cost.length ){
                return i;
            }
            tmp = 0;
            i = i + j ; //i 到 i加j 的位置为负数 所以不可能取内部数
        }

        return -1;

    }
}