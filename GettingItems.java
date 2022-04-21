import java.util.Random;

public class GettingItems {
	private String itemName; 
	private int health; 
	private boolean fainted; 
	private String itemDescription; 
	private int level; 
	private int sellPrice; 
	public int buyPriceHigh; 
	public int buyPriceLow; 
	
	GettingItems(String name, int healthBoost, boolean faintStatus, String description, int levelIncrease, int sell, int buyUp, int buyLow) {
		itemName = name; 
		health = healthBoost; 
		fainted = faintStatus; 
		itemDescription = description; 
		level = levelIncrease; 
		sellPrice = sell; 
		buyPriceHigh = buyUp; 
		buyPriceLow = buyLow; 
		
	}
	
	public int getBuyPrice() {
		Random random = new Random();
	    return random.nextInt(buyPriceHigh - buyPriceLow) + buyPriceLow; 
	}
	
	public int getSellPrice() {
		return sellPrice; 
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public int getHealing() {
		return health; 
	}
	
	public boolean getFainted() {
		return fainted; 
	}
	
	public String getItemDescription() {
		return itemDescription; 
	}
	
	public int getLevel() {
		return level; 
	}
	
	public String toString() {
		String itemName = "Item name = "+getItemName()+"\n"; 
		String description = getItemDescription(); 
		String buyPrice = "Item price = " + getBuyPrice()+"\n"; 
		String sellPrice = "Item selling price = "+ getSellPrice()+"\n"; 
		return itemName+description+buyPrice+sellPrice; 
	}

}