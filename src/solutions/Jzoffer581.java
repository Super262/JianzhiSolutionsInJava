package solutions;

import java.util.LinkedList;

public class Jzoffer581 {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }
        int sLen = s.length();
        StringBuilder tempStr = new StringBuilder(sLen);
        LinkedList<String> stack = new LinkedList<>();
        for(int i = 0; i < sLen; ++i){
            if (s.charAt(i) == ' ') {
                if (tempStr.length() > 0) {
                    stack.addLast(tempStr.toString());
                    tempStr.setLength(0);
                }
            } else {
                tempStr.append(s.charAt(i));
            }
        }
        if (tempStr.length() > 0) {
            stack.addLast(tempStr.toString());
            tempStr.setLength(0);
        }
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
