
interface EventListener
{
    void  performEvent() ;
}
interface MouseListener extends EventListener
{
    void  mouseClicked();
    void  mousePressed();
    void  mouseReleased();
    void  mouseMoved();
    void  mouseDragged();
}
interface KeyListener extends EventListener
{
 void keyPressed();
 void keyReleased();
}
class EventDemo implements MouseListener , KeyListener
{
    public void  performEvent() 
    {
        System.out.println("Perform Event");
    }
    public void  mouseClicked()
    {
        System.out.println("mouseClicked");
    }
    public void  mousePressed()
    {
        System.out.println("mousePressed");
    }
    public  void  mouseReleased()
    {
        System.out.println("mouseReleased");
    }
    public void  mouseMoved()
    {
        System.out.println("mouseMoved");
    }
    public void  mouseDragged()
    {
        System.out.println(" mouseDragged");
    }

    public void keyPressed() {
        System.out.println("keyPressed");
    }
    public void keyReleased()
    {
        System.out.println("keyRelesed");
    }
}

public class Lab7_4 {
    public static void main(String[] args) {
        EventDemo eventDemo =new EventDemo();
        eventDemo.keyPressed();
        eventDemo.mousePressed();
        eventDemo.performEvent();
    }
}
