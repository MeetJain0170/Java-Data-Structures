public class slidingWindow {
    public static int[] max(int[]nums, int k){
        int n=nums.length;
        int[]index=new int[n];
        int[]res=new int[n-k+1];
        int first=0;
        int last=0;
        for(int i=0; i<n; i++){
            while(first<last && nums[index[last-1]]<=nums[i]){
                last--;
            }
            index[last++]=i;
            if(index[first]==i-k){
                first++;
            }
            if(i>=k-1){
                res[i-k+1]=nums[index[first]];
            }
        }return res;
    }
}
