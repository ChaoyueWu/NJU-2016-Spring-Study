import java.util.*;

/**
 *
 * Specification in https://leetcode.com/problems/repeated-dna-sequences/
 *
 *
 */

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() <= 9){
            return new ArrayList<String>();
        }
        
        HashMap<Character, Integer> digitMapping = new HashMap<Character, Integer>();
        digitMapping.put('A', 0);
        digitMapping.put('C', 1);
        digitMapping.put('G', 2);
        digitMapping.put('T', 3);
        
        HashMap<Integer, Integer> countMapping = new HashMap<Integer, Integer>();
        
        int hash = 0;
        int curLen = 0;
        for (int strIdx = 0 ; strIdx < s.length() ; strIdx ++){
            curLen ++;
            
            hash = (hash << 2) + digitMapping.get(s.charAt(strIdx));
            if(curLen > 9) {
                hash = (hash & ((1 << 20) - 1));
                if (countMapping.containsKey(hash) && countMapping.get(hash) == 1){
                    countMapping.put(hash, countMapping.get(hash) + 1);
                    String repeatedStr = s.substring(strIdx - 9 , strIdx + 1);
                    if(!result.contains(repeatedStr)){
                    	 result.add(repeatedStr);
                    }
                   
                }
                else{
                    countMapping.put(hash, 1);
                }
            }
        }
        
        return result;
    }
}