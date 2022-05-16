import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
	private ArrayList<Monster> playerTeam = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
	
	private ArrayList<Monster> yourCopyTeam = new ArrayList<Monster>();
	private ArrayList<Monster> enemyCopyTeam = new ArrayList<Monster>();
	
	private boolean outcome;
	
	/**Battle class constructor
	 * 
	 * Initializes your team of Monsters ArrayList and the enemy team of Monsters ArrayList
	*/
	public Battle(ArrayList<Monster> playerTeam, ArrayList<Monster> enemyTeam) {
		this.playerTeam = playerTeam;
		this.enemyTeam = enemyTeam;
	}
	
	/**Parameters are a Monster in the player team ArrayList and a Monster in the enemy team ArrayList
	 *
	 * Allows an attack from the Monster in the player team towards the Monster in the enemy team.
	*/
	public void attack(Monster mon1, Monster mon2) {
		int a = selectAttack(mon1);	
		boolean hit = mon1.attackHit(a);
		if(hit == true) {
			mon2.updateCurrentHealth(-mon1.getAttack(a));
			System.out.println("Your attack landed");
			System.out.println("Current Health: Enemy "+mon2.getName()+" "+mon2.getCurrentHealth());
		} else {
			System.out.println("Your attack missed");
			System.out.println("Current Health: Enemy "+mon2.getName()+" "+mon2.getCurrentHealth());
		}
	}
	
	/**Parameters are a Monster in the enemy team ArrayList and a Monster in the player team ArrayList
	 *
	 * Allows an attack from the Monster in the enemy team towards the Monster in the player team.
	*/
	public void attackBot(Monster mon1, Monster mon2) {
		int a = selectMoveBot();	
		boolean hit = mon1.attackHit(a);
		if(hit == true) {
			mon2.updateCurrentHealth(- mon1.getAttack(a));
			System.out.println("Enemy attack landed");
			System.out.println("Current Health: "+mon2.getName()+" "+mon2.getCurrentHealth());
		} else {
			System.out.println("Enemy attack missed");
			System.out.println("Current Health: "+mon2.getName()+" "+mon2.getCurrentHealth());
		}
	}
	
	
	/**Parameter is a Monster in the player team ArrayList
	 *
	 * Allows the user to select a given attack move by inputting an integer.
	 * 
	 * Returns the integer selected by the user.
	*/
	public int selectAttack(Monster mon) {
		System.out.print("Attack 1: Damage "+mon.getAttack(1)+", Accuracy: "+mon.getOdds(1)+"%"+"\n");
		System.out.print("Attack 2: Damage "+mon.getAttack(2)+", Accuracy: "+mon.getOdds(2)+"%"+"\n");
		System.out.print("Attack 3: Damage "+mon.getAttack(3)+", Accuracy: "+mon.getOdds(3)+"%"+"\n");
		Scanner sc = new Scanner(System.in); 
		System.out.print("Select move by inputting 1, 2 or 3"+"\n");
		int a= sc.nextInt();
		return a;
	}
	
	/**Parameter of a Monster in the enemy team ArrayList.
	 *
	 * Returns a random integer (1 - 3) representing a given Monster's attack move.
	*/
	public int selectMoveBot() {
		Random x = new Random();
		int randomInt = x.nextInt(1,4);
		return randomInt;
	}
	
	/**Parameter of the players team ArrayList
	 *
	 * Asks the user for an integer (1 - given length of team ArrayList).
	 * 
	 * Returns a Monster from the player team ArrayList corresponding to the user input.
	*/
	public Monster selectMonster(ArrayList<Monster> playerTeam) {
		Scanner sc = new Scanner(System.in);
		Monster mon;
		System.out.println("Select a monster from: 1 - "+playerTeam.size());
		for(Monster mons : playerTeam) {
			System.out.println(mons);
		}
		int a = sc.nextInt();
		if(playerTeam.get(a-1).getfaintStatus() == true) {
			System.out.println("Cannot select. Monster fainted.");
			mon = selectMonster(playerTeam);
		}
		else {
			mon = playerTeam.get(a-1);
		}
		return mon;
	}
	
	/**Parameter of an integer representing a Monster from the enemy team ArrayList
	 *
	 * Returns a Monster from the enemy team ArrayList.
	*/ 
	public Monster selectBotMonster(int i) {
		Random x = new Random();
		Monster mon;
		int botNum = x.nextInt(1,i+1);
		if(enemyTeam.get(botNum - 1).getfaintStatus() == true) {
			mon = selectBotMonster(i);
		} else {
			mon = enemyTeam.get(botNum - 1);
		}
		return mon;
	}
	
	/**Creates a full battle between the player team and enemy team ArrayLists
	 *
	 * Returns a string displaying the winner of the battle.
	*/
	public String fullBattle() {
		Scanner sc = new Scanner(System.in);
		String result = "";
		boolean canAttack = true;
		
		Monster mon2 = selectBotMonster(enemyTeam.size());
		Monster mon1 = selectMonster(playerTeam);
		while(yourCopyTeam.size() != playerTeam.size() && enemyCopyTeam.size() != enemyTeam.size()) {
			System.out.println("Current Health: "+mon1.getName()+" "+mon1.getCurrentHealth());
			System.out.println("Current Health: Enemy "+mon2.getName()+" "+mon2.getCurrentHealth());
			
			if(canAttack == true) {
				this.attack(mon1, mon2);
			}
			if(mon2.getCurrentHealth() == 0) {
				System.out.println("Enemy "+mon2.getName()+" has fainted");
				mon2.setfaintStatus(true);
				enemyCopyTeam.add(mon2);
				if(enemyCopyTeam.size() == enemyTeam.size()) {
					outcome = true;
					result = "You won!"+"\n";
					return result;
				}
				mon2 = selectBotMonster(enemyTeam.size());
			} 
			
			
			this.attackBot(mon2,mon1);
			if(mon1.getCurrentHealth() == 0) {
				System.out.println("Your "+mon1.getName()+" has fainted");
				mon1.setfaintStatus(true);
				yourCopyTeam.add(mon1);
				if(yourCopyTeam.size() == playerTeam.size()) {
					outcome = false;
					result = "You lost!"+"\n";
					return result;
				}
				mon1 = selectMonster(playerTeam);
			} else {
				System.out.println("Stay (1) or Switch (any key)");
				int s = sc.nextInt();
				canAttack = true;
				if (s==1) {
					continue;
				} else {
					Monster mon1Copy = selectMonster(playerTeam);
					if (mon1Copy != mon1) {
						canAttack = false;
					}
				}
			} mon2 = selectBotMonster(enemyTeam.size());
		}
		return result;
	}	
	
	public boolean getOutcome() {
		return outcome;
	}
	
	public static void main(String[] args) {
		ArrayList<Monster> playerTeam = new ArrayList<Monster>();
		ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
		Monster noah1 = new Noah(100, 20, 30, 60, 20);
		Monster noah2 = new Noah(100, 20, 30, 60, 20);
		Monster charlie1 = new Charlie(90, 25, 40, 70, 20);
		Monster charlie2 = new Charlie(90, 25, 40, 70, 20);
		playerTeam.add(noah1);
		playerTeam.add(charlie1);
		enemyTeam.add(noah2);
		enemyTeam.add(charlie2);
		Battle bat = new Battle(playerTeam, enemyTeam);
		System.out.println(bat.fullBattle());
	}
}
