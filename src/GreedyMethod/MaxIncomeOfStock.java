package GreedyMethod;
//可以有一次买入和一次卖出，那么买入必须在前。求最大收益。
//假设第i轮卖出，那么最大收益是找前面最小的数字卖出即可
public class MaxIncomeOfStock {
    public int getRes(int[] arr){
        if (arr==null||arr.length==0){
            return 0;
        }
        int minPrice=0;
        int maxIncome=0;
        for (int i=0;i<arr.length;i++){
            minPrice=Math.min(minPrice,arr[i]);
            maxIncome=Math.max(maxIncome,arr[i]-minPrice);
        }
        return maxIncome;
    }
}
