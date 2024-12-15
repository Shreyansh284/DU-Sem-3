public class Threaddemo {

    public static void main(String[] args) {
        new Newthread();
        try {
            for(int i=1;i<=5;i++)
            {
                System.out.println("void "+i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        
            System.out.println(e);
        }
        System.out.println("ecute main");
    }

}

class Newthread extends  Thread 
{
    Newthread()
    {
        System.out.println("child "+this);
        start();
    }

     public void run()
    {
        {
        try
        {
            for(int i=5;i>0;i--)
            {
            
                System.out.println("child "+i);
                // Thread.sleep(200);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("excute child");
    }
    }
}
