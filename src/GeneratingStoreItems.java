import java.util.ArrayList;
import java.util.Random;

public class GeneratingStoreItems {
	private ArrayList<GettingItems> storeItems = new ArrayList<GettingItems>();
	private String[] tooEasy = {"5","10"};
	private String[] easy = {"10","15"};
	private String[] medium = {"20","30"};
	private String[] mediumHard = {"40","50"};
	private String[] hard = {"70","80"};
	
	public ArrayList<GettingItems> getStoreItems(){
		return this.storeItems; 
	}
	
	public void addToStore(GettingItems item) {
		storeItems.add(item); 
	}
	
	public String[] getStringList(int i) {
		if (i == 1) {
			return tooEasy;
		} else if (i == 2) {
			return easy;
		} else if (i == 3) {
			return medium;
		} else if (i == 4) {
			return mediumHard;
		} else{
			return hard;
		}
	}
	
	public void createStoreItems(int p) {
		Random x = new Random();
		String[] diffList = getStringList(p);
		int diffListLen = diffList.length;
		int layouts = x.nextInt(diffListLen);
		String layout = diffList[layouts];
		char i = layout.charAt(0);
		char j = layout.charAt(1);
		char k = layout.charAt(2);
		if(i != '0') {
			RandomisingItems item1 = new RandomisingItems(Character.getNumericValue(i));
			addToStore(item1.getItem());
		}
		if(j != '0') {
			RandomisingItems item2 = new RandomisingItems(Character.getNumericValue(j));
			addToStore(item2.getItem());
		}
		if(k != '0') {
			RandomisingItems item3 = new RandomisingItems(Character.getNumericValue(k));
			addToStore(item3.getItem());
		}
	}
	
	public static void main(String[] args) {
		GeneratingStoreItems g = new GeneratingStoreItems();
		g.createStoreItems(6);
		System.out.println(g.getStoreItems());
	}
	
	

}
