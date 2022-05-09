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
	
	GettingItems(String name, int healthBoost, boolean faintStatus, String description, int levelIncrease, int sell, int buyLow, int buyUp) {
		this.itemName = name; 
		this.health = healthBoost; 
		this.fainted = faintStatus; 
		this.itemDescription = description; 
		this.level = levelIncrease; 
		this.sellPrice = sell; 
		this.buyPriceHigh = buyUp; 
		this.buyPriceLow = buyLow; 
		
	}
	
	public int getLowerPrice() {
		return buyPriceLow; 
	}
	public int getUpperPrice() {
		return buyPriceHigh; 
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
		String sellPrice = "Item selling price = "+ getSellPrice()+"\n"; 
		return itemName+description+sellPrice; 
	}

}