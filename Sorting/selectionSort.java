public class selectionSort {
    public static void selectionSorting(int[] arr){
        for(int i=0; i<arr.length-1;i++){
            //assuming i index as min value index
            int min_index = i;
            //Finding the minimum value index
            for(int j=i+1; j<arr.length;j++){
                if(arr[j]<arr[min_index]){
                    min_index=j;
                }
            }

            //swapping the i index with the minimum value index
            int temp=arr[i];
            arr[i]=arr[min_index];
            arr[min_index]=temp;
        }
    }
    public static void main(String[] args) {
        int [] arr={43,21, 44, 12, 5, 10, 2, 90};
        for(int ele: arr){
            System.out.print(ele + " ");
        }

        System.out.println();
        selectionSorting(arr);

        for(int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}
