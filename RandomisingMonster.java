import java.util.Random;

public class RandomisingMonster {
	private Monster monster;
	private int plusAttackLower = 0;
	private int minusAttackUpper = 0;
	private int plusHealthLower = 0;
	private int minusHealthUpper = 0;
	private int plusPriceLower = 0;
	private int minusPriceUpper = 0;
	
	/**Parameter of an integer (1-3) representing the difficulty of the Monster being generated.
	 * 
	 * Represents the difficulty of the Monster generated by updating the upper and lower bounds of the health and attack moves that can be possibly generated.
	*/
	public RandomisingMonster(int i) {
		Random x = new Random();
		int var = x.nextInt(1,6);
		if(i == 1) {
			this.minusHealthUpper = 70;
			this.minusAttackUpper = 20;
			this.minusPriceUpper = 20; 
			createsMonster(var);
		} else if (i == 2) {
			this.plusHealthLower = 20;
			this.plusAttackLower = 10;
			this.plusPriceLower = 20;
			this.minusHealthUpper = 30;
			this.minusAttackUpper = 10;
			this.minusPriceUpper = 10; 
			createsMonster(var);
		} else {
			this.plusHealthLower = 50;
			this.plusAttackLower = 20;
			this.plusPriceLower = 20; 
			createsMonster(var);
		}
	}
	
	/**Parameter of an integer (1 - 5) which corresponds to a type of Monster.
	 *
	 * Creates a Monster.
	*/
	public void createsMonster(int i) {
		Monster t = null;
		if(i==1) {
			t = new Noah(100,20,30,50,30);
		} else if(i==2) {
			t = new Charlie(130,20,35,60,20);
		} else if (i==3){
			t = new Ben(100,5,55,155, 15);
		} else if (i==4) {
			t = new Daniel(80, 25, 35, 75, 10);
		} else if (i==5){
			t = new Hugo(200, 3, 6, 15, 20);
		}
		this.monster = randomizesStats(i, t.getHealthUpper(), t.getHealthLower(), t.getatt1Upper(), t.getatt1Lower(), t.getatt2Upper(), t.getatt2Lower(), t.getatt3Upper(), t.getatt3Lower(),t.getLowerPrice(), t.getUpperPrice(), this.plusAttackLower, this.minusAttackUpper, this.plusHealthLower, this.minusHealthUpper, this.plusPriceLower, this.minusPriceUpper); /*Not sure if this. is good code*/
	}
	
	/**Randomizes the health, attack1, attack2 and attack3 for a given type of Monster
	 *
	 * Selects the type of Monster by the first integer parameter (1 - 5)
	 * 
	 * Other parameters correspond to providing a range to where the health, attack1, attack2 and attack3 can be randomized to.
	 * 
	 * Returns the randomly generated Monster.
	*/
	public Monster randomizesStats(int i ,int healthUpper, int healthLower, int att1_upper, int att1_lower, int att2_upper, int att2_lower, int att3_upper, int att3_lower,int lowerPrice, int upperPrice, int plusAttackLower, int minusAttackUpper, int plusHealthLower, int minusHealthUpper, int plusPriceLower, int minusPriceUpper) {
		Random x = new Random();
		int health = x.nextInt(healthLower + plusHealthLower, healthUpper - minusHealthUpper);
		int att1 = x.nextInt(att1_lower + plusAttackLower, att1_upper - minusAttackUpper);
		int att2 = x.nextInt(att2_lower + plusAttackLower, att2_upper - minusAttackUpper);
		int att3 = x.nextInt(att3_lower + plusAttackLower, att3_upper - minusAttackUpper);
		int buyPrice = x.nextInt(lowerPrice + plusPriceLower, upperPrice - minusPriceUpper);
		Monster mon = null;
		if(i==1) {
			mon = new Noah(health, att1, att2, att3, buyPrice);
		} else if(i==2) {
			mon = new Charlie(health, att1, att2, att3, buyPrice);
		} else if(i==3) {
			mon = new Ben(health, att1, att2, att3, buyPrice);
		} else if(i==4) {
			mon = new Daniel(health, att1, att2, att3, buyPrice);
		} else if(i==5) {
			mon = new Hugo(health, att1, att2, att3, buyPrice);
		}
		return mon;
	}
	
	/**Returns the randomly generated Monster*/
	public Monster getMonster() {
		return monster;
	}
	
	public static void main(String[] args) {
		RandomisingMonster randomMonster = new RandomisingMonster(1);
		System.out.println(randomMonster.getMonster());
		System.out.println(randomMonster.getMonster().getCurrentHealth());
		System.out.println(randomMonster.getMonster().getAttack(1));
		System.out.println(randomMonster.getMonster().getAttack(2));
		System.out.println(randomMonster.getMonster().getAttack(3));
	}
}
