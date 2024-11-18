package org.example;

//        a b g d e
//        z n l a z
//        y o b o m
//        u p a l w

import java.util.List;

// String = "global"
public class Matrix {

    public static void main(String[] args) {
        char[][] matrix = {{'a','b','g','d','e'},
                {'z','n','l','a','z'},
                {'y','o','b','o','m'},
                {'u','p','a','l','w'}};
        String word = "global";
        if(searchString(matrix,word)) {
            System.out.println("yes");
        }
        else
            System.out.println("No");

    }
    static boolean searchString(char[][] matrix, String word) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == word.charAt(0) && isPresent(matrix, i,j,word)) {
                    return true;
                }
            }
        }
//        List<Integer>
        return false;
    }
    static boolean isPresent(char[][] matrix, int R, int C, String word) {
        int[] a = {-1,-1,-1,0,0,1,1,1};
        int[] b = {-1, 0,1,-1,1,-1,0,1};

        if(matrix[R][C] != word.charAt(0))  {
            return false;
        }
//        for(int direciton = 0; direciton < 8; direciton++) {
        int i;
            for ( i = 1; i < word.length(); i++){
                for(int direciton = 0; direciton < 8; direciton++) {
                    int tempR = R + a[direciton];
                    int tempC = C + b[direciton];
                    if (tempR < 0 || tempR >= R || tempC < 0 || tempC >= C) {
                        break;
                    }
                    if (matrix[tempC][tempR] != word.charAt(i)) {
                        break;
                    }
                }

             }
            if(i==word.length())
                return true;
            return false;
        }
//        return false;

}
