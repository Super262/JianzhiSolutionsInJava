package solutions;

public class Jzoffer471 {
    public int maxValue(int[][] grid) {
        int[][] pathValue = new int[grid.length + 1][grid[0].length + 1];
        int comingMax;
        pathValue[0][0] = grid[0][0];
        for(int i = 1; i <= grid.length; ++i){
            for(int j = 1; j <= grid[0].length; ++j){
                comingMax = Math.max(pathValue[i - 1][j], pathValue[i][j - 1]) + grid[i - 1][j - 1];
                pathValue[i][j] = Math.max(pathValue[i][j], comingMax);
            }
        }
        return pathValue[grid.length][grid[0].length];
    }
}
