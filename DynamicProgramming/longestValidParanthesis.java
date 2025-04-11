public class longestValidParanthesis {
    public static int longest(String s){
        int[]dp=new int[s.length()];
        int res=0;
        int leftCount=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                leftCount++;
            }
            else if(leftCount>0){
                dp[i]=dp[i-1]+2;
                dp[i]+=(i-dp[i]>=0?dp[i-dp[i]]:0);
                res=Math.max(res,dp[i]);
                leftCount--;
            }
        }return res;
    }
    public static void main(String[] args) {
        String s="()()()";
        System.out.println(longest(s));
    }
}
