package GP;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC22_GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        Stack<Object[]> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        stack.push(new Object[]{"",0,0});
        while(!stack.isEmpty()) {
            Object[] ob = stack.pop();
            String s = (String) ob[0];
            int open = (int) ob[1];
            int close = (int) ob[2];
            if(open==n && close==n) {
                result.add(s);
            }
            if(open < n) {
                stack.push(new Object[]{s+"(",open+1,close});
            }
            if(close < open) {
                stack.push(new Object[]{s+")", open, close+1});
            }
        }
        return result;
    }
}
