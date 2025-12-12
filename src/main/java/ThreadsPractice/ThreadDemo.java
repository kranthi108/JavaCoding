package ThreadsPractice;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread Running " + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("runnable Thread running " + Thread.currentThread().getName());
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();
        thread1.setUncaughtExceptionHandler((t,e) -> {
            System.out.println("Thread Exception " + t.getName());
        });
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        Thread thread2 = new Thread(() -> {
            System.out.println("Lambda Thread " + Thread.currentThread().getName());
        });
        thread2.start();
    }
}
