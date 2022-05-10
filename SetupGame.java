import java.util.Scanner;

public class SetupGame {
	private String playerName; 
	private int maxDays;
	private Monster starter;
	private int difficulty;
	
	/**Setup class Constructor
	 *
	 * Initializes the player name, maximum number of days, player's starter Monster and difficult all chosen by the player.
	*/
	public SetupGame() {
		setPlayerName();
		setMaxDays();
		setStarter();
		renameStarter();
		setDifficulty();
	}
	
	/**Sets the player's name as a string
	 *
	 * Name must be between 3 - 15 characters and denies any use of special character and numbers
	*/
	public void setPlayerName() {
		boolean validName = true;
		Scanner sc = new Scanner(System.in); 
		System.out.println("Write your player name: "); /*Must be length 3-15, no numbers or special characters*/
		String name = sc.next();
		if(name.matches("[a-zA-Z]+") == false) {
			validName = false;
			System.out.println("No special characters or numbers must be used in the player name");
		}
		if (name.length() < 3 || name.length() > 15) {
			validName = false;
			System.out.println("Name must be of length 3 - 15 inclusive");
		}
		if (validName == true) {
			playerName = name;
		} else {
			setPlayerName();
		}
	}
	
	/**Returns the player's name as a string*/
	public String getPlayerName() {
		return playerName;
	}
	
	/**Sets the maximum number of days between 10 and 15*/
	public void setMaxDays() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Select the number of days (10 - 15)"); /*I believe it has to be 10-15 days*/
		int max = sc.nextInt();
		while (max < 10 || max > 15) {
			System.out.println("Number of days must be between 10 - 15 inclusive");
			System.out.println("Select the number of days "); /*I believe it has to be 10-15 days*/
			max = sc.nextInt();
		}
		maxDays = max;
	}
	
	/**Returns the maximum number of days as a integer*/
	public int getMaxDays() {
		return maxDays;
	}
	
	/**Sets the player's starter Monster*/
	public void setStarter() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Choose your starter Monster (1,2 or 3)"+"\n");
		RandomisingMonster randomMonster1 = new RandomisingMonster(1);
		Monster monster1 = randomMonster1.getMonster();
		System.out.println("MONSTER1 "+monster1.getName()+" STATS");
		System.out.println("Max Health: "+monster1.getHealthUpper()+" Current Health: "+monster1.getCurrentHealth());
		System.out.println("Attack1 Max Damage: "+monster1.getatt1Upper()+"/ Current Damage: "+monster1.getAttack(1)+" Accuracy "+monster1.getAttackOdds1()+"%");
		System.out.println("Attack2 Max Damage: "+monster1.getatt2Upper()+"/ Current Damage: "+monster1.getAttack(2)+" Accuracy "+monster1.getAttackOdds2()+"%");
		System.out.println("Attack3 Max Damage: "+monster1.getatt3Upper()+"/ Current Damage: "+monster1.getAttack(3)+" Accuracy "+monster1.getAttackOdds3()+"%"+"\n");
		
		RandomisingMonster randomMonster2 = new RandomisingMonster(1);
		Monster monster2 = randomMonster2.getMonster();
		System.out.println("MONSTER2 "+monster2.getName()+" STATS");
		System.out.println("Max Health: "+monster2.getHealthUpper()+" Current Health: "+monster2.getCurrentHealth());
		System.out.println("Attack1 Max Damage: "+monster2.getatt1Upper()+"/ Current Damage: "+monster2.getAttack(1)+" Accuracy "+monster2.getAttackOdds1()+"%");
		System.out.println("Attack2 Max Damage: "+monster2.getatt2Upper()+"/ Current Damage: "+monster2.getAttack(2)+" Accuracy "+monster2.getAttackOdds2()+"%");
		System.out.println("Attack3 Max Damage: "+monster2.getatt3Upper()+"/ Current Damage: "+monster2.getAttack(3)+" Accuracy "+monster2.getAttackOdds3()+"%"+"\n");
		
		RandomisingMonster randomMonster3 = new RandomisingMonster(1);
		Monster monster3 = randomMonster3.getMonster();
		System.out.println("MONSTER3 "+monster3.getName()+" STATS");
		System.out.println("Max Health: "+monster3.getHealthUpper()+" Current Health: "+monster3.getCurrentHealth());
		System.out.println("Attack1 Max Damage: "+monster3.getatt1Upper()+"/ Current Damage: "+monster3.getAttack(1)+" Accuracy "+monster3.getAttackOdds1()+"%");
		System.out.println("Attack2 Max Damage: "+monster3.getatt2Upper()+"/ Current Damage: "+monster3.getAttack(2)+" Accuracy "+monster3.getAttackOdds2()+"%");
		System.out.println("Attack3 Max Damage: "+monster3.getatt3Upper()+"/ Current Damage: "+monster3.getAttack(3)+" Accuracy "+monster3.getAttackOdds3()+"%"+"\n");	
		int chosenMonster = sc.nextInt();
		while(chosenMonster < 1 || chosenMonster > 3) {
			System.out.println("Monster selected must be between (1-3) inclusive");
			System.out.print("Choose your starter Monster (1,2 or 3)");
			chosenMonster = sc.nextInt();
		}
		if(chosenMonster == 1) {
			starter = monster1;
		} else if (chosenMonster == 2) {
			starter = monster2;
		} else if (chosenMonster == 3) {
			starter = monster3;
		}
	}
	
	/**Returns the player's starter Monster*/
	public Monster getStarter() {
		return starter;
	}
	
	/**Allows the user to stay with default starter name or rename its starter monster*/
	public void renameStarter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to rename your Monster "+starter.getName()+"?");
		System.out.println("(1) Yes | (any other number) No"); /*Careful if not number input*/
		int changeName = sc.nextInt();
		if(changeName == 1) {
			System.out.println("Enter the new name of your starter");
			String newName = sc.next();
			starter.setName(newName);  /*Need to be aware of case that only user presses enter*/
		}
	}
	
	/**Sets the difficulty of the game
	 *
	 * 1: Moderate Difficulty, 2: Hard Difficulty
	*/
	public void setDifficulty() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Difficult:");
		System.out.println("1: Moderate 2: Hard");
		int diff = sc.nextInt();
		if(diff == 1 || diff == 2) {
			difficulty = diff;
		} else {
			System.out.println("Must select difficulty from either (1) or (2)");
			setDifficulty();
		}
	}
	
	/**Returns the difficulty as an integer*/ 
	public int getDifficulty() {
		return difficulty;
	}
	
	public static void main(String[] args) {
		SetupGame setup = new SetupGame();
	}
}
