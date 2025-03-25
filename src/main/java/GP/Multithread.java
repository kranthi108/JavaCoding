package GP;

public class Multithread{
    public static void main(String[] args) {
        MultithreadingDemo demo = new MultithreadingDemo();
        demo.start();
        Thread one = new Thread(new Mtrunnable());
        Thread two = new Thread(new Mtrunnable());
        one.start();
        two.start();
    }
}
class Mtrunnable implements Runnable {
    public void run() {
        System.out.println("runnable");
    }
}
class MultithreadingDemo extends Thread{
    public void run() {
        System.out.println("run");
    }
}
