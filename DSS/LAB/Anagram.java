import java.util.*;
public class Anagram {
    
    public static void main(String[] args) {
        String s[]=new String[5];
        Scanner sc =new Scanner(System.in);
        Random random=new Random();

        for(int i=0;i<5;i++)
        {
            System.out.println("Enter Word : "+ (i+1) ); 
            s[i]=sc.next();
        }

        int randomNumber = random.nextInt(5);
        String randomWord=s[randomNumber];
        System.out.println("Selected Word is : " + randomWord);

        char [] randomWordArray= randomWord.toCharArray();
        Arrays.sort(randomWordArray);
        String anagram;

        System.out.println("Enter Anagram");
        anagram = sc.next();

        char [] anagramArray= anagram.toCharArray();

        Arrays.sort(anagramArray);

        if(Arrays.equals(randomWordArray, anagramArray))
        {
            System.out.println("Correct! The word you entered is an anagram.");
        }
        else{
            System.out.println("InCorrect! The word you entered is not an anagram.");
        }

    }

}
