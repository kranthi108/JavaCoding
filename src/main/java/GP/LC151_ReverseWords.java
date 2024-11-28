package GP;

public class LC151_ReverseWords {
    public static void main(String[] args) {
        String string = "the sky is blue";
        String words[] = string.split(" ");
        int left = 0, right = words.length - 1;
        while (left < right) {
            // Swap the words
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            // Move towards the center
            left++;
            right--;
        }
        System.out.println(String.join(" ", words));
    }
}
