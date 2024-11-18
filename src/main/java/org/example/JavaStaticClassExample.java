package org.example;

public class JavaStaticClassExample
{
    private static String s= "Javatpoint";
    //Static and nested class
    static class StaticNestedClass
    {
        //non-static method of the nested class
        public static void show()
        {
//prints the string defined in base class
            System.out.println(s);
        }
    }
    public static void main(String args[])
    {
        StaticNestedClass.show();
        JavaStaticClassExample.StaticNestedClass obj = new JavaStaticClassExample.StaticNestedClass();
//invoking the method of the nested class
        obj.show();
    }
}