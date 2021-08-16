package Multithreading;

public class ThreadMain {
    public static void main(String[] args) {

        ThreadGroup threadGroup = new ThreadGroup("first");
        MyThread myThread1 = new MyThread(threadGroup, "th1");
        MyThread myThread2 = new MyThread(threadGroup, "th2");
        MyThread myThread3 = new MyThread(threadGroup, "th3");

        myThread1.start();
        myThread2.start();
        myThread3.start();

        while(myThread1.isAlive() || myThread2.isAlive() || myThread3.isAlive()){

        }

        System.out.println("Main is finished");
    }
}
