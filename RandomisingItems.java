import java.util.Random;

public class RandomisingItems {
	private GettingItems items; 
	private int plusPriceLower = 0;
	private int minusPriceUpper = 0;
	
	public RandomisingItems(int i) {
		Random x = new Random();
		int item = x.nextInt(1,4);	
		if(i == 1) {
			this.minusPriceUpper = 70;
			createsItems(item); 
		} else if (i == 2) {
			this.plusPriceLower = 20;
			this.minusPriceUpper = 30;
			createsItems(item); 
		} else {
			this.plusPriceLower = 50;
			createsItems(item);
		}
	}
	
	public void createsItems(int i) {
		GettingItems t = null; 
		if(i==1) {
			t = new HealthItem(30); 
		}
		else if (i==2) {
			t = new smallHealthItem(20);	
		}
		else {
			t = new faintHealItem(15);
		}
		this.items = randomizesStats(i, t.getLowerPrice(), t.getUpperPrice(), this.plusPriceLower, this.minusPriceUpper);
	}
		
	public GettingItems randomizesStats(int i, int lowerPrice, int upperPrice, int plusPriceLower, int minusPriceUpper) {
		Random x = new Random();
		int buyPrice = x.nextInt(lowerPrice + plusPriceLower, upperPrice - minusPriceUpper); 
		
		if(i==1) {
			GettingItems buy1 = new HealthItem(buyPrice);
			return buy1;
		} 
		else if (i==2) {
			GettingItems buy2 = new smallHealthItem(buyPrice);
			return buy2;
		}
		else {
			GettingItems buy3 = new faintHealItem(buyPrice);
			return buy3;
		}	
	}
	
	public GettingItems getItem() {
		return items; 
	}
	
}
