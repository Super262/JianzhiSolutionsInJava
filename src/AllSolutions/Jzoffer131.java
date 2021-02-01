package AllSolutions;

public class Jzoffer131 {
    public int movingCount(int m,int n,int k) {
        boolean[][] visited = new boolean[m][n];
        return getCountByBFS(m,n,0,0,k,visited);
    }

    private int getCountByBFS(int height,int width,int startX,int startY,int upperBound,boolean[][] visited) {
        if (startY > height - 1 || startX > width - 1 || visited[startY][startX]) {
            return 0;
        }
        int result = 0, rightCount = 0, aboveCount = 0;
        if (getDigitsSum(startX) + getDigitsSum(startY) <= upperBound) {
            rightCount = getCountByBFS(height,width,startX + 1,startY,upperBound,visited);
            aboveCount = getCountByBFS(height,width,startX,startY + 1,upperBound,visited);
            result += (rightCount + aboveCount + 1);
            visited[startY][startX] = true;
        }
        return result;
    }

    private int getDigitsSum(final int num) {
        int hundreds = num / 100;
        int tens = (num - hundreds * 100) / 10;
        int ones = (num - hundreds * 100 - 10 * tens);
        return (ones + tens + hundreds);
    }
}
