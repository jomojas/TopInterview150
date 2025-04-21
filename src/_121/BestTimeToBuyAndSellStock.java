package _121;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Max Profit: " + maxProfit);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        /* My method (Time Limit Exceeded) */
        // int maxProfit = 0;
        // for(int i = 0; i != prices.length - 1; i++) {
        //     for(int j = i + 1; j != prices.length; j++) {
        //         maxProfit = (prices[j] - prices[i] > maxProfit) ? prices[j] - prices[i] : maxProfit;
        //     }
        // }
        // return maxProfit;

        /* Solution */
        int buy = prices[0];   
        int profit = 0;
        for (int i = 1; i != prices.length; i++) {
            // buy = (prices[i] < buy) ? prices[i] : buy;
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }    
        return profit;    
    }
}