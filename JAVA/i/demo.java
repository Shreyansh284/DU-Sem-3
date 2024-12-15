import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo {
    public static void main(String[] args) {
    //     
        try
        {
            DataOutputStream d=new DataOutputStream(null);
            FileOutputStream fileuot=new FileOutputStream("abc.txt");
            FileInputStream filein=new FileInputStream("abc.txt");
            String s ="hello hi";
            byte b[]=s.getBytes();

            fileuot.write(56);

            fileuot.write(b);
            fileuot.close();
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }
}