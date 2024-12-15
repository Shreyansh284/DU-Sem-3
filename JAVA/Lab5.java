import java.util.Scanner;

public class Lab5 {

    public static void CountVowelAndConsonants(){
        Scanner sc = new Scanner(System.in);        
        String word ;
        System.out.println("Enter Word");
        word=sc.next();
        int vowelCount=0;
        int consonantCount=0;

        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)=='a'|| word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u'||word.charAt(i)=='A'|| word.charAt(i)=='E'||word.charAt(i)=='I'||word.charAt(i)=='O'||word.charAt(i)=='U')
            {
                vowelCount++;
            }
            else {
                if(word.charAt(i)==' ')
                {
                    continue;
                }
                else{
                    consonantCount++;
                }

            }

        }

        System.out.println("Number Of Vowel : "+ vowelCount + " Number Of Consonant : "+ consonantCount);

    }

    public static void arrayAvg()
    {
        Scanner sc = new Scanner(System.in);        
        int size ;
        System.out.println("Enter Size of Array");
        size=sc.nextInt();
        
        int array[] =new int[size];

        for (int i=0;i<size;i++) {
            
            System.out.println("Enter Value of "+ (i+1)+ " Element ");
            array[i]=sc.nextInt();
        }
        int sum=0;

        for(int i=0;i<size;i++)
        {
            sum+=array[i];
        }

        System.out.println("Avg Of Array is : " + sum/size);

    }
    public static void reverseArray()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Array");
        int size=sc.nextInt();
        
        int array[] =new int[size];

        for (int i=0;i<size;i++) {
            System.out.println("Enter Value of "+ (i+1)+ " Element ");
            array[i]=sc.nextInt();
        }
        int newArray[] = new int[size];

        for(int i=0, j=size-1; i<size && j>=0; i++,j--)
        {
            System.out.println(i + "-" + j);
             newArray[i]=array[j];
        }
        System.out.println("Array: ");
         for (int i=0;i<size;i++) {
            System.out.println(newArray[i]);
        }
}

    public static void halfString()
    {
        Scanner sc = new Scanner(System.in);        
        String word ;
        System.out.println("Enter Word");
        word=sc.next();

        int length=word.length();
        System.out.println(length);

        for(int i=0;i<length/2;i++)
        {
            System.out.print(word.charAt(i));
        }


    }

    public static void main(String[] args) {
        
        // CountVowelAndConsonants();
        // arrayAvg();
        reverseArray();
        // halfString();




    }
    
}
