package solutions.DP;

public class Jzoffer191 {
    public boolean isMatch(final String s, final String p) {
        final int strLength = s.length();
        final int patternLength = p.length();

        boolean[][] f = new boolean[strLength + 1][patternLength + 1];
        f[0][0] = true;

        for (int i = 0; i <= strLength; ++i) {
            for (int j = 1; j <= patternLength; ++j) {
                if(p.charAt(j - 1) == '*') {
                    if(matches(s, p, i, j - 1)) {
                        f[i][j] = f[i - 1][j] || f[i][j - 2];
                    }
                    else {
                        f[i][j] = f[i][j - 2];
                    }
                }
                else {
                    if(matches(s, p, i, j)){
                        f[i][j] = f[i - 1][j - 1];
                    }
                    else{
                        f[i][j] = false;
                    }
                }
            }
        }
        return f[strLength][patternLength];
    }

    private boolean matches(final String s, final String p, int i, int j){
        if (i == 0){
            return j == 0;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
