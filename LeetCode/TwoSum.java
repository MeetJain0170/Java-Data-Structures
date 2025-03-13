public class TwoSum {
    public int[] twoSum(int nums[], int target){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if((nums[i]+nums[j]) == target){
                    return new int[]{i,j};
                }
            }
        }return new int[]{};
    }
    public static void main(String[] args) {
        int [] arr = {2,7,5,3};
        TwoSum obj = new TwoSum();
        int [] ans = obj.twoSum(arr,9);
        for(int i=0; i<arr.length; i++){
            System.out.print(ans[i]);
            System.out.print(",");
        }
    }
}
