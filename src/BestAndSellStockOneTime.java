
public class BestAndSellStockOneTime {

	public static void main(String args[]) {
		int prices[] = { 3, 2, 6, 5, 0, 3 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int minimumPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {
			if (minimumPrice > prices[i]) {
				minimumPrice = prices[i];
			}
			else if (prices[i] - minimumPrice > maxProfit) {
				maxProfit = prices[i] - minimumPrice;
			}
		}
		return maxProfit;
	}
}
