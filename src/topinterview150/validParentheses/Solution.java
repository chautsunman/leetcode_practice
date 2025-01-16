package topinterview150.validParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValid(String s) {
        final int sLen = s.length();
        Deque<Character> stack = new ArrayDeque();
        char currChar;
        char stackTopChar;
        for (int i = 0; i < sLen; i++) {
            currChar = s.charAt(i);
            if (stack.isEmpty()) {
                if (currChar == ')' || currChar == ']' || currChar == '}') {
                    return false;
                }
                stack.addFirst(currChar);
            } else {
                stackTopChar = stack.peekFirst();
                if (stackTopChar == '(') {
                    stackTopChar = ')';
                } else if (stackTopChar == '[') {
                    stackTopChar = ']';
                } else if (stackTopChar == '{') {
                    stackTopChar = '}';
                }
                if (stackTopChar == currChar) {
                    stack.removeFirst();
                } else {
                    if (currChar == ')' || currChar == ']' || currChar == '}') {
                        return false;
                    }
                    stack.addFirst(currChar);
                }
            }
        }
        return stack.isEmpty();
    }
}
