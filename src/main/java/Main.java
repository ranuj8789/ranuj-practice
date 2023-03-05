import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public volatile boolean checkStock=false;

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Runnable checkVolume = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("i am testing the volume");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread is " + Thread.currentThread().getName());
            }
        };
        Runnable checkVolatility = new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(10000);
                    System.out.println("i am checking volatility");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread is " + Thread.currentThread().getName());
            }
        };
        Runnable checkLoss= new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("i am checking loss" );
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(checkVolatility);
        executorService.submit(checkVolume);
        executorService.submit(checkLoss);
        Callable<String> checkStock= new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(100);
                System.out.println("stock found is" + "Ranuj Mahajan" + Thread.currentThread().getName());
                return "ranuj";
            }
        };
        executorService.submit(checkStock);

    }
}
