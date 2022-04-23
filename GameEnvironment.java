import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameEnvironment {
	private ArrayList<Monster> yourTeam = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeamOne = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeamTwo = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeamThree = new ArrayList<Monster>();
	
	private int daysRemaining;
	private int gold;
	private int day = 1;
	
	
	public GameEnvironment() {
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
		System.out.println("BATTLE 1: Enemy Team"+"\n"+getEnemyTeamOne());
		System.out.println("BATTLE 2: Enemy Team"+"\n"+getEnemyTeamTwo());
		System.out.println("BATTLE 3: Enemy Team"+"\n"+getEnemyTeamThree());
		System.out.println("Select 4 to skip to the next day");
		System.out.println("Select Battle: (1,2,3,4)");
		int chosenBattle = sc.nextInt();
		if (chosenBattle == 1) {
			Battle bat = new Battle(getYourTeam(), getEnemyTeamOne());
			bat.fullBattle();
		} else if (chosenBattle == 2) {
			Battle bat = new Battle(getYourTeam(), getEnemyTeamTwo());
			bat.fullBattle();
		} else if (chosenBattle == 3) {
			Battle bat = new Battle(getYourTeam(), getEnemyTeamThree());
			bat.fullBattle();
		} else {
			increaseDay();
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
		/*while (game.getDay() != maxDays) {
			game.createBattle();
		}*/
		game.createBattle();
	}
}
