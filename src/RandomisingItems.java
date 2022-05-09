import java.util.Random;

public class RandomisingItems {
	private GettingItems items; 
	private int plusPriceLower = 0;
	private int minusPriceUpper = 0;
	
	public RandomisingItems(int i) {
		Random x = new Random();
		int item = x.nextInt(1,1);	
		if(i == 1) {
			this.minusPriceUpper = 70;
		} else if (i == 2) {
			this.plusPriceLower = 20;
			this.minusPriceUpper = 30;
		} else {
			this.plusPriceLower = 50;
		}
	}
	
	public void createsItems(int i) {
		if(i==1) {
			GettingItems t = new HealthItem(10);
			this.items = randomizesStats(i, t.getLowerPrice(), t.getUpperPrice(), this.plusPriceLower, this.minusPriceUpper); 
		}
	}
		
	public GettingItems randomizesStats(int i, int lowerPrice, int upperPrice, int plusPriceLower, int minusPriceUpper) {
		Random x = new Random();
		int buyPrice = x.nextInt(lowerPrice + plusPriceLower, upperPrice - minusPriceUpper); 
		
		if(i==1) {
			GettingItems buy = new HealthItem(buyPrice);
			return buy;
		} else {
			GettingItems buy = new HealthItem(buyPrice);
			return buy;
		}	
	}
	
	public GettingItems getItem() {
		return items; 
	}
	
}
