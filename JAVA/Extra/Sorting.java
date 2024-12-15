import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    
        System.out.println("Enter Size Of array : ");
        int size=sc.nextInt();
        int arr[]=new int[size];

        for(int i=0 ;i<=size-1;i++)
        {
            System.out.println("Enter Element At"+ (i+1));
            arr[i]=sc.nextInt();
        }

        bubbleSort(arr);

        serachInRotatedArray(arr);
        
    }
    public static void serachInRotatedArray(int arr[])
    {
              Scanner sc=new Scanner(System.in);

              
              int newArr[]=bubbleSort(arr);
              System.out.println("Sorted  Array Is : ");
              for(int i=0;i<arr.length;i++)
              {
                System.out.print(newArr[i] + " , ");
              }

              System.out.println("Enter Pivot Index");
              int pivot=sc.nextInt();  

              if(pivot>arr.length)
              {
                System.out.println("Pivot Out Of Index Plzz Choose Between 0 and " + (arr.length-1));
                return;
              } 

              int rotatedArray[]=rotateArray(newArr,pivot);
              System.out.println("Rotated Array Is : ");
              for(int i=0;i<arr.length;i++)
              {
                System.out.print(rotatedArray[i] + " , ");
              }
            

                
    }

    public static int [] rotateArray(int arr[], int pivot)
    {
        int length=arr.length;

        // full reverse
        reverse(arr,0,length-1);
        // 1st part before pivot reverse
        reverse(arr,0,length-pivot-1);
        // 2nd part after pivot reverse
        reverse(arr,length-pivot,length-1);

        return arr;
    }

    public static int[] reverse(int arr[], int start,int end)
    {
        while (start<end) {
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
            
        }
        return arr;

    }


    public static int[] bubbleSort(int arr[])
    {
        
        for(int i=0; i<arr.length;i++)
        {
            for(int j=0; j<arr.length;j++)
            {
                if(arr[i]<arr[j])
                {
                    int temp =arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
        // for(int i=0 ;i<arr.length;i++)
        // {
        //     System.out.print(arr[i]+" ");
        // }
      
    }
}
