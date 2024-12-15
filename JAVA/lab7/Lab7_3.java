interface Transport
{
    void deliver();
}

abstract class Animal
{
    
}

class Tiger extends Animal
{
    
}
class Camel extends Animal implements Transport
{
    public void deliver()
    {
        System.out.println("CAMAL DELIVERED");
    }
}
class Donkey extends Animal implements Transport
{
    public void deliver()
    {
        System.out.println("Donkey DELIVERED");
    }
}
class Deer extends Animal
{

}

public class Lab7_3 {
    public static void main(String[] args) {
        Donkey donkey=new Donkey();
        donkey.deliver();

        Camel camel=new Camel();
        camel.deliver();
    }
}
