public class SynchronizationPractice {
    public synchronized void checkIfThreadExists() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " is entering");
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() +" is leaving ");
    }
}
