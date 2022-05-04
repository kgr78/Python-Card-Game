import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameEnvironment {
	private ArrayList<Monster> yourTeam = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeamOne = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeamTwo = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeamThree = new ArrayList<Monster>();
	private ArrayList<Integer> validBattles = new ArrayList<Integer>();
	
	private int gold;
	private int day = 1;
	
	
	public GameEnvironment() {
	}
	public ArrayList<Integer> getValidBattles() {
		return validBattles;
	}
	public void resetValidBattles() {
		int i = 1;
		while(i < 4) {
			getValidBattles().add(i);
			i = i + 1;
		}
	}
	public int getDay() {
		return day;
	}
	public void increaseDay() {
		this.day += 1;
	}
	public ArrayList<Monster> getYourTeam() {
		return yourTeam;
	}
	public void addToTeam(Monster mon) {
		getYourTeam().add(mon);
	}
	public ArrayList<Monster> getEnemyTeamOne() {
		return enemyTeamOne;
	}
	public ArrayList<Monster> getEnemyTeamTwo() {
		return enemyTeamTwo;
	}
	public ArrayList<Monster> getEnemyTeamThree() {
		return enemyTeamThree;
	}
	public void setEnemyTeamOne(ArrayList<Monster> enemyTeam) {
		this.enemyTeamOne = enemyTeam;
	}
	public void setEnemyTeamTwo(ArrayList<Monster> enemyTeam) {
		this.enemyTeamTwo = enemyTeam;
	}
	public void setEnemyTeamThree(ArrayList<Monster> enemyTeam) {
		this.enemyTeamThree = enemyTeam;
	}
	public void resetEnemyTeams() {
		getEnemyTeamOne().clear();
		getEnemyTeamTwo().clear();
		getEnemyTeamThree().clear();
	}
	public void levelGeneration() {
		if(getDay() > 0 && getDay() < 3) {
			GeneratingEnemyTeam teamOne = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamTwo = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamThree = new GeneratingEnemyTeam();
			teamOne.createEnemyTeam(1);
			teamTwo.createEnemyTeam(1);
			teamThree.createEnemyTeam(1);
			setEnemyTeamOne(teamOne.getEnemyTeam());
			setEnemyTeamTwo(teamTwo.getEnemyTeam());
			setEnemyTeamThree(teamThree.getEnemyTeam());
		} else if (day > 2 && day < 6) {
			GeneratingEnemyTeam teamOne = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamTwo = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamThree = new GeneratingEnemyTeam();
			teamOne.createEnemyTeam(2);
			teamTwo.createEnemyTeam(2);
			teamThree.createEnemyTeam(2);
			setEnemyTeamOne(teamOne.getEnemyTeam());
			setEnemyTeamTwo(teamTwo.getEnemyTeam());
			setEnemyTeamThree(teamThree.getEnemyTeam());
		} else if (day > 5 && day < 9) {
			GeneratingEnemyTeam teamOne = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamTwo = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamThree = new GeneratingEnemyTeam();
			teamOne.createEnemyTeam(2);
			teamTwo.createEnemyTeam(3);
			teamThree.createEnemyTeam(4);
			setEnemyTeamOne(teamOne.getEnemyTeam());
			setEnemyTeamTwo(teamTwo.getEnemyTeam());
			setEnemyTeamThree(teamThree.getEnemyTeam());
		} else if (day > 8 && day < 12) {
			GeneratingEnemyTeam teamOne = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamTwo = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamThree = new GeneratingEnemyTeam();
			teamOne.createEnemyTeam(3);
			teamTwo.createEnemyTeam(4);
			teamThree.createEnemyTeam(5);
			setEnemyTeamOne(teamOne.getEnemyTeam());
			setEnemyTeamTwo(teamTwo.getEnemyTeam());
			setEnemyTeamThree(teamThree.getEnemyTeam());
		} else if (day > 11 && day < 14) {
			GeneratingEnemyTeam teamOne = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamTwo = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamThree = new GeneratingEnemyTeam();
			teamOne.createEnemyTeam(4);
			teamTwo.createEnemyTeam(4);
			teamThree.createEnemyTeam(5);
			setEnemyTeamOne(teamOne.getEnemyTeam());
			setEnemyTeamTwo(teamTwo.getEnemyTeam());
			setEnemyTeamThree(teamThree.getEnemyTeam());
		} else if (day > 13 && day < 16) {
			GeneratingEnemyTeam teamOne = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamTwo = new GeneratingEnemyTeam();
			GeneratingEnemyTeam teamThree = new GeneratingEnemyTeam();
			teamOne.createEnemyTeam(5);
			teamTwo.createEnemyTeam(5);
			teamThree.createEnemyTeam(6);
			setEnemyTeamOne(teamOne.getEnemyTeam());
			setEnemyTeamTwo(teamTwo.getEnemyTeam());
			setEnemyTeamThree(teamThree.getEnemyTeam());
		}
	}

	public void createBattle() {
		levelGeneration();
		Scanner sc = new Scanner(System.in);
		String bat1 = "";
		String bat2 = "";
		String bat3 = "";
		if(getValidBattles().contains(1) == true) {
			System.out.println("BATTLE 1: Enemy Team"+"\n"+getEnemyTeamOne());
			bat1 = "1, ";
		}
		if(getValidBattles().contains(2) == true) {
			System.out.println("BATTLE 2: Enemy Team"+"\n"+getEnemyTeamTwo());
			bat2 = "2, ";
		}
		if(getValidBattles().contains(3) == true) {
			System.out.println("BATTLE 3: Enemy Team"+"\n"+getEnemyTeamThree());
			bat3 = "3, ";
		}
		System.out.println("Select 4 to skip to the next day");
		System.out.println("Select Battle: ("+bat1+bat2+bat3+"or skip 4)");
		int chosenBattle = sc.nextInt();
		if (chosenBattle == 1) {
			getValidBattles().remove(chosenBattle);
			Battle bat = new Battle(getYourTeam(), getEnemyTeamOne());
			System.out.println(bat.fullBattle());
		} else if (chosenBattle == 2) {
			getValidBattles().remove(chosenBattle);
			Battle bat = new Battle(getYourTeam(), getEnemyTeamTwo());
			System.out.println(bat.fullBattle());
		} else if (chosenBattle == 3) {
			getValidBattles().remove(chosenBattle);
			Battle bat = new Battle(getYourTeam(), getEnemyTeamThree());
			System.out.println(bat.fullBattle());
		} else {
			increaseDay();
		}
	}
	
	public void RanEvent() {
		RandomEvent random = new RandomEvent(getYourTeam().size());
		Random x = new Random();
		boolean leaves = random.MonsterLeaves();
		boolean levels = random.MonsterLevels();
		boolean joins = random.MonsterJoins();
		
		if(leaves == true) {
			int chosenMonster = x.nextInt(0,getYourTeam().size());
			System.out.println("Your Monster "+getYourTeam().get(chosenMonster).getName()+" has gone wild and left your team.");
			getYourTeam().remove(chosenMonster);
		}
		if(levels == true) {
			 int chosenMonster = x.nextInt(0,getYourTeam().size());
			System.out.println("Your Monster "+getYourTeam().get(chosenMonster).getName()+" has levelled up!");
			 getYourTeam().get(chosenMonster).updateHealth(10);
			 getYourTeam().get(chosenMonster).updateAttack(5, 1);
			 getYourTeam().get(chosenMonster).updateAttack(5, 2);
			 getYourTeam().get(chosenMonster).updateAttack(5, 3);
		}
		if(joins == true) {
			RandomisingMonster randomMonster = new RandomisingMonster(1); 
			addToTeam(randomMonster.getMonster());
			System.out.println("A new Monster overnight has joined your team! Its name is "+ randomMonster.getMonster().getName());
		}
	}
	
	
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		SetupGame set = new SetupGame();
		String playerName = set.getPlayerName();
		int maxDays = set.getMaxDays();
		Monster starter = set.getStarter();
		game.addToTeam(starter);
		int difficulty = set.getDifficulty();
		while (game.getDay() < maxDays + 1) {
			System.out.println("Day: "+Integer.toString(game.getDay())+"/"+Integer.toString(maxDays)+"\n");
			int currentDay = game.getDay();
			game.resetValidBattles();
			game.RanEvent();
			while(currentDay == game.getDay() && game.getValidBattles().size() != 0) {
				System.out.println("Your Current Team");
				int var = 1;
				for(Monster mon : game.getYourTeam()) {
					System.out.println(Integer.toString(var)+":"+"\n"+mon);
					var += 1;	
				}
				game.createBattle();
			}
		}
	}
}
