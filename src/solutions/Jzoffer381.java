package solutions;

import java.util.HashSet;
import java.util.LinkedList;

public class Jzoffer381 {
    public String[] permutation(String s) {
        LinkedList<String> result = new LinkedList<>();
        getResultFromSubStr(s.toCharArray(), 0, result);
        return result.toArray(new String[result.size()]);
    }

    private void getResultFromSubStr(char[] str, final int startIndex, LinkedList<String> result){
        if(startIndex == str.length - 1){
            result.add(String.valueOf(str));
            return;
        }
        char temp;
        HashSet<Character> set = new HashSet<>();
        for(int i = startIndex; i < str.length; ++i){
            if (!set.contains(str[i])){
                set.add(str[i]);

                // Swap.
                temp = str[i];
                str[i] = str[startIndex];
                str[startIndex] = temp;

                getResultFromSubStr(str, startIndex + 1, result);

                // Reset.
                temp = str[i];
                str[i] = str[startIndex];
                str[startIndex] = temp;
            }
        }

    }
}
