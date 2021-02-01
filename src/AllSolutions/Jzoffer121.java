package AllSolutions;

public class Jzoffer121 {
    public boolean exist(char[][] board,String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        final int height = board.length;
        final int width = board[0].length;
        final int wordLen = word.length();
        boolean[][] hasIncluded = new boolean[height][width];
        final char firstChar = word.charAt(0);
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (board[i][j] == firstChar) {
                    if (dfs(board,height,width,i,j,word,wordLen,0,hasIncluded)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,int height,int width,int x,int y,String word,int wordLen,int subWordStart,boolean[][] hasIncluded) {
        if (x >= 0 && y >= 0 && x < height && y < width && subWordStart < wordLen && !hasIncluded[x][y] && board[x][y] == word.charAt(subWordStart)) {

            hasIncluded[x][y] = true;

            if (subWordStart == wordLen - 1) {
                return true;
            } else {
                if (dfs(board,height,width,x,y - 1,word,wordLen,subWordStart + 1,hasIncluded) || dfs(board,height,width,x,y + 1,word,wordLen,subWordStart + 1,hasIncluded) || dfs(board,height,width,x - 1,y,word,wordLen,subWordStart + 1,hasIncluded) || dfs(board,height,width,x + 1,y,word,wordLen,subWordStart + 1,hasIncluded)) {
                    return true;
                } else {
                    hasIncluded[x][y] = false;
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
