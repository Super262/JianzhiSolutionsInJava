package HardProblems;

public class Jzoffer191 {
    public boolean isMatch(String s,String p) {
        if (s == null || p == null) {
            return false;
        }
        final int sLen = s.length();
        final int pLen = p.length();
        boolean[][] f = new boolean[sLen + 1][pLen + 1];
        f[0][0] = true;
        for (int i = 0; i <= sLen; ++i) {
            for (int j = 1; j <= pLen; ++j) {
                if (p.charAt(j - 1) == '*') {
                    if (j > 1) {
                        if (i > 0 && (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2))) {
                            f[i][j] = f[i][j - 2] || f[i - 1][j];
                        } else {
                            f[i][j] = f[i][j - 2];
                        }
                    } else {
                        f[i][j] = false;
                    }
                } else {
                    if (i > 0 && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1))) {
                        f[i][j] = f[i - 1][j - 1];
                    } else {
                        f[i][j] = false;
                    }
                }
            }
        }
        return f[sLen][pLen];
    }
}
