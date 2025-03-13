public class RotateArray {
    public void Rotate(int [] nums, int k){
        k = k%nums.length;
        Swap(nums,0,nums.length -1);
        Swap(nums,0,k-1);
        Swap(nums,k,nums.length-1);
    }

    public static void Swap(int []nums, int start, int end){
        for(int i=0;i <nums.length; i++){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
