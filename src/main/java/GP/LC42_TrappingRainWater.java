package GP;

public class LC42_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {7,2,3,4,5,6,7};
        int water = trap(height);
        System.out.println(water);
    }
    public static int trap(int[] height) {
        int prefix[] = new int[height.length];
        int suffix[] = new int[height.length];
        int water = 0;
        prefix[0]=height[0];
        suffix[height.length-1] = height[height.length-1];
        for(int i=1; i<height.length; i++) {
            prefix[i] = Math.max(prefix[i-1], height[i]);
            suffix[height.length -i-1] = Math.max(suffix[height.length-i],height[height.length-i-1]);
        }

        for (int i =0; i< height.length ; i++){
            water = water + Math.min(prefix[i], suffix[i]) - height[i];
        }
        return water;
    }
}
