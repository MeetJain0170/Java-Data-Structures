import java.util.*;
public class CoinExchange {
    public int getCombination(Integer[]coins, int sum){
            int res=0;
            Arrays.sort(coins, (a,b) -> b-a);
            for(int i=0; i<coins.length; i++){
                while(coins[i]<=sum){
                    sum-=coins[i];
                    res+=1;
                }
            }return res;
        }
        public static void main(String[] args) {
            CoinExchange obj = new CoinExchange();
            Integer coins[]={3,1,5,10,18};
            int ans=obj.getCombination(coins, 20);
        System.out.println(ans);
    }
}
