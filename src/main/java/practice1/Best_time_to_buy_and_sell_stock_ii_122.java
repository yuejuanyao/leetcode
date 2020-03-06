package practice1;

public class Best_time_to_buy_and_sell_stock_ii_122 {
	
    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        int vally = Integer.MAX_VALUE;
        int peak = Integer.MIN_VALUE;
        int i = 0;
        while(i < prices.length-1) {
        	while(i< prices.length-1 && prices[i]>=prices[i+1])
        		i++;
        	vally = prices[i];
        	while(i< prices.length-1 && prices[i]<=prices[i+1])
        		i++;
        	peak = prices[i];
        	maxprofit += peak - vally;
        }
        return maxprofit;
    }

    public static int maxProfit_1(int[] prices) {
    	int maxprofit = 0;
    	
    	for(int i=0; i<prices.length-1; i++) {
    		if(prices[i+1] > prices[i])
    			maxprofit += prices[i+1] - prices[i];
    	}
    	return maxprofit;
    }
	public static void main(String[] args) {
		//{1,2} 1
		//{7,1,5,3,6,4} 5
		//{7} 0
		//{7,6,4,3,1} 0
		int[] prices = {7,1,5,3,6,9};
		System.out.println(maxProfit_1(prices));
	}

}
