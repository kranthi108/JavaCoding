package GP;

public class Testing {
    public static void main(String[] args) {
//        Super s = new Sub();
//        s.foo();
        System.out.println("dfasdf");

    }

    public static void main(char[] args) {
        System.out.println("Dfdf");
    }
}
class Super {
    void foo(){
        System.out.println("super");

    }
}
class Sub extends Super {
    void foo(){
        System.out.println("sub");
    }
}
