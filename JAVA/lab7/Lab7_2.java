
interface A {

int a=10;

void printA();
}
interface  A1 extends A {
    int a1=10;
    void printA1();
    
}
interface A2 extends A
{
    int a2=10;
    void printA2();
}
interface A12 extends A1,A2
{
    int a12=10;
    void printA2();
}

class B implements A12
{
    public void printA()
    {
      System.out.println("METHOD PRINT A "+ "VARIABLE A"+ a);  
    }
    public void printA1()
    {
      System.out.println("METHOD PRINT A1 "+ "VARIABLE A1"+ a1);  
    }
    public void printA2()
    {
      System.out.println("METHOD PRINT A2 "+ "VARIABLE A2"+ a2);  
    }
    public void printA12()
    {
      System.out.println("METHOD PRINT A12 "+ "VARIABLE A12"+ a12);  
    }

}

public class Lab7_2 {

    public static void main(String[] args) {
        B b=new B();
        b.printA();
        b.printA1();
        b.printA2();
        b.printA12();
    }
    
}
