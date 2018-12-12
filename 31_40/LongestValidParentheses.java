import java.util.Stack;

/**
 * Using Stack:
 *
 * Instead of finding every possible string and checking its validity, we can make use of stack while scanning the given
 * string to check if the string scanned so far is valid, and also the length of the longest valid string. In order to
 * do so, we start by pushing -1−1 onto the stack.
 *
 * For every '(' encountered, we push its index onto the stack.
 *
 * For every ')' encountered, we pop the topmost element and subtract the current element's index from the top element
 * of the stack, which gives the length of the currently encountered valid string of parentheses. If while popping the
 * element, the stack becomes empty, we push the current element's index onto the stack. In this way, we keep on
 * calculating the lengths of the valid substrings, and return the length of the longest valid string at the end.
 */
public class LongestValidParentheses {
    public static void main(String[] args){
        String s = "())(())";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int longest = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else if(s.charAt(i) == ')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
            System.out.println(stack);
        }
        return longest;
    }
}
