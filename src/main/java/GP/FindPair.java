package GP;

import java.util.HashSet;
import java.util.Set;

public class FindPair {
    public static void main(String[] args) {
        int[] arr = {1, -2, 1, 0, 5};
        int target = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if(set.contains(target - arr[i])) {
                System.out.println("true");
                return;
            }
            else set.add(arr[i]);
        }
        System.out.println("false");
    }
}
