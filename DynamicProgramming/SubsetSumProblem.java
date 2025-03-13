public class SubsetSumProblem {
    public boolean Sum(int[] nums,int sum){
        int n=nums.length;
        boolean[][]dp = new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1; j<=sum; j++){
                if(j<nums[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }return dp[n][sum];
    }

    public static void main(String[] args) {
        SubsetSumProblem obj = new SubsetSumProblem();
        int arr[]={2,5,7,12,17,6};
        System.out.println(obj.Sum(arr, 11));
    }
}
