import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class SetupGame {
	private String playerName; 
	private int days;
	private Monster starter;
	private int difficulty;
	
	public SetupGame() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Write your player name: "); /*Must be length 3-15, no numbers or special characters*/
		String name = sc.next();
		playerName = name;
		
		System.out.println("Select the number of days "); /*I believe it has to be 10-15 days*/
		int numDay = sc.nextInt();
		days = numDay;
		
		System.out.print("Choose your starter Monster (1,2 or 3)"+"\n");
		RandomisingMonster randomMonster1 = new RandomisingMonster(1);
		Monster monster1 = randomMonster1.getMonster();
		System.out.println("MONSTER1 "+monster1.getName()+" STATS");
		System.out.println("Max Health: "+monster1.getHealthUpper()+" Current Health: "+monster1.getHealth());
		System.out.println("Attack1 Max Damage: "+monster1.getatt1Upper()+"/ Current Damage: "+monster1.getAttack(1)+" Accuracy "+monster1.getAttackOdds1()+"%");
		System.out.println("Attack2 Max Damage: "+monster1.getatt2Upper()+"/ Current Damage: "+monster1.getAttack(2)+" Accuracy "+monster1.getAttackOdds2()+"%");
		System.out.println("Attack3 Max Damage: "+monster1.getatt3Upper()+"/ Current Damage: "+monster1.getAttack(3)+" Accuracy "+monster1.getAttackOdds3()+"%"+"\n");
		
		RandomisingMonster randomMonster2 = new RandomisingMonster(1);
		Monster monster2 = randomMonster2.getMonster();
		System.out.println("MONSTER2 "+monster2.getName()+" STATS");
		System.out.println("Max Health: "+monster2.getHealthUpper()+" Current Health: "+monster2.getHealth());
		System.out.println("Attack1 Max Damage: "+monster2.getatt1Upper()+"/ Current Damage: "+monster2.getAttack(1)+" Accuracy "+monster2.getAttackOdds1()+"%");
		System.out.println("Attack2 Max Damage: "+monster2.getatt2Upper()+"/ Current Damage: "+monster2.getAttack(2)+" Accuracy "+monster2.getAttackOdds2()+"%");
		System.out.println("Attack3 Max Damage: "+monster2.getatt3Upper()+"/ Current Damage: "+monster2.getAttack(3)+" Accuracy "+monster2.getAttackOdds3()+"%"+"\n");
		
		RandomisingMonster randomMonster3 = new RandomisingMonster(1);
		Monster monster3 = randomMonster3.getMonster();
		System.out.println("MONSTER3 "+monster3.getName()+" STATS");
		System.out.println("Max Health: "+monster3.getHealthUpper()+" Current Health: "+monster3.getHealth());
		System.out.println("Attack1 Max Damage: "+monster3.getatt1Upper()+"/ Current Damage: "+monster3.getAttack(1)+" Accuracy "+monster3.getAttackOdds1()+"%");
		System.out.println("Attack2 Max Damage: "+monster3.getatt2Upper()+"/ Current Damage: "+monster3.getAttack(2)+" Accuracy "+monster3.getAttackOdds2()+"%");
		System.out.println("Attack3 Max Damage: "+monster3.getatt3Upper()+"/ Current Damage: "+monster3.getAttack(3)+" Accuracy "+monster3.getAttackOdds3()+"%"+"\n");	
		int chosenMonster = sc.nextInt();
		if(chosenMonster == 1) {
			setStarter(monster1);
		} else if (chosenMonster == 2) {
			setStarter(monster2);
		} else if (chosenMonster == 3) {
			setStarter(monster3);
		} else {
			
		}
		
		System.out.println("Select Difficult:");
		System.out.println("1: Easy, 2: Medium, 3: Hard");
		int diff = sc.nextInt();
		difficulty = diff;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getDays() {
		return days;
	}
	
	public Monster getStarter() {
		return starter;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setStarter(Monster mon) {
		this.starter = mon;
	}
	public static void main(String[] args) {
		SetupGame setup = new SetupGame();
	}
}
