class Searching {

    public void linearSearch(int arr[], int length, int search) {

        for (int i = 0; i < length; i++) {
            if (arr[i] == search) {
                System.out.println("Element Present At : " + i);
                return;
            }
        }
        System.out.println("Element Not Present At : ");
    }

    public void binearSearch(int arr[], int length, int search) {
        int left = 0, right = length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == search) {
                System.out.println("Element Present At : " + mid);
                return;
            } else if (arr[mid] < search) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Element Not Present At");
    }

    public void binearSearchUsingRecurrsion(int arr[], int search, int left, int right) {
        if (right >= 1 && left <= arr.length - 1) {
            int mid = (left + right) / 2;

            if (arr[mid] == search) {
                System.out.println("Element Present At : " + mid);

            } else if (arr[mid] < search) {
                binearSearchUsingRecurrsion(arr, search, mid + 1, right);
            } else {
                binearSearchUsingRecurrsion(arr, search, left, mid - 1);
            }
            return;
        }

        System.out.println("Element Not Present At");

    }

}

class Sorting {

    public void selectionSort(int arr[], int length) {
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }
        display(arr);
    }

    public void bubbleSort(int arr[], int length) {

        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;

                }
            }
        }

        if (count <= 0) {
            System.out.println("No Swap Accured");
        }
        display(arr);
    }

    public void insertionSort(int arr[], int length) {

        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        display(arr);
    }

    public void shellSort(int arr[],int length)
    {
        for(int gap=length/2;gap>=1;gap=gap/2)
        {
            for(int j=gap;j<length;j++)
            {
                for(int i=j-gap;i>=0;i=i-gap)
                {
                    if(arr[i+gap]>arr[i])
                    {
                        break;
                    }
                    else
                    {
                        swap(arr,i+gap, i);

                    }
                }
            }
        }
        display(arr);
    }

    public void countingSort(int  arr[], int length, int max)
    {
        int[] output = new int[length];
        int[] count = new int[max + 1];
        for (int i = 0; i < count.length; i++) 
        {
            count[i]=0;
        }
        for(int j=0;j<length;j++)
        {
            count[arr[j]]++;
        }
        for(int j=1;j<count.length;j++)
        {
            count[j]+=count[j-1];
        }
        for(int j=length-1;j>=0;j--)
        {
            output[count[arr[j]]-1]=arr[j];
            count[arr[j]]--; 
        }

        display(output);

    }

    void radixSort(int arr[],int length)
    {
       SearchingSorting.maxFromArray(arr);
    }

    // util function     

    public void swap(int arr[],int a, int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    void display(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

public class SearchingSorting {
    public static int maxFromArray(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }
    public static void main(String[] args) {
        int arr[] = { 2, 1, 1, 6, 4,2};
        int length = arr.length;
        // int search=5;
        // Searching searching=new Searching();

        // LINER SEARCH

        // searching.linearSearch(arr,length,search);

        // searching.binearSearch(arr,length,search);
        // searching.binearSearchUsingRecurrsion(arr,search,0,length-1);

        Sorting sorting = new Sorting();

        // sorting.bubbleSort(arr, length);
        // sorting.selectionSort(arr, length);
        // sorting.insertionSort(arr, length);
        // sorting.shellSort(arr, length);
        sorting.countingSort(arr, length,maxFromArray(arr));
    }
}
