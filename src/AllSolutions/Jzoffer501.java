package AllSolutions;

import java.util.HashMap;
import java.util.Map;

public class Jzoffer501 {
    public char firstUniqChar(String s) {
        if (s == null) {
            return ' ';
        }
        int sLen = s.length();
        if (sLen == 1) {
            return s.charAt(0);
        }
        HashMap<Character, Integer> charToIndex = new HashMap<>(sLen);
        char tempCh;
        for (int i = 0; i < sLen; ++i) {
            tempCh = s.charAt(i);
            if (charToIndex.containsKey(tempCh)) {
                charToIndex.put(tempCh,sLen);
            } else {
                charToIndex.put(tempCh,i);
            }
        }
        int tempIndex = sLen;
        for (Map.Entry<Character, Integer> entry : charToIndex.entrySet()) {
            tempIndex = Math.min(entry.getValue(),tempIndex);
        }
        return (tempIndex == sLen ? ' ' : s.charAt(tempIndex));
    }
}
