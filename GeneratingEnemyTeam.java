import java.util.ArrayList;
import java.util.Random;

import javax.security.auth.x500.X500Principal;

public class GeneratingEnemyTeam {
	private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
	/*(1) Easy Monster (2) Medium Monster (3) Hard Monster (0) No Monster*/
	private String[] tooEasy = {"100","110"};
	private String[] easy = {"120","111"};
	private String[] medium = {"220","300","211"};
	private String[] mediumHard = {"222","320","330","221"};
	private String[] hard = {"321","311","322"};
	private String[] godSquad = {"333","332"};
	
	
	public GeneratingEnemyTeam() {
	}
	
	/**Returns the ArrayList of the enemy team*/
	public ArrayList<Monster> getEnemyTeam() {
		return this.enemyTeam;
	}
	
	/**Adds monster to the enemy team ArrayList*/ 
	public void addToEnemyTeam(Monster mon) {
		enemyTeam.add(mon);
	}
	
	/**Given a number, returns the set of possible battles for a given difficulty*/
	public String[] getStringList(int i) {
		if (i == 1) {
			return tooEasy;
		} else if (i == 2) {
			return easy;
		} else if (i == 3) {
			return medium;
		} else if (i == 4) {
			return mediumHard;
		} else if (i == 5) {
			return hard;
		} else {
			return godSquad;
		}
	}
	
	/**Given a number (1 - 6), an enemy team of Monsters is randomly created.
	 * 
	 * Ranging from 1 which is creates an easier ArrayList of Monsters to 6 which is the most difficult.
	*/
	public void createEnemyTeam(int p) {
		Random x = new Random();
		String[] diffList = getStringList(p);
		int diffListLen = diffList.length;
		int layouts = x.nextInt(diffListLen);
		String layout = diffList[layouts];
		char i = layout.charAt(0);
		char j = layout.charAt(1);
		char k = layout.charAt(2);
		if(i != '0') {
			RandomisingMonster mon1 = new RandomisingMonster(Character.getNumericValue(i));
			addToEnemyTeam(mon1.getMonster());
		}
		if(j != '0') {
			RandomisingMonster mon2 = new RandomisingMonster(Character.getNumericValue(j));
			addToEnemyTeam(mon2.getMonster());
		}
		if(k != '0') {
			RandomisingMonster mon3 = new RandomisingMonster(Character.getNumericValue(k));
			addToEnemyTeam(mon3.getMonster());
		}
	}
	
	public static void main(String[] args) {
		GeneratingEnemyTeam g = new GeneratingEnemyTeam();
		g.createEnemyTeam(6);
		System.out.println(g.getEnemyTeam());
	}
}	
	