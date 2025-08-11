//Whenever you want to create a thread u just want to extend it by Thread class and Runnable interface but one point is that the runnable interface does not have the methdos like setpriority,getpriority and also the start so we need to create the object of type Runnable and then we have to pass them to the Thread constructor:refer the line:31-42

//class multi implements Runnable{
//    public void run(){
//        for(int i=0;i<=5;i++){
//            System.out.println("hi");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}

//class example implements Runnable{
//    public void run(){
//        for(int i=0;i<=5;i++){
//            System.out.println("hello");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
package day1;


class Counter{
    int count;
    //this synchronized method allows only one thread to operate like increment at a time not both the threads
    public synchronized void increment(){
        count++;
    }
}

public class Multithreading {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        //introducing the anonymous inner class which we had earlier studied in the lambda expressions(functional interface)
           Runnable obj1 = ()-> {
                   for(int i=0;i<1000;i++){
                       c.increment();
//            System.out.println("hi");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
           };
           Runnable obj2 = ()->{
               for(int i=0;i<1000;i++){
                   c.increment();
//                   System.out.println("hello");
//                   try {
//                       Thread.sleep(10);
//                   } catch (InterruptedException e) {
//                       throw new RuntimeException(e);
//                   }
               }
           };
           //to get the thread priority:
//           System.out.println(obj1.getPriority());

//set priority for a thread:like max and min
//obj2.setPriority(Thread.MAX_PRIORITY);

        //we are creating threads in order to use the thread methods like start which is not supported by the Runnable interface
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
           t1.start();
           t2.start();
           //join methods allows  your thread t1 and t2 to join the main
           t1.join();
           t2.join();

           System.out.println(c.count);

    }
}

//we are using the Thread.sleep in order to make the thread await so that next thread can process we are just suggesting the scheduler by adding those the sleep produes an exception so it is surrounded with try-catch block