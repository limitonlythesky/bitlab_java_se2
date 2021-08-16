package Multithreading;

public class MyThread extends Thread{

    public MyThread(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < 10; i++){
                System.out.println("Thread: " + getName());
                MyThread.sleep(500);
            }
            System.out.println("finished");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
