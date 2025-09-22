class Solution {


    public int maxProfit(int[] prices) {
        
        if( prices.length < 2){
            return 0;
        }

        // 在波谷买股票 在波峰出售股票  
        // 多个局部最优解 一起构成整体最优解 
        // 当前值 小于 后面值 可以购买
        // 当前值 大于 后面值 可以出售（前提是拥有股票）
        int result =  0;
        int flag = 0 ;  // 表示没有股票 

        int tmpPrice = 0;  //当前购买股票的价格

        int curdiff = 0;
        for(int i = 0 ; i < prices.length - 1 ; i++){
            curdiff = prices[i] - prices[i+1];
            if( curdiff < 0 && flag == 0){
                flag = 1;
                tmpPrice = prices[i];
            }

            if( curdiff > 0  && flag == 1){
                result += prices[i] - tmpPrice;
                flag = 0;
            }
        }
        
        //判断最后是否还拥有股票 拥有则说明最后为递增的 抛售出去
        if( flag == 1 ){
            result += prices[ prices.length - 1] - tmpPrice;
        }


        return result;

    }
}