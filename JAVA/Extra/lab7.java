abstract class vegetable
{
String vegetableColor;

abstract public String toString();
}
class potato extends vegetable
{
    potato()
    {
        
        super.vegetableColor="Light Brown";
    }

    public String toString()
    {
        return "potato"+vegetableColor;
    }
}

class brinjal extends vegetable
{
    brinjal()
    {
        super.vegetableColor="Light Purpule";
    } 

      public String toString()
    {
        return "brinjal"+vegetableColor;
    }
}

class tomato extends vegetable
{
     tomato()
    {
        super.vegetableColor="Red";
    }
    public String toString()
    {
        return "tomato"+vegetableColor;
    }
}

public class lab7 {
    
    public static void main(String[] args) {
    vegetable v1 = new potato();
      vegetable v2 = new tomato();
        vegetable v3 = new brinjal(); 

        System.out.println(v1+"" +""+ v2+"" + ""+v3);   
    }
    
}

