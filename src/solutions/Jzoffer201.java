package solutions;

public class Jzoffer201 {
    public boolean isNumber(String s) {
        if(s == null || s.isEmpty()){
            return false;
        }

        final int strLength = s.length();
        boolean isFloat = false;
        boolean hasExponent = false;
        boolean hasBase = false;

        int i = 0;

        // You should remember that the string may have many spaces.

        // Trim the string before testing.
        while (i < strLength && s.charAt(i) == ' '){
            ++i;
        }
        if(i >= strLength){
            return false;
        }

        // Test the sign of the base.
        char currentChar = s.charAt(i);
        if (currentChar == '+' || currentChar == '-' || currentChar == '.') {
            ++i;
            isFloat = (currentChar == '.');
        } else if ('0' > currentChar || currentChar > '9') {
            return false;
        }

        // Test the base.
        while (i < strLength){
            currentChar = s.charAt(i);
            if (currentChar == ' '){
                break;
            }else if (('0' <= currentChar && currentChar <= '9')) {
                hasBase = true;
                ++i;
            } else if (currentChar == '.') {
                if(!isFloat){
                    isFloat = true;
                    ++i;
                } else {
                    return false;
                }
            } else if (currentChar == 'E' || currentChar == 'e') {
                ++i;
                hasExponent = true;
                break;
            } else {
                return false;
            }
        }
        if (!hasBase) {
            return false;
        }

        //Test the exponent.
        if (hasExponent) {
            hasExponent = false;
            if(i >= strLength){
                return false;
            }
            currentChar = s.charAt(i);
            if (currentChar == '+' || currentChar == '-') {
                ++i;
            } else if ('0' > currentChar || currentChar > '9') {
                return false;
            }
            while (i < strLength){
                currentChar = s.charAt(i);
                if (('0' <= currentChar && currentChar <= '9')) {
                    ++i;
                    hasExponent = true;
                } else if (currentChar == ' ') {
                    break;
                }else {
                    return false;
                }
            }
            if(!hasExponent){
                return false;
            }
        }

        // Check if characters in the tail are all spaces.
        while(i < strLength){
            currentChar = s.charAt(i);
            if (currentChar != ' '){
                return false;
            }
            ++i;
        }
        return true;
    }
}
