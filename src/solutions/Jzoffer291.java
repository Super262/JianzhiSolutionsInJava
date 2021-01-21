package solutions;

public class Jzoffer291 {
    public int[] spiralOrder(int[][] matrix) {
        int yTop = matrix.length - 1;
        if(yTop < 0){
            return new int[0];
        }
        int xTop = matrix[0].length - 1;
        if(xTop < 0){
            return new int[0];
        }
        int[] result = new int[(xTop + 1) * (yTop + 1)];
        int direction = 0, i = 0, j = 0, resultTop = -1, xBottom = 0, yBottom = 0;
        while(true){
            if (direction == 0){
                // From left to right.
                if(j > xTop){
                    break;
                }
                result[++resultTop] = matrix[i][j];
                if(j == xTop){
                    direction = 1;
                    ++i;
                    ++yBottom;
                } else {
                    ++j;
                }
            } else if (direction == 1){
                // From bottom to top;
                if(i > yTop){
                    break;
                }
                result[++resultTop] = matrix[i][j];
                if(i == yTop){
                    direction = 2;
                    --j;
                    --xTop;
                } else {
                    ++i;
                }
            } else if (direction == 2){
                // From right to left.
                if (j < xBottom){
                    break;
                }
                result[++resultTop] = matrix[i][j];
                if(j == xBottom){
                    direction = 3;
                    --i;
                    --yTop;
                } else {
                    --j;
                }
            } else {
                // From top to bottom.
                if (i < yBottom){
                    break;
                }
                result[++resultTop] = matrix[i][j];
                if(i == yBottom){
                    direction = 0;
                    ++j;
                    ++xBottom;
                } else {
                    --i;
                }
            }
        }
        return result;
    }
}
