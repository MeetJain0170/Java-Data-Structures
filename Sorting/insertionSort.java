public class insertionSort {
    public static void insertionSorting(int []arr) {
        if(arr == null || arr.length == 1){
            return;
        }        
        for(int i=0; i<arr.length; i++){
            int key = arr[i];
            int j= i-1;

            //Inserting the current key at the right place
            while(j >= 0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void main(String[] args) {
        int [] arr={43,21, 44, 12, 5, 10, 2, 90};
        for(int ele: arr){
            System.out.print(ele + " ");
        }

        System.out.println();
        insertionSorting(arr);

        for(int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}
