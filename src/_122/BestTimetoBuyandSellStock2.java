package _122;

public class BestTimetoBuyandSellStock2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(prices));
    }
}

/* My method (a bit dummy) */
class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;
        boolean hold  = false;
        for(int i = 0; i < prices.length; i++) {
            if(i == prices.length - 1) {
                if(hold) {
                    profit += prices[i] - buy;
                }
                break;
            }
            if(prices[i + 1] < prices[i] && hold) {
                profit += prices[i] - buy;
                hold = false;
                continue;
            } 
            if(prices[i + 1] > prices[i] && !hold) {
                buy = prices[i];
                hold = true;
            }
        }
        return profit;
    }
}

/* Solution */
// class Solution {
//     public int maxProfit(int[] prices) {
//         int profit = 0;

//         for(int i = 1; i < prices.length; i++) {
//             if(prices[i] > prices[i - 1]) {
//                 profit += prices[i] - prices[i - 1];
//             }
//         }
//         return profit;
//     }
// }

/* Solution (fastest) */
// class Solution {
//     public int maxProfit(int[] prices) {
//         int i = 0, buy, sell, profit = 0, N = prices.length - 1;
//         while (i < N) {
//             while (i < N && prices[i + 1] <= prices[i]) i++;
//             buy = prices[i];

//             while (i < N && prices[i + 1] > prices[i]) i++;
//             sell = prices[i];

//             profit += sell - buy;
//         }
//         return profit;
//     }
// }