package solutions;

public class Jzoffer582 {
    public String reverseLeftWords(String s, int n) {
        if(s == null || s.isEmpty() || s.length() < n){
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }
}
