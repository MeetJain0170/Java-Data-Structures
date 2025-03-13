import java.util.*;

public class LongestIncreasingSubsequence {
    public static int findNumberLIS(int[]nums){
        if(nums.length == 1){return 1;}
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        int[]count=new int[n];
        Arrays.fill(count,1);
        int maxLength = 1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1 > dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    else if (dp[j]+1 == dp[i]) {
                        count[i]+=count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        int r=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLength){
                r+=count[i];
            }
        }return r;
    }
    public static void main(String[] args) {
        int[]nums={2,2,2,2,2};
        System.out.println(findNumberLIS(nums));
    }
}
