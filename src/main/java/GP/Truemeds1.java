package GP;

//Input : hfgfhsbbasjahsaasdsdhsjddjsdjhsdccdsjhffhg
//Output : hfgfhsaaasjahsbbsdsdhsjccjsdjhsddddsjhffhg

import java.util.ArrayList;
import java.util.List;

//Id	Product       	Rack	Qty		Product Rack Qty

//        1	Product_1	a.0.1	10
//        2	Product_2	a.0.1	15
//        3	Product_3	a.0.2	10
//        4	Product_4	a.0.1	5
//        5	Product_4	a.0.2	10
//
//
//
//      Id	Product       	Rack	Batch	Qty	Product Batch Rack Qty
//
//        1	Product_1	a.0.1	P1B1	5
//        2	Product_1	a.0.1	P1B2	5
//        3	Product_2	a.0.1	P2B2	10
//        4	Product_3	a.0.2	P2B1	2
//        5	Product_3	a.0.2	P3B2	3
//        6	Product_3	a.0.2	P3B3	5
//        7	Product_4	a.0.1	P4B1	4
//        8	Product_4	a.0.2	P4B2	10

//Select pr.product, pr.rack
// from

public class Truemeds1 {
    public static void main(String[] args) {
        String input = "hdhdhdgghfhfhfhffhfhfhf88fhfhfdjd99bdbdj44ndndnd55fnfnf77jfjf";
        List<int[]> doubles = new ArrayList<>();
        int i =0;
        while( i < input.length() -1) {
            if(input.charAt(i) == input.charAt(i+1)) {
                doubles.add(new int[]{i, i+1});
                i = i+2;
            }
            else i++;
        }
        char[] chars = input.toCharArray();
        for(int j =0; j+1<doubles.size(); j +=2) {
            int[] first = doubles.get(j);
            int[] second = doubles.get(j+1);
            char temp1 = chars[first[0]];
            char temp2 = chars[first[1]];
            chars[first[0]] = chars[second[0]];
            chars[first[1]] = chars[second[1]];
            chars[second[0]] = temp1;
            chars[second[1]] = temp2;
        }
        System.out.println(new String(chars));
    }
}










