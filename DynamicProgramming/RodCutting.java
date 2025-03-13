import java.util.*;
public class RodCutting {
    public int[] maxProfit(int[]profit){
        int n = profit.length;
        int [] dp = new int[n+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1; j<=i;j++){
                dp[i]=Math.max(dp[i],profit[j-1]+dp[i-j]);
            }
        }
        System.out.println("Maximum Profit " + dp[n]);
        return dp;
        
    }

    public static void main(String[] args) {
        
        RodCutting obj = new RodCutting();
        int[]rates={1,3,5,12,17,10,21,31,26,44,24,32,45};
        System.out.println("Here is the array for it: " + Arrays.toString(obj.maxProfit(rates)));
    }
}