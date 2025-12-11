package GP;

public class LC34_FirstandLast {
    public static void main(String[] args) {
        int[] input = {5,7,7,8,8,10};
        int target = 7;
        int start = 0;
        int end = input.length-1;
//        int mid = (start+end)/2;
        int first = -1, last = -1;
        while(start<=end) {
            int mid = start + (end - start)/2;
            if(input[mid] == target) {
                if(mid > 0 && input[mid-1] == input[mid]) {
                    end = mid-1;
                }
                else {
                    first = mid;
                    break;
                }
            }
            else if(input[mid] < target) {
                start = mid+1;
            }
            else {
                end = mid -1;
            }
        }
        start =0; end = input.length-1;

        while(start<=end) {
            int mid = start + (end - start)/2;
            if(input[mid] == target) {
                if(mid < input.length-1 && input[mid] == input[mid+1]) {
                    start = mid+1;
                }
                else {
                    last = mid;
                    break;
                }
            }
            else if(input[mid] < target)
                start = mid+1;
            else end = mid -1;
        }
    }
}
