

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
        System.out.println("========================");
    }

    private void completeTaskThrowRuntimeException() {
        try {
            //assuming it takes 20 secs to complete the task
            System.out.println("Doing work.........throw RuntimeExceptioin!");
            throw new RuntimeException("A runtime exception found");
        } finally {
            System.out.println("Finally");
        }
    }

    private void completeTask() {
        try {

            System.out.println("Doing work!");
        } finally {
            System.out.println("Finally");
        }
    }

    public static void main(String args[]){
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 1*1000);
        System.out.println("TimerTask started");
        //cancel after sometime
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}