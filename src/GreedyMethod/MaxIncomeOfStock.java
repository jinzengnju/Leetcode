package GreedyMethod;
//可以有一次买入和一次卖出，那么买入必须在前。求最大收益。
//使用贪心策略，假设第 i 轮进行卖出操作，买入操作价格应该在 i 之前并且价格最低。
public class MaxIncomeOfStock {
    public int getRes(int[] arr){
        int minValue=arr[0];
        int maxIncome=0;
        for (int i=1;i<arr.length;i++){
            minValue=Math.min(minValue,arr[i]);
            maxIncome=Math.max(maxIncome,arr[i]-minValue);
        }
        return maxIncome;
    }
}
