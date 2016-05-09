/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
/*
 *solution1 
 *easy to read
 */
 public class Solution {  
    public String intToRoman(int num) {  
        String[][] roman = {  
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},  
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},  
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},  
            {"", "M", "MM", "MMM"}  
        };  
          
        String ret = "";  
        int digit = 0;  
        while (num != 0) {  
            int remain = num % 10;  
            ret = roman[digit][remain] + ret;  
            digit++;  
            num /= 10;  
        }  
          
        return ret;  
    }  
}  

/*solution 2*/
public class Solution {
	public String intToRoman(int num) {
		if(num <= 0) {
			return "";
		}
	    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder res = new StringBuilder();
	    int digit=0;
	    while (num > 0) {
	        int times = num / nums[digit];
	        num -= nums[digit] * times;
	        for ( ; times > 0; times--) {
	            res.append(symbols[digit]);
	        }
	        digit++;
	    }
	    return res.toString();
	}
}