/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
/*
【解答】有几种方法可以解这道题，我觉得最容易理解的方式是这样，以自然的方式，从左到右写出这一堆括号来，每次下笔都有两种选择，要么写左括号，要么写右括号，具体说，每一次下笔都必须满足这样的条件：

写过的左括号次数必须小于n，那就可以写左括号；
写过的右括号次数必须小于n，并且也小于左括号次数，那就可以写右括号。
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        append(n, 0, 0, "", list);
        return list;
    }
     
    private void append(int n, int left, int right, String s, List<String> list) {
        if (left==n && right==n) {
            list.add(s);
            return;
        }
         
        if (left<n) {
            append(n, left+1, right, s+'(', list);
        }
         
        if (right<n && left>right) {
            append(n, left, right+1, s+')', list);
        }
    }
}