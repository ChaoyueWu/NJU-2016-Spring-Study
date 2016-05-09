/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
        public boolean isValid(String s) {
    if (s == null || s.length() == 0) {
        return true;
    }
    char[] stack = new char[s.length()];
    int top = 0;
    for (int i = 0, j = s.length(); i < j; i++) {
        char c = s.charAt(i);
        if (c == '[' || c == '(' || c == '{') {
            stack[top++] = c;
        } else if (c == ']' || c == ')' || c == '}') {
            if (top == 0) {//stack is empty
                return false;
            }
            char pc = stack[--top];
            if (pc == '[' && c == ']' || pc == '(' && c == ')' || pc == '{' && c == '}') {
                continue;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    return top == 0;
}
}