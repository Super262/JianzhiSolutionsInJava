package solutions;

import java.util.HashMap;

public class Jzoffer481 {
    public int lengthOfLongestSubstring(final String s) {
        if(s == null){
            return 0;
        }
        final int sLen = s.length();
        if(sLen < 2){
            return sLen;
        }
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int startIndex = -1;
        int endIndex = 0;
        char tempCh;
        int result = 0;
        while(endIndex < sLen){
            tempCh = s.charAt(endIndex);
            if(charIndex.containsKey(tempCh)){
                startIndex = Math.max(charIndex.get(tempCh), startIndex);
            }
            result = Math.max(endIndex - startIndex, result);
            charIndex.put(tempCh, endIndex);
            ++endIndex;
        }
        return result;
    }
}
