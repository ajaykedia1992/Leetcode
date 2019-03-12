
public class BuyAndSellStockPrices {

	public static void main(String args[]) {
		int prices[] = {100, 180, 260, 310, 40, 535, 695};
		int fee = 0;
		System.out.println(buyAndSellStockPrices(prices, fee));
	}

	private static int buyAndSellStockPrices(int[] prices, int fee) {

		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int s0 = 0, s1 = Integer.MIN_VALUE;
		for(int p : prices) {
			int temp = s0;
			s0 = Math.max(s0, s1 + p);
			s1= Math.max(s1, temp - p -fee);
		}
		return s0;
	}
}
