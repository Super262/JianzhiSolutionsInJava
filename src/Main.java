import solutions.Jzoffer101;
import solutions.Jzoffer121;

public class Main {
    public static void main(String[] args){
        Jzoffer121 jzoffer = new Jzoffer121();
        String word = "aaa";
        char[][] board = {{'a','a'}};
        System.out.println(jzoffer.exist(board, word));
    }
}
