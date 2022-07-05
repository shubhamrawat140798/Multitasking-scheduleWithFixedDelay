/*Schedule at Fixed Rate*/
import java.util.concurrent.*;
class CountDownClock extends Thread {
    private String clockName;
 
    public CountDownClock(String clockName) {
        this.clockName = clockName;
    }
 
    public void run() {
        String threadName = Thread.currentThread().getName();
 
        for (int i = 5; i >= 0; i--) {
 
            System.out.printf("%s -> %s: %d\n", threadName, clockName, i);
 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
  class ConcurrentScheduledTasksExample {
 
    public static void main(String[] args) {
 
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
 
        CountDownClock clock1 = new CountDownClock("C1");
        CountDownClock clock2 = new CountDownClock("C2");
        CountDownClock clock3 = new CountDownClock("C3");
 
        scheduler.scheduleWithFixedDelay(clock1, 3, 10, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(clock2, 3, 15, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(clock3, 3, 20, TimeUnit.SECONDS);
 
    }
}
