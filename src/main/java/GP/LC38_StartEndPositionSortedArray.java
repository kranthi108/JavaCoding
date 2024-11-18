package GP;

public class LC38_StartEndPositionSortedArray {
    public static void main(String[] args) {
        int[] a = {1,3,3,4,5,6,6,7,7,7,7,8,8,8,8,9,9,9,9,9,9,9};
        int[] res = searchRange(a, 9);
        System.out.println(res[0]+ "  " + res[1]);
    }
    public static int[] searchRange(int[] arr, int target) {
        int low = 0, high = arr.length-1, firstPosition=-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(arr[mid]==target ) {
                if(mid>0  && arr[mid-1]==arr[mid])
                    high = mid-1;
                else {
                    firstPosition = mid;
                    break;
                }
            }
            else if(arr[mid]<target)
                low = mid+1;
            else
                high = mid-1;
            }
        low = 0;
        high = arr.length-1;
        int lastPosition = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(arr[mid]==target) {
                if(mid+1<arr.length && arr[mid] == arr[mid+1])
                    low = mid+1;
                else {
                    lastPosition = mid;
                    break;
                }
            }
            else if (arr[mid]<target)
                low = mid+1;
            else high= mid-1;
        }
        return new int[]{firstPosition,lastPosition};
    }
}
