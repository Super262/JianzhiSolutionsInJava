package solutions;

public class Jzoffer461 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        return count(str, 0, str.length() - 1);
    }
    private int count(final String str, final int start, final int end){
        if(end - start == 0){
            return 1;
        }
        final int firstDigit = (str.charAt(start) - '0');
        if(end - start == 1){
            if(firstDigit > 0 && firstDigit * 10 + (str.charAt(end) - '0') < 26){
                return 2;
            } else{
                return 1;
            }
        }
        if(firstDigit > 0 && firstDigit * 10 + (str.charAt(start + 1) - '0') < 26){
            return count(str, start + 1, end) + count(str, start + 2, end);
        } else {
            return count(str, start + 1, end);
        }
    }
}
