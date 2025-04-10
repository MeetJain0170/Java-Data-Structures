import java.util.*;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        if(nums.length == 2&& (nums[0]+nums[1])==target){
            return new int[] {0,1};
        }
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]),i};
            }map.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,9,7,11};
        int target=13;
        int[] result = twoSum(nums,target);
        for(int num: result){
            System.out.print(num+" ");
        }
    }
}   