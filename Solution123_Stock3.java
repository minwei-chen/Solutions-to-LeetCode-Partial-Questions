
public class Solution123_Stock3 {

    
    private int[] prices;
    private int buyDay;
    
    private int maxProfitOfOneTrans(int start, int end) {
        int buyPrice = Integer.MAX_VALUE, maxBenefit = 0, day = start;
        for(int i = start; i<end; i++) {
        	if(prices[i]<=buyPrice) {
        		buyPrice = prices[i];
        		day = i;
        	}
            if((prices[i]-buyPrice)>=maxBenefit) {
            	maxBenefit = prices[i]-buyPrice;
            	buyDay = day;
            }
        }
        return maxBenefit;
    }
    
    public int maxProfit(int[] prices) {
        this.prices = prices;
        int startDaySec = 0, maxProfit = 0, curProfit;
        for(; startDaySec<prices.length; startDaySec++) {
            curProfit = 0;
            curProfit += maxProfitOfOneTrans(startDaySec, prices.length);
            startDaySec = buyDay;
            curProfit += maxProfitOfOneTrans(0, startDaySec);
            maxProfit = curProfit>maxProfit? curProfit: maxProfit;
        }
        return maxProfit;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {4,3,2,1,0,0,0,0,0,0,0,0,0,0,0};
		new Solution123_Stock3().maxProfit(arr);
	}

}
