package AllSolutions;

public class Jzoffer471 {
    public int maxValue(int[][] grid) {
        final int height = grid.length + 1;
        final int width = grid[0].length + 1;
        int[][] pathValue = new int[height][width];
        pathValue[0][0] = grid[0][0];
        for(int i = 1; i < height; ++i){
            for(int j = 1; j < width; ++j){
                pathValue[i][j] = Math.max(pathValue[i][j], Math.max(pathValue[i - 1][j], pathValue[i][j - 1]) + grid[i - 1][j - 1]);
            }
        }
        return pathValue[height - 1][width - 1];
    }
}
