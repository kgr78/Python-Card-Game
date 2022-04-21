import java.util.ArrayList;

public class GameEnvironment {
	private ArrayList<Monster> yourTeam = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
	
	private int daysRemaining;
	private int gold;
	
	
	public GameEnvironment() {
	}
	
	public ArrayList<Monster> getYourTeam() {
		return yourTeam;
	}
	public ArrayList<Monster> getEnemyTeam() {
		return enemyTeam;
	}
	public void addToTeam(Monster mon) {
		getYourTeam().add(mon);
	}
	public void addToEnemyTeam(Monster mon) {
		getEnemyTeam().add(mon);
	}
	public void resetEnemyTeam() {
		ArrayList<Monster> enemyTeam = getEnemyTeam();
		enemyTeam.clear();
	}
	
	public void createEnemyTeam(int i) {
		if(i > 0) {
			RandomisingMonster randomMonster = new RandomisingMonster(1);
			randomMonster.createsMonster(1);
			Monster mon = randomMonster.getMonster();
			addToEnemyTeam(mon);
			i = i - 1;
			createEnemyTeam(i);
		}
	}
	
	public void createBattle() {
		createEnemyTeam(2); 
		Battle bat = new Battle(getYourTeam(), getEnemyTeam());
		bat.fullBattle();
	}
	
	
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		SetupGame set = new SetupGame();
		String playerName = set.getPlayerName();
		int days = set.getDays();
		Monster starter = set.getStarter();
		game.addToTeam(starter);
		int difficulty = set.getDifficulty();
		game.createBattle();
	}
}
