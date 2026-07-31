public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(sol.maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
            if (prices[i] < minPrice) minPrice = prices[i];
        }
        return maxProfit;
    }
}

