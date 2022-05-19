public class GettingItems {
	private String itemName; 
	private int health; 
	private boolean fainted; 
	private String itemDescription; 
	private int sellPrice; 
	private int buyPrice;
	private int upperPrice; 
	private int lowerPrice; 
	private int attackUpdate; 
	
	GettingItems(String name, int healthBoost, boolean faintStatus, String description, int sell, int buy, int lowPrice, int upPrice, int attackingUpdate) {
		this.itemName = name; 
		this.health = healthBoost; 
		this.fainted = faintStatus; 
		this.itemDescription = description;  
		this.sellPrice = sell; 
		this.buyPrice = buy; 
		this.upperPrice = upPrice; 
		this.lowerPrice = lowPrice; 
		this.attackUpdate = attackingUpdate; 
	}
	
	public int getSellPrice() {
		return sellPrice; 
	}
	
	public int getLowerPrice() {
		return lowerPrice; 
	}
	
	public int getUpperPrice() {
		return upperPrice;
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
	public int getBuyPrice() {
		return buyPrice; 
	}
	public int getAttackUpdate() {
		return attackUpdate; 
	}
	
	public String toString() {
		String itemName = "Item name = "+getItemName()+"\n"; 
		String description = getItemDescription()+"\n";  
		String buyPrice = "Buying price = "+getBuyPrice()+"\n"; 
		String sellPrice = "Item selling price = "+ getSellPrice()+"\n"; 
		return itemName+description+buyPrice+sellPrice; 
	}

}