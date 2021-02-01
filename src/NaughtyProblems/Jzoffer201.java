package NaughtyProblems;

public class Jzoffer201 {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        final int sLen = s.length();
        if (sLen == 0) {
            return false;
        }
        int i = 0;

        // Ignore spaces.
        while (i < sLen && s.charAt(i) == ' ') {
            ++i;
        }
        if (i >= sLen) {
            return false;
        }

        // For the property.
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            ++i;
        }
        if (i >= sLen) {
            return false;
        }

        // For the base.
        boolean hasBase = false;
        boolean hasPoint = false;
        boolean needExpo = false;
        while (i < sLen && s.charAt(i) != ' ') {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                ++i;
                hasBase = true;
            } else if (s.charAt(i) == '.') {
                if (hasPoint) {
                    return false;
                } else {
                    hasPoint = true;
                    ++i;
                }
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                ++i;
                needExpo = true;
                break;
            } else {
                return false;
            }
        }
        if (!hasBase) {
            return false;
        }

        // For the expo.
        if (needExpo) {
            if (i >= sLen) {
                return false;
            }

            // For the property.
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                ++i;
            }
            if (i >= sLen) {
                return false;
            }
            boolean hasExpo = false;
            while (i < sLen && s.charAt(i) != ' ') {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    ++i;
                    hasExpo = true;
                } else {
                    return false;
                }
            }
            if (!hasExpo) {
                return false;
            }
        }

        // Ignore spaces.
        while (i < sLen) {
            if (s.charAt(i) != ' ') {
                return false;
            } else {
                ++i;
            }
        }
        return true;
    }
}
