import java.util.Random;

public class Monster {
	private String name;
	private int currentHealth;
	private int maxHealth;
	private boolean faintStatus;
	private String description;
	
	private int attack1;
	private int attackOdds1;
	private int attack2;
	private int attackOdds2;
	private int attack3;
	private int attackOdds3;
	
	private int healthUpper;
	private int healthLower;
	private int attack1Upper;
	private int attack1Lower;
	private int attack2Upper;
	private int attack2Lower;
	private int attack3Upper;
	private int attack3Lower;
	
	private int healAmount;
	
	/**Monster class constructor.
	 * 
	 * Initializes its name, faintStatus, description, health, attack1, attack2, attack3, attack odds, upper and lower health range and upper and lower attack ranges
	*/
	public Monster(String name, boolean faintStatus, String description, int health, int attack1, int attack2, int attack3, int odds1, int odds2, int odds3, int health_upper, int health_lower, int att1_upper, int att1_lower, int att2_upper, int att2_lower, int att3_upper, int att3_lower, int healAmount) {
		this.name = name;
		this.currentHealth = health;
		this.maxHealth = health;
		this.faintStatus = faintStatus;
		this.description = description;
		
		this.attack1 = attack1;
		this.attack2 = attack2;
		this.attack3 = attack3;
		this.attackOdds1 = odds1;
		this.attackOdds2 = odds2;
		this.attackOdds3 = odds3;
		
		this.healthUpper = health_upper;
		this.healthLower = health_lower;
		this.attack1Upper = att1_upper;
		this.attack1Lower = att1_lower;
		this.attack2Upper = att2_upper;
		this.attack2Lower = att2_lower;
		this.attack3Upper = att3_upper;
		this.attack3Lower = att3_lower;
		
		this.healAmount = healAmount;
	}
	
	/**Sets the name of the Monster*/ 
	public void setName(String newName) {
		name = newName;
	}
	
	/**Returns the name of the Monster*/
	public String getName() {
		return name;
	}
	
	/**Adds the integer parameter to the Monster's max health
	 *
	 * If max health plus the parameter is greater than the health upper, max health set to health upper.
	*/
	public void updateMaxHealth(int add) {
		this.maxHealth += add;
		if(this.maxHealth > this.healthUpper) {
			this.maxHealth = this.healthUpper;
		}
	}
	
	/**Adds the integer parameter to the Monster's current health
	 *
	 * If current health plus the parameter is greater than the max health, current health set to max health.
	*/
	public void updateCurrentHealth(int add) {
		this.currentHealth += add;
		if(this.currentHealth <= 0) {
			this.currentHealth = 0;
		}
		if(this.currentHealth > this.maxHealth) {
			this.currentHealth = this.maxHealth;
		}
	} 
	
	/**Returns the health of the Monster*/
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	/**Returns the faint status of the Monster*/
	public boolean getfaintStatus() {
		return faintStatus;
	}
	
	/**Sets the faint status of the Monster to a boolean*/
	public void setfaintStatus(boolean bool) {
		faintStatus = bool;
	}
	
	/**Returns the Monster description*/
	public String getDescription() {
		return description;
	}
	
	/**Adds a given integer parameter amount to the heal amount
	 *
	 * If heal amount plus the added parameter is more than the health upper, heal amount is set to the health upper
	*/
	public void addHealAmount(int amount) {
		healAmount += amount;
		if(healAmount > healthUpper) {
			healAmount = healthUpper;
		}
	}
	
	/**Returns the heal amount of the Monster*/
	public int getHealAmount() {
		return this.healAmount;
	}
	
	
	/**Given an integer parameter for the amount to be added and another integer for the given attack move (1 - 3), updates the chosen attack move by the amount specified*/
	public void updateAttack(int add, int move) {
		if(move == 1) {
			this.attack1 += add;
			if(this.attack1 > this.attack1Upper) {
				this.attack1 = this.attack1Upper;
			}
		}
		if(move == 2) {
			this.attack2 += add;
			if(this.attack2 > this.attack2Upper) {
				this.attack2 = this.attack2Upper;
			}
		} 
		if(move == 3) {
			this.attack3 += add;
			if(this.attack3 > this.attack3Upper) {
				this.attack3 = this.attack3Upper;
			}
		}
	}
	
	/**Returns a boolean value to determine whether a Monster's attack is successful
	 * 
	 * Result is randomly generated due to the attack odds of a Monster's given attack.
	 * 
	 * The integer parameter is the chosen attack move of the Monster.
	*/
	public boolean attackHit(int i) {
		int odds = getOdds(i);
		Random x = new Random();
		int randomInt = x.nextInt(101);
		if(randomInt <= odds) {
			return true;
		} else {
			return false;
		}	
	}
	
	/**Given a integer parameter, returns the corresponding Monster attack move odds as an integer out of 100*/
	public int getOdds(int i) {
		if(i==1) {
			return this.attackOdds1;
		} 
		if(i==2) {
			return this.attackOdds2;
		}
		else {
			return this.attackOdds3;
		}
	}
	
	/**Given an integer parameter (1 - 3), returns the corresponding attack move of the Monster*/
	public int getAttack(int i) {
		if(i==1) {
			return this.attack1;
		} 
		if(i==2) {
			return this.attack2;
		}
		else {
			return this.attack3;
		}
	}
	
	/**Returns the upper health bound of Monster*/
	public int getHealthUpper() {
		return healthUpper;
	}
	
	/**Returns the lower health bound of Monster*/
	public int getHealthLower() {
		return healthLower;
	}
	
	/**Returns the upper attack 1 bound of the Monster*/
	public int getatt1Upper() {
		return attack1Upper;
	}
	
	/**Returns the lower attack 1 bound of the Monster*/
	public int getatt1Lower() {
		return attack1Lower;
	}
	
	/**Returns the upper attack 2 bound of Monster*/
	public int getatt2Upper() {
		return attack2Upper;
	}
	
	/**Returns the lower attack 2 bound of Monster*/
	public int getatt2Lower() {
		return attack2Lower;
	}
	
	/**Returns the upper attack 3 bound of Monster*/
	public int getatt3Upper() {
		return attack3Upper;
	}
	
	/**Returns the lower attack 3 bound of Monster*/
	public int getatt3Lower() {
		return attack3Lower;
	}
	
	/**Returns the odds of the Monsters attack 1*/
	public int getAttackOdds1() {
		return attackOdds1;
	}
	
	/**Returns the odds of the Monsters attack 2*/
	public int getAttackOdds2() {
		return attackOdds2;
	}
	
	/**Returns the odds of the Monsters attack 3*/
	public int getAttackOdds3() {
		return attackOdds3;
	}
	
	/**Levels up the Monster by increasing its max health, attack1 damage, attack2 damage, attack3 damage and heal amount*/
	public void levelUp() {
		System.out.println("Your Monster "+getName()+" level up!");
		Random ran1 = new Random();
		updateAttack(ran1.nextInt(1,3), 1);
		updateAttack(ran1.nextInt(1,3), 2);
		updateAttack(ran1.nextInt(1,3), 3);
		updateMaxHealth(ran1.nextInt(5,11));
		addHealAmount(ran1.nextInt(5,11));
	}
	
	/**Returns the Monster in a string representation*/
	public String toString() {
		String name = "Name: "+getName()+"\n";
		String health = "Health: "+getCurrentHealth()+"\n";
		String heal = "Heal Amount: "+getHealAmount()+"\n";
		String attack1 = "Attack1: "+getAttack(1)+" / Accuracy: "+getAttackOdds1()+"%"+"\n";
		String attack2 = "Attack1: "+getAttack(2)+" / Accuracy: "+getAttackOdds2()+"%"+"\n";
		String attack3 = "Attack1: "+getAttack(3)+" / Accuracy: "+getAttackOdds3()+"%"+"\n";
		return name+health+heal+attack1+attack2+attack3;
	}
}