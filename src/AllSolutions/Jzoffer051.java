package AllSolutions;

public class Jzoffer051 {
    public String replaceSpace(String s) {
        final int strLen = s.length();
        if(strLen == 0){
            return "";
        }

        StringBuilder result = new StringBuilder();
        int spacesCount = 0;
        for (int i = 0; i < strLen; ++i){
            final char ch = s.charAt(i);
            if (ch == ' '){
                ++spacesCount;
            }
            else{
                if(spacesCount != 0){

                    // Deal with previous spaces firstly.
                    while (spacesCount > 0){
                        result.append("%20");
                        --spacesCount;
                    }

                }
                result.append(ch);
            }
        }

        // If all characters in the tail are spaces, spacesCount will never be zero after the while loop!
        while (spacesCount > 0){
            result.append("%20");
            --spacesCount;
        }
        return result.toString();
    }
}
