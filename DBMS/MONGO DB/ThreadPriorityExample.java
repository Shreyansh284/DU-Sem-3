
//  class newthread extends Thread
//  {
//     public void run()
//     {
//         for(int i=0;i<=5;i++)
//         {
//             System.out.println(i);
//         }
//         System.out.println("child");
//     }
//  }
// public class t {
// public static void main(String[] args) {
//     newthread n=new newthread();
//     n.start();
//     try
//     {
//         for(int i=0;i<=5;i++)
//         {
//             System.out.println(i);
//             Thread.sleep(1000);
//         }
//         System.out.println("main");
//     }

//     catch(Exception e)
//     {
//         System.out.println(e);
//     }
// }
    
// }
class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name); // Set thread name
    }

    @Override
    public void run() {
        for (int i = 1; i <= 2  ; i++) {
            System.out.println(getName() + " is running with priority " + getPriority() + " (Iteration: " + i + ")");
        }
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        // Create threads
        PriorityThread t1 = new PriorityThread("Thread-1");
        PriorityThread t2 = new PriorityThread("Thread-2");
        PriorityThread t3 = new PriorityThread("Thread-3");

        // Set priorities
        t1.setPriority(Thread.MIN_PRIORITY); // Lowest priority
        t2.setPriority(Thread.NORM_PRIORITY); // Normal priority
        t3.setPriority(Thread.MAX_PRIORITY); // Highest priority

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}
