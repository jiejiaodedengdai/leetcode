class Solution {
    public int candy(int[] ratings) {
        

        int candy[] = new int[ ratings.length ];
        Arrays.fill(candy , 1);
        //前向遍历 右边比左边大 即加1个糖果
        for(int i = 0; i < ratings.length - 1 ; i++){
            if( ratings[i] < ratings[i + 1]){
                candy[i + 1] = candy[i] + 1;
            }
        }
        //后向遍历
        for(int i = ratings.length - 1; i > 0 ; i--){
            if( ratings[i] < ratings[i-1] ){
                candy[i - 1] = Math.max( candy[ i-1 ] , candy[i] +1);
            }
        }
        int sum = 0;
        for(int i = 0 ; i < candy.length ; i++){
            sum += candy[i];
        }
        return sum;
    }
}