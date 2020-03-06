package practice1;

public class Best_time_to_buy_and_sell_stock_121 {
	
	//暴力法
    public static int maxProfit(int[] prices) {
    	int max = 0;
        if(prices == null || prices.length <=0)
        	return max;
        int days = prices.length;
        //需要注意 i和j的范围
        for(int i=0; i<days-1; i++) {
        	for(int j=i+1; j<days; j++) {
        		int temp = prices[j]-prices[i];
        		if(temp > max) {
        			max = temp;
        		}
        	}
        }
    	return max;
    }
    
	//使我们感兴趣的点是上图中的峰和谷。我们需要找到最小的谷之后的最大的峰。
    //我们可以维持两个变量——minprice 和 maxprofit，它们分别对应迄今为止所得到的最小的谷值和最大的利润（卖出价格与最低价格之间的最大差值）
    public static int maxProfit_1(int[] prices) {
    	int max = 0;
        if(prices == null || prices.length <=0)
        	return max;
        int days = prices.length;
        int low_point = Integer.MAX_VALUE;
        //需要注意 i和j的范围
        for(int i=0; i<days; i++) {
        	if(prices[i] < low_point) {
        		low_point = prices[i];
        	}else if (max < prices[i]-low_point) {
				max = prices[i]-low_point;
			}
        }
        
    	return max;
    }

	public static void main(String[] args) {
		//{1,2} 1
		//{7,1,5,3,6,4} 5
		//{7} 0
		//{7,6,4,3,1} 0
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit_1(prices));
	}

}
