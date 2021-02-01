package AllSolutions;

public class Jzoffer671 {
    public int strToInt(String str) {
        final int strLen = str.length();
        int i = 0;
        long result = 0;
        boolean isPositive = true;

        while(i < strLen && str.charAt(i) == ' '){
            ++i;
        }

        if(i == strLen){
            return 0;
        }

        if(str.charAt(i) == '+'){
            ++i;
        } else if(str.charAt(i) == '-'){
            isPositive = false;
            ++i;
        } else if(str.charAt(i) > '9' && str.charAt(i) < '0'){
            return 0;
        }

        if(i == strLen){
            return 0;
        }

        final long upperBound = Integer.MAX_VALUE;
        final long bottomBound = upperBound + 1;
        while(i < strLen && str.charAt(i) <= '9' && str.charAt(i) >= '0'){
            result *= 10;
            result += str.charAt(i) - '0';
            if(result > bottomBound && !isPositive){
                return Integer.MIN_VALUE;
            } else {
                if(result > upperBound && isPositive){
                    return Integer.MAX_VALUE;
                }
            }
            ++i;
        }

        result = isPositive? result : -result;
        return (int) result;
    }
}
