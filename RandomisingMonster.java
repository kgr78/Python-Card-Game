import java.util.Random;

public class RandomisingMonster {
	private Monster monster;
	private int plusAttackLower = 0;
	private int minusAttackUpper = 0;
	private int plusHealthLower = 0;
	private int minusHealthUpper = 0;
	
	public RandomisingMonster(int i) {
		/*Random x = new Random();
		int mon = x.nextInt(1,7);*/	
		if(i == 1) {
			this.minusHealthUpper = 40;
			this.minusAttackUpper = 20;
			createsMonster(1);
		} else if (i == 2) {
			this.plusHealthLower = 20;
			this.plusAttackLower = 10;
			this.minusHealthUpper = 20;
			this.minusAttackUpper = 10;
			createsMonster(1);
		} else {
			this.plusHealthLower = 50;
			this.plusAttackLower = 20;
			createsMonster(1);
		}
	}
	
	public void createsMonster(int i) {
		if(i==1) {
			Monster t = new Noah(100,20,30,50);
			this.monster = randomizesStats(i, t.getHealthUpper(), t.getHealthLower(), t.getatt1Upper(), t.getatt1Lower(), t.getatt2Upper(), t.getatt2Lower(), t.getatt3Upper(), t.getatt3Lower(), this.plusAttackLower, this.minusAttackUpper, this.plusHealthLower, this.minusHealthUpper); /*Not sure if this. is good code*/
		}
	}
	
	public Monster randomizesStats(int i ,int healthUpper, int healthLower, int att1_upper, int att1_lower, int att2_upper, int att2_lower, int att3_upper, int att3_lower, int plusAttackLower, int minusAttackUpper, int plusHealthLower, int minusHealthUpper) {
		Random x = new Random();
		int health = x.nextInt(healthLower + plusHealthLower, healthUpper - minusHealthUpper);
		int att1 = x.nextInt(att1_lower + plusAttackLower, att1_upper - minusAttackUpper);
		int att2 = x.nextInt(att2_lower + plusAttackLower, att2_upper - minusAttackUpper);
		int att3 = x.nextInt(att3_lower + plusAttackLower, att3_upper - minusAttackUpper);
		
		if(i==1) {
			Monster noah = new Noah(health, att1, att2, att3);
			return noah;
		} else {
			Monster noah = new Noah(health, att1, att2, att3);
			return noah;
		}	
	}
	
	
	public Monster getMonster() {
		return monster;
	}
	
	public static void main(String[] args) {
		RandomisingMonster randomMonster = new RandomisingMonster(1);
		System.out.println(randomMonster.getMonster().getHealth());
		System.out.println(randomMonster.getMonster().getAttack(1));
		System.out.println(randomMonster.getMonster().getAttack(2));
		System.out.println(randomMonster.getMonster().getAttack(3));
	}
}
