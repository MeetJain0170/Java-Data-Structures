import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[]num){
        List<List<Integer>> list = new ArrayList<>();
        permuteUtil(list, new ArrayList<>(), num);
        return list;
    }
    public static void permuteUtil(List<List<Integer>> list, List<Integer>tempList, int[]nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i=0; i<nums.length;i++){
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                permuteUtil(list, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(permute(nums));
    }
}
