public class CommandLineInput{

    public static void main(String[] args){

        int a = Integer.ParseInt(args[0]);
        int b = Integer.ParseInt(args[1]);

        System.out.println("Addition is :"+(a+b));

    }
}