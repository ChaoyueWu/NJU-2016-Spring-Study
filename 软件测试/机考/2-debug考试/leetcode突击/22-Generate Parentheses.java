/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
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