package AllSolutions;

public class Jzoffer041 {
    public boolean findNumberIn2DArray(int[][] matrix, final int target) {
        if(matrix == null){
            return false;
        }

        final int height = matrix.length;
        if(height == 0){
            return false;
        }

        final int width = matrix[0].length;
        if (width == 0){
            return false;
        }

        int i = 0, j = width - 1, num = 0;

        while (i < height && j >= 0){
            num = matrix[i][j];
            if (num == target) {
                return true;
            }
            else if (num > target){
                --j;
            }
            else {
                ++i;
            }
        }

        return false;
    }
}
