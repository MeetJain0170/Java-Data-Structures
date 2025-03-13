public class QuickSort {
    public static int partition(int[] arr,int low,int high) {
		int pivot=arr[low+(high-low)/2];
		int i=low-1;
		int j=high+1;
		while(true) {
			do {
				i++;
			}
			while(arr[i]<pivot);
			
			do {
				j--;
			}
			while(arr[j]>pivot);
			
			if(i>=j)
				return j;
			
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;	
		}
	}

    //main function to sort the array
    public static void QuickSorting(int arr[], int low, int high){
        if(low<high){
            //pi is the partitioning index
            int pi = partition(arr, low, high);

            //recursively sort elements before and after partition
            QuickSorting(arr,low,pi);
            QuickSorting(arr, pi+1, high);
        }
    }

    //to print sorted array
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    //Driver Code
    public static void main(String[] args) {
        int arr[] = {10,7,8,11,5,6,33,2,12};
        int n = arr.length;

        printArr(arr);
        //function call
        QuickSorting(arr, 0, n-1);
        System.out.println("Sorted Array: ");
        printArr(arr);
    }
}
