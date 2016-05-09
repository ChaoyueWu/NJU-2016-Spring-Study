/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
     public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int pl=0;
        for(int i = 1; i < strs.length; i++) {
            pl = prefix.length();
            if(pl == 0){
                return "";
            }
            int j = 0;
            while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if( j == 0) {
                return "";
	}
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}