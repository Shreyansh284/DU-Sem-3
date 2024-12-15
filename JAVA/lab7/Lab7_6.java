/**
 * InnerLab7_6
 */
 interface Playable {

    void play();
}

 class Football implements Playable
 {
    public void play()
    {
        System.out.println("Foootball Played");
    }
 }
 class Volleyball implements Playable
 {
    public void play()
    {
        System.out.println("Volleyball Played");
    }
 }
 class Basketball implements Playable
 {
    public void play()
    {
        System.out.println("Basketball Played");
    }
 }

public class Lab7_6 {
    
public static void main(String[] args) {
    Football football=new Football();
    Volleyball volleyball =new Volleyball();
    Basketball basketball=new Basketball();

    football.play();
    volleyball.play();
    basketball.play();
}
}
