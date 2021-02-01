package AllSolutions;

import java.util.LinkedList;

public class Jzoffer581 {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }

        int sLen = s.length();
        LinkedList<String> stack = new LinkedList<>();
        int wordEnd = sLen;
        int wordStart = wordEnd - 1;
        while (wordStart >= 0){
            if (s.charAt(wordStart) == ' ') {
                if(wordEnd - wordStart > 1){
                    stack.addLast(s.substring(wordStart + 1, wordEnd));
                }
                wordEnd = wordStart;
            }
            --wordStart;
        }
        if(wordEnd - wordStart > 1){
            stack.addLast(s.substring(wordStart + 1, wordEnd));
        }
        StringBuilder tempStr = new StringBuilder(sLen);
        if(!stack.isEmpty()){
            tempStr.append(stack.removeFirst());
        }
        while(!stack.isEmpty()){
            tempStr.append(' ');
            tempStr.append(stack.removeFirst());
        }

        return tempStr.toString();
    }
}
