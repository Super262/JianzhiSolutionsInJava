package solutions;

import java.util.LinkedList;

public class Jzoffer581 {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }

        int sLen = s.length();
        LinkedList<String> stack = new LinkedList<>();
        int wordStart = 0;
        int wordEnd = 0;
        while (wordEnd < sLen){
            if (s.charAt(wordEnd) == ' ') {
                if (wordEnd - wordStart > 0) {
                    stack.addLast(s.substring(wordStart, wordEnd));
                    wordStart = wordEnd;
                } else {
                    ++wordEnd;
                    ++wordStart;
                }

            } else {
                ++wordEnd;
            }
        }
        if (wordEnd - wordStart> 0) {
            stack.addLast(s.substring(wordStart, wordEnd));
        }

        StringBuilder tempStr = new StringBuilder(sLen);
        while(stack.size() > 1){
            tempStr.append(stack.removeLast());
            tempStr.append(' ');
        }
        if(!stack.isEmpty()){
            tempStr.append(stack.removeLast());
        }

        return tempStr.toString();
    }
}
