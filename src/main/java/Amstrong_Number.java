 public class Amstrong_Number {
        public static void main(String[] args) {
            int number = 153;  // 1*1*1 + 5*5*5 + 3*3*3
            int result = 0;
            while(number!=0)
            {
                int r = number%10;
                result = result+(r*r*r);
                number = number/10;
            }
            System.out.println(result);

        }
    }


