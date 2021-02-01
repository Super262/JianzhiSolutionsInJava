package AllSolutions;

public class Jzoffer041 {
    public boolean findNumberIn2DArray(int[][] matrix,final int target) {
        if (matrix == null) {
            return false;
        }
        final int height = matrix.length;
        if (height == 0) {
            return false;
        }
        final int width = matrix[0].length;
        if (width == 0) {
            return false;
        }
        int y = height - 1;
        int x = 0;
        while (y >= 0 && y < height && x >= 0 && x < width) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] < target) {
                ++x;
            } else {
                --y;
            }
        }
        return false;
    }
}
