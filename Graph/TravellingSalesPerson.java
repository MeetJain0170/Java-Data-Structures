import java.util.*;
public class TravellingSalesPerson{
    public static int totalCost(int mask, int pos, int n, int[][] cost, int[][] dp){
        //Base case: If all cities are visited, return the cost to return to the starting city {0}
        if(mask == (1<<n) - 1){
           return cost[pos][0];
        }
        if(dp[pos][mask]!=-1){
            return dp[pos][mask];
        }
        int ans = Integer.MAX_VALUE;
    //Try visiting every city that has not been visited yet
        for(int i=0; i<n; i++){
            if((mask & (1<<i)) == 0){
                //If city i is not visited, visit it and update the mask
                ans = Math.min(ans, cost[pos][i] + totalCost(mask | (1 << i), i, n, cost, dp));
                }
            }
        dp[pos][mask] = ans;
        return ans;
    }
    public static int tsp(int[][] cost){
        int n = cost.length;
        int[][] dp = new int[n][1<<n];
            for(int i = 0; i<n; i++){
                Arrays.fill(dp[i],-1);
            }
        //Start from city 0 and only city 0 is visited initially so {mask = 1}
        return totalCost(1,0,n,cost,dp);
    }
    public static void main(String[] args) {
    // Example cost matrix for 4 cities
        int[][] cost = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        int res = tsp(cost);
        System.out.println("The minimum cost of the TSP tour is: " + res);
    }
}