package GP;

public class LC43 {
    public static void main(String[] args) {
        String num1 = "123", num2 = "234";
        String result = multiply(num1, num2);
        System.out.println(result);
    }
    public static String multiply(String num1, String num2) {
        int result = Integer.valueOf(num1) * Integer.valueOf(num2);
        return String.valueOf(result);
    }
}
