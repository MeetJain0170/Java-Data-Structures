public class findMax{
    public int fMax(int[]nums, int low, int high){
        if(low == high){
            return nums[low];
        }
        int sum=0;
        int leftMax=Integer.MIN_VALUE;
        int rightMax=Integer.MIN_VALUE;

        int mid=(low+high)/2;

        for(int i=mid;i>=low;i--){
            sum+=nums[i];
            if(sum>leftMax){leftMax=sum;}
        }
    
        for(int i=mid+1;i<high;i++){
            sum+=nums[i];
            if(sum>rightMax){rightMax=sum;}
        }

        int maxLR = Math.max(fMax(nums, low, mid), fMax(nums, mid+1, high));
        return Math.max(maxLR,leftMax+rightMax);
    }
    
        public static void main(String[] args) {
            findMax obj = new findMax();
            int[]a={1,4,7,-8,9,-10,5,3};
            int maxSum = obj.fMax(a,0,a.length-1);
            System.out.println(maxSum);
    }
}