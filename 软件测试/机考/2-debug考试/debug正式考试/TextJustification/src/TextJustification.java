import java.util.*;

/**
*
* Specification in https://leetcode.com/problems/text-justification/
*
*
*/

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words.length == 0){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        boolean lastLine = false;
        int curIdx = 0;
        while (!lastLine && curIdx < words.length){
            int curWidth = 0;
            int startIdx = curIdx;
            String newLine = "";
            while (curIdx < words.length && curWidth + words[curIdx].length() + curIdx - startIdx<= maxWidth){
                curWidth += words[curIdx ++].length();
            }
            if (curIdx == words.length){
                lastLine = true;
                for (int i = startIdx ; i < curIdx ; i++){
                    newLine += words[i];
                    if (i != curIdx - 1){
                        newLine += " ";
                    }
                    }
                int spaceCnt = maxWidth - newLine.length();
                for (int spaceIdx = 0 ; spaceIdx < spaceCnt ; spaceIdx ++){
                    newLine += " ";
                }
            }
            else{
                int spaceCnt = maxWidth - curWidth;
                for (int i = startIdx; i < curIdx ; i ++){
                    newLine += words[i];
                    if (i != curIdx - 1){
                        int curSpaceCnt = (int) Math.ceil(spaceCnt * 1.0 / (curIdx - i - 1));
                        for (int spaceIdx = 0 ; spaceIdx < curSpaceCnt ; spaceIdx ++){
                            newLine += " ";
                        }
                        spaceCnt -= curSpaceCnt;
                    }
                }
                for (int spaceIdx = 0 ; spaceIdx < spaceCnt; spaceIdx ++){
                    newLine += " ";
                }
            }
            result.add(newLine);
        }
        
        return result;
    }
}