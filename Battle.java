import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
	private ArrayList<Monster> yourTeam = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
	
	private ArrayList<Monster> yourCopyTeam = new ArrayList<Monster>();
	private ArrayList<Monster> enemyCopyTeam = new ArrayList<Monster>();
	
	public Battle(ArrayList<Monster> yourTeam, ArrayList<Monster> enemyTeam) {
		this.yourTeam = yourTeam;
		this.enemyTeam = enemyTeam;
	}
	
	public void attack(Monster mon1, Monster mon2) {
		int a = selectAttack(mon1);	
		boolean hit = mon1.attackHit(a);
		if(hit == true) {
			mon2.updateHealth(-mon1.getAttack(a));
			System.out.println("Your attack landed");
			System.out.println("Current Health: Enemy "+mon2.getName()+" "+mon2.getHealth());
		} else {
			System.out.println("Your attack missed");
			System.out.println("Current Health: Enemy "+mon2.getName()+" "+mon2.getHealth());
		}
	}
	
	public void attackBot(Monster mon1, Monster mon2) {
		int a = selectMoveBot(mon1);	
		boolean hit = mon1.attackHit(a);
		if(hit == true) {
			mon2.updateHealth(- mon1.getAttack(a));
			System.out.println("Enemy attack landed");
			System.out.println("Current Health: "+mon2.getName()+" "+mon2.getHealth());
		} else {
			System.out.println("Enemy attack missed");
			System.out.println("Current Health: "+mon2.getName()+" "+mon2.getHealth());
		}
	}
	
	
	public int selectAttack(Monster mon) {
		System.out.print("Attack 1: Damage "+mon.getAttack(1)+", Accuracy: "+mon.getOdds(1)+"%"+"\n");
		System.out.print("Attack 2: Damage "+mon.getAttack(2)+", Accuracy: "+mon.getOdds(2)+"%"+"\n");
		System.out.print("Attack 3: Damage "+mon.getAttack(3)+", Accuracy: "+mon.getOdds(3)+"%"+"\n");
		Scanner sc = new Scanner(System.in); 
		System.out.print("Select move by inputting 1, 2 or 3"+"\n");
		int a= sc.nextInt();
		return a;
	}
	
	public int selectMoveBot(Monster mon) {
		Random x = new Random();
		int randomInt = x.nextInt(1,4);
		return randomInt;
	}
	
	public Monster selectMonster(int yourNum, ArrayList<Monster> yourTeam) {
		Scanner sc = new Scanner(System.in);
		Monster mon;
		System.out.println("Select a monster from: 1 - "+yourNum);
		for(Monster mons : yourTeam) {
			System.out.println(mons);
		}
		int a = sc.nextInt();
		if(yourTeam.get(a-1).getfaintStatus() == true) {
			System.out.println("Cannot select. Monster fainted.");
			mon = selectMonster(yourNum, yourTeam);
		}
		else {
			mon = yourTeam.get(a-1);
		}
		return mon;
	}
	
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
	
	
	public String fullBattle() {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int yourNum = yourTeam.size();
		int enemyNum = enemyTeam.size();
		boolean canAttack = true;
		
		Monster mon2 = selectBotMonster(enemyNum);
		Monster mon1 = selectMonster(yourNum, yourTeam);
		while(yourCopyTeam.size() != yourNum && enemyCopyTeam.size() != enemyNum) {
			System.out.println("Current Health: "+mon1.getName()+" "+mon1.getHealth());
			System.out.println("Current Health: Enemy "+mon2.getName()+" "+mon2.getHealth());
			
			if(canAttack == true) {
				this.attack(mon1, mon2);
			}
			if(mon2.getHealth() == 0) {
				System.out.println("Enemy "+mon2.getName()+" has fainted");
				mon2.setfaintStatus(true);
				enemyCopyTeam.add(mon2);
				if(enemyCopyTeam.size() == enemyNum) {
					result = "You won!";
					return result;
				}
				mon2 = selectBotMonster(enemyNum);
			} 
			
			
			this.attackBot(mon2,mon1);
			if(mon1.getHealth() == 0) {
				System.out.println("Your "+mon1.getName()+" has fainted");
				mon1.setfaintStatus(true);
				yourCopyTeam.add(mon1);
				if(yourCopyTeam.size() == yourNum) {
					result = "You lost!";
					return result;
				}
				mon1 = selectMonster(yourNum, yourTeam);
			} else {
				System.out.println("Stay (1) or Switch (2)");
				int s = sc.nextInt();
				if (s==1) {
					canAttack = true;
					continue;
				} else {
					mon1 = selectMonster(yourNum, yourTeam);
					canAttack = false;
				}
			} mon2 = selectBotMonster(enemyNum);
		}
		return result;
	}	
	
	public static void main(String[] args) {
		ArrayList<Monster> yourTeam = new ArrayList<Monster>();
		ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
		Monster noah1 = new Noah(100, 20, 30, 60);
		Monster noah2 = new Noah(100, 20, 30, 60);
		Monster charlie1 = new Charlie(90, 25, 40, 70);
		Monster charlie2 = new Charlie(90, 25, 40, 70);
		yourTeam.add(noah1);
		yourTeam.add(charlie1);
		enemyTeam.add(noah2);
		enemyTeam.add(charlie2);
		Battle bat = new Battle(yourTeam, enemyTeam);
		System.out.println(bat.fullBattle());
	}
}
