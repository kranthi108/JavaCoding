package GP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class LC3356_ZeroArrayTransformation2 {
    private int capacity = 5;
    private Queue<Integer> queue = new LinkedList<>();
    public void produce() throws InterruptedException{
        Semaphore semaphore = new Semaphore(4);
        semaphore.acquire();
        int value = 0;
        while (true) {
                synchronized (this) {
                    while(queue.size() == capacity) {
                        System.out.println("Buffer is full");
                        wait();
                    }
                    System.out.println("Producing value " + value);
                    queue.add(value);
                    value++;
                    notify();
                    Thread.sleep(1000);
                }
        }
    }
    public void comsume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while(queue.isEmpty()) {
                    System.out.println("Please wait buffre is empty");
                    wait();
                }
                int value = queue.poll();
                System.out.println("Comsuming value");
                notify();
                Thread.sleep(1000);
            }
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LC3356_ZeroArrayTransformation2 lc = new LC3356_ZeroArrayTransformation2();
        Thread producer = new Thread(() -> {
            try{
                lc.produce();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
           try {
               lc.comsume();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });
    }
}
