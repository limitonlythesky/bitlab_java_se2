package Multithreading;

public class Operation extends Thread{
    private String operationName;
    private int operationTime;

    public Operation(String operationName, int operationTime) {
        this.operationName = operationName;
        this.operationTime = operationTime;
    }

    @Override
    public void run() {
        try{
            System.out.println("Operation " + this.operationName + ": started");
            for(int i = 1; i <= this.operationTime; i++){
                System.out.println("Operation " + this.operationName + ": " + i + " second");
                Thread.sleep(1000);
            }
            System.out.println("Operation " + this.operationName + ": finished");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
