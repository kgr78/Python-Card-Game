import java.util.Random;

public class Monster {
	private String name;
	private int health;
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
	
	
	public Monster(String name, boolean faintStatus, String description, int health, int attack1, int attack2, int attack3, int odds1, int odds2, int odds3, int health_upper, int health_lower, int att1_upper, int att1_lower, int att2_upper, int att2_lower, int att3_upper, int att3_lower) {
		this.name = name;
		this.health = health;
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
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public boolean getfaintStatus() {
		return faintStatus;
	}
	
	public void setfaintStatus(boolean bool) {
		faintStatus = bool;
	}
	
	
	public String getDescription() {
		return description;
	}
	
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
	
	public void updateHealth(int add) {
		this.health = this.health + add;
		if(this.health <= 0) {
			this.health = 0;
		}
		if(this.health > this.healthUpper) {
			this.health = this.healthUpper;
		}
	}
	
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
	
	public int getHealthUpper() {
		return healthUpper;
	}
	
	public int getHealthLower() {
		return healthLower;
	}
	
	public int getatt1Upper() {
		return attack1Upper;
	}
	
	public int getatt1Lower() {
		return attack1Lower;
	}
	
	public int getatt2Upper() {
		return attack2Upper;
	}
	
	public int getatt2Lower() {
		return attack2Lower;
	}
	
	public int getatt3Upper() {
		return attack3Upper;
	}
	
	public int getatt3Lower() {
		return attack3Lower;
	}
	
	public int getAttackOdds1() {
		return attackOdds1;
	}
	
	public int getAttackOdds2() {
		return attackOdds2;
	}
	
	public int getAttackOdds3() {
		return attackOdds3;
	}
	
	public String toString() {
		String name = "Name: "+getName()+"\n";
		String health = "Health: "+getHealth()+"\n";
		String attack1 = "Attack1: "+getAttack(1)+" / Accuracy: "+getAttackOdds1()+"%"+"\n";
		String attack2 = "Attack1: "+getAttack(2)+" / Accuracy: "+getAttackOdds2()+"%"+"\n";
		String attack3 = "Attack1: "+getAttack(3)+" / Accuracy: "+getAttackOdds3()+"%"+"\n";
		return name+health+attack1+attack2+attack3;
	}
}