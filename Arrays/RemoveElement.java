public class RemoveElement {
    public int removeElement(int nums[], int val){
        int sum = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != val){
                sum++;
                nums[sum] = nums[i];
            }
        }return sum;
    }
    public static void main(String[] args) {
        RemoveElement obj =new RemoveElement();
        int arr[] = {3,2,2,3};
        int newl = obj.removeElement(arr, 3);

        System.out.println("New length: " + newl);
        System.out.print("Modified array: ");
        for (int i = 0; i < newl; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}