package GP;

// input - S1001, S1002, S0999, S1003, SRN99, SRN10, SRN15, SRN02, PHY01, PHY09
// output - PHY01, PHY09,S0999,S1001,S1002, S1003 , SRN02, SRN10, SRN15, SRN99,
//data with 3 different formats , need to sort with String part first and then numeric part


import java.util.Arrays;
import java.util.*;
import java.util.regex.*;
;

public class Oracle1 {
    public static void main(String[] args) {
        List<String> list  = Arrays.asList(
                "S1001", "S1002", "S0999",
                "S1003", "SRN99", "SRN10",
                "SRN15", "SRN02", "PHY01", "PHY09"
        );
        list.sort((a,b) -> {
            Part parta = splitParts(a);
            Part partb = splitParts(b);
            int intv = parta.prefix.compareTo(partb.prefix);
            if(intv != 0) return intv;
            intv = Integer.compare(parta.number, partb.number);
            if(intv !=0 ) return intv;
            return  parta.suffix.compareTo(partb.suffix);
        });
        System.out.println(list);
    }
    static Part splitParts(String s) {
        Matcher m = Pattern.compile("([A-Za-z]+)(\\d+)([A-Za-z]*)").matcher(s);
        if(m.matches()) {
            String prefix = m.group(1);
            int number = Integer.parseInt(m.group(2));
            String suffix = m.group(3);
            return  new Part(prefix, number, suffix);
        }
        return new Part(s, 0, "");
    }
}
class Part {
    String prefix;
    int number;
    String suffix;
    Part(String prefix, int number, String suffix) {
        this.prefix = prefix;
        this.number = number;
        this.suffix = suffix;
    }
}




















