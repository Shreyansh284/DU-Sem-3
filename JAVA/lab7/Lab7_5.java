interface Shape
{
     void getArea();
}

class Rectangle implements Shape
{
    double l,b;
    Rectangle(double l , double b)
    {
        this.l=l;
        this.b=b;
    }

    public void getArea()
    {
        System.out.println(this.l*this.b);
    }
}
class Triangle
{
    double h,b;
    Triangle(double h , double b)
    {
        this.h=h;
        this.b=b;
    }

    public void getArea()
    {
        System.out.println(this.h*this.b/2);
    }
}
class Circle
{    double r;
    Circle(double r)
    {
        this.r=r;    
    }

    public void getArea()
    {
        System.out.println(this.r);
    }
    
}

public class Lab7_5 {
public static void main(String[] args) {
    Circle circle= new Circle(7.1);
    Rectangle rectangle= new Rectangle(7.1,8);
    Triangle triangle= new Triangle(7.1,8);

    triangle.getArea();
    circle.getArea();
    rectangle.getArea();
}
    
}