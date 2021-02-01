package AllSolutions;

public class Jzoffer631 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int prevMin = prices[0];
        int maxValue = 0;

        for(int price : prices){
            prevMin = Math.min(price, prevMin);
            maxValue = Math.max(maxValue, price - prevMin);
        }

        return maxValue;
    }
}
