package org.example;

public class Pattern_series {
    public static void main(String[] args) {
      /*
        *
        * *
        * * *
        * * * *
       */
        for (int i= 1; i<= 5;i++)
        {
            for(int j =1;j<=i;j++)
            {
                if(i==5||j==i||j==1)
                System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
        /*
         * * * * *
         * * * *
         * * *
         * *
         *
         */
        System.out.println("Reverse pyramid");
        for (int i= 1; i<= 5;i++)
        {
            int p=1;
            for(int j =1;j<=i;j++)
            {
                System.out.print(p++ +" ");
            }
            System.out.println();
        }
        for (int i= 1; i<= 5;i++)
        {
            for(int j =i;j<=5;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i= 1; i<= 5;i++)
        {
            int p=1;
            for(int j =i;j<=5;j++)
            {
                System.out.print(p++ +" ");
            }
            System.out.println();
        }
        System.out.println("left");
        for (int i= 5; i>= 1;i--)
        {
            //int p=1;
            for(int j =i;j>=1;j--)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i= 1; i<= 5;i++)
        {
            int p=5;
            for(int j =1;j<=i;j++)
            {
                System.out.print(p-- +" ");
            }
            System.out.println();
        }
        for (int i= 1; i<= 5;i++)
        {
            for(int j =i;j<=5;j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.printf("*");
            }
            System.out.println();
        }
        for (int i= 1; i<= 5;i++)
        {
            for(int j =1;j<=5;j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.printf("*");
            }

            System.out.println();
        }


    }
}
