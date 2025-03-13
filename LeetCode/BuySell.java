public class BuySell{
    static int once = 0;
    static int recurring = 0;
    public int maxProfitOnce(int prices[]){
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]<buy){
                buy = prices[i];
            }
            else if((prices[i]-buy) > profit){
                profit = prices[i]-buy;
            }            
        }
        once = profit;
        return profit;       
    }

    public int maxProfit(int prices[]){
        int profit = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i] < prices[i+1]){
                profit += prices[i+1] - prices[i];  
            }
            recurring += profit;
        }
        recurring = profit;
        return profit;
    }
    
    public static void main(String[] args) {
        BuySell obj = new BuySell();
        int arr[]={7,1,5,3,4,5};
        obj.maxProfitOnce(arr);
        obj.maxProfit(arr);
        System.out.println(once);
        System.out.println(recurring);
        
    }
}
