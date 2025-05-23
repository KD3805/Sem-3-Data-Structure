import java.util.*;

public class Searching_Sorting {
    public static void main(String[] args) {
        int[] arr = {3,7,1,9,5,10,4};

        System.out.println("Unsorted array : ");
        display(arr);

        System.out.println("Sorted array : ");
        selectionSort(arr);

        // linearSearch(arr, 5);
        // binarySearch(arr, 10);
    }


    //linear search
    public static void linearSearch(int[] arr, int element) {
        boolean isPresent = false;
        int index = -1;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == element) {
                isPresent = true;
                index = i;
            }
        }
        if(isPresent == true && index != -1) {
            System.out.println("Element "+element+" is present at index "+index+" in sorted array");
        }
        else {
            System.out.println("Element "+element+" does not exist in array");
        }
    } 


    //binary search
    public static void binarySearch(int[] a, int element) {
        int[] arr = a;
        bubbleSort(arr);

        int low = 0;
        int high = arr.length - 1;
        boolean isFound = false;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(element < arr[mid]) {
                high = mid - 1;
            }
            else if(element == arr[mid]) {
                System.out.println("Element "+element+" is present at index "+mid+" in given array");
                isFound = true;
                break;
            }
            else {
                low = mid + 1;
            }
        }

        if(!isFound) {
            System.out.println("Element "+element+" does not exist in array");
        }

    }


    //bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean isSorted;

        for(int i=0; i<n-1; i++) {
            isSorted = true;

            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }

            if(isSorted) {
                break;
            }
        }
        display(arr);
    }


    //selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int minIndex;

        for(int i=0; i<n-1; i++) {
            minIndex = i;

            for(int j=i; j<n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
        display(arr);
    }


    //partition for quick sort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1;        // i is index of smaller element
    
        // Rearranging elements based on pivot
        for (int j = low; j < high; j++) {
          if (arr[j] <= pivot) {
            i++;
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
    
        // Place pivot in the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
    
        return i + 1; // Return pivot index
      }


    //quick sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Step 1: Partition the array and get pivot index
            int pi = partition(arr, low, high);
      
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);   // Left of pivot
            quickSort(arr, pi + 1, high);  // Right of pivot
        }
    }


    //display array
    public static void display(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //swap array elements
    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
