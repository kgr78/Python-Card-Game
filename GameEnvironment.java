import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameEnvironment {
	private ArrayList<Monster> yourTeam = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeamOne = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeamTwo = new ArrayList<Monster>();
	private ArrayList<Monster> enemyTeamThree = new ArrayList<Monster>();
	private ArrayList<Integer> validBattles = new ArrayList<Integer>();
	private ArrayList<GettingItems> yourItems = new ArrayList<GettingItems>();
	private ArrayList<Monster> storeMonsters = new ArrayList<Monster>(); 
	private ArrayList<GettingItems> storeItems = new ArrayList<GettingItems>();
	private int difficulty;
	private int points;
	private int gold;
	private int day = 1;
	
	
	public GameEnvironment() {
	}
	
	/**Returns the valid battles the player can choose from*/
	public ArrayList<Integer> getValidBattles() {
		return validBattles;
	}
	
	/**Resets the valid battles the player can choose from.
	 * 
	 * Resets the validBattles ArrayList to [1,2,3]*/
	public void resetValidBattles() {
		int i = 1;
		while(i < 4) {
			getValidBattles().add(i);
			i = i + 1;
		}
	}
	
	/**Returns the game difficulty represented as an integer
	 *
	 *(1) Represents Moderate difficulty, (2) Represents Hard difficulty;
	*/
	public int getDifficulty() {
		return difficulty;
	}
	
	/**Adds gold dependent on the player battle and whether the player won*/
	public void addGoldFromBattle(int difficulty, int chosenBattle, boolean outcome) {
		Random ran = new Random();
		int goldAdded = 0;
		if(chosenBattle == 1 && outcome == true) {
			goldAdded = ran.nextInt(50, 100);
		} else if(chosenBattle == 2 && outcome == true) {
			goldAdded = ran.nextInt(70, 150);
		} else if(chosenBattle == 3 && outcome == true) {
			goldAdded = ran.nextInt(80, 200);
		}
		if(difficulty == 2) {
			addGold(goldAdded - 40);
		} else {
			addGold(goldAdded);
		}
	}
	
	/**Adds gold dependent on the player battle and whether the player won*/
	public void addPointsFromBattle(int difficulty, int chosenBattle, boolean outcome) {
		Random ran = new Random();
		int pointsAdded = 0;
		if(chosenBattle == 1 && outcome == true) {
			pointsAdded = ran.nextInt(50, 100);
		} else if(chosenBattle == 2 && outcome == true) {
			pointsAdded = ran.nextInt(70, 150);
		} else if(chosenBattle == 3 && outcome == true) {
			pointsAdded = ran.nextInt(80, 200);
		}
		addPoints(pointsAdded);
	}
	
	/**Adds a given integer amount specified in the parameter to the points variable*/ 
	public void addPoints(int amount) {
		points += amount;
	}
	
	/**Returns Items in store*/
	public ArrayList<GettingItems> getStoreItems() {
		return storeItems;
	}
	
	/**Adds item to items being sold in store*/
	public void addToStore(GettingItems item) {
		getStoreItems().add(item); 
	}
	
	/**Returns Monsters being sold in store*/
	public ArrayList<Monster> getStoreMon(){
		return storeMonsters; 
	}
	
	/**Adds monster to monster list that will be sold in store*/
	public void addMonToStore(Monster mon) {
		getStoreMon().add(mon); 
	}
	
	/**Return players items*/
	public ArrayList<GettingItems> getYourItems(){
		return yourItems; 
	}
	
	/**Adds item to players items list (inventory)*/
	public void addToItems(GettingItems item) {
		getYourItems().add(item); 
	}
	
	/**Return the player's points*/
	public int getPoints() {
		return points;
	}
	
	/**Adds a given integer amount specified in the parameter to the gold variable*/
	public void addGold(int amount) {
		gold += amount;
	}
	
	/**Returns the player's gold amount*/
	public int getGold() {
		return gold;
	}
	
	/**Returns the current day.*/
	public int getDay() {
		return day;
	}
	
	/**Increases the current day by one.*/
	public void increaseDay() {
		this.day += 1;
	}
	
	/**Returns your monster team ArrayList.*/
	public ArrayList<Monster> getYourTeam() {
		return yourTeam;
	}
	
	/**Adds the given Monster parameter to your Team ArrayList.*/
	public void addToTeam(Monster mon) {
		getYourTeam().add(mon);
	}
	
	/**Returns the first enemy team.*/
	public ArrayList<Monster> getEnemyTeamOne() {
		return enemyTeamOne;
	}
	
	/**Returns the second enemy team*/
	public ArrayList<Monster> getEnemyTeamTwo() {
		return enemyTeamTwo;
	}
	
	/**Returns the third enemy team*/
	public ArrayList<Monster> getEnemyTeamThree() {
		return enemyTeamThree;
	}
	
	/**Sets the first enemy team to the given parameter of an ArrayList<Monster>*/
	public void setEnemyTeamOne(ArrayList<Monster> enemyTeam) {
		this.enemyTeamOne = enemyTeam;
	}
	
	/**Sets the second enemy team to the given parameter of an ArrayList<Monster>*/
	public void setEnemyTeamTwo(ArrayList<Monster> enemyTeam) {
		this.enemyTeamTwo = enemyTeam;
	}
	
	/**Sets the third enemy team to the given parameter of an ArrayList<Monster>*/
	public void setEnemyTeamThree(ArrayList<Monster> enemyTeam) {
		this.enemyTeamThree = enemyTeam;
	}
	
	/**Resets all enemy teams by having all team ArrayList being empty*/
	public void resetEnemyTeams() {
		getEnemyTeamOne().clear();
		getEnemyTeamTwo().clear();
		getEnemyTeamThree().clear();
	}
	
	/***/
	public void resetStoreItems() {
		getStoreItems().clear(); 
		getStoreMon().clear(); 
	}
	
	/**Generates the three enemy teams dependent on the day*/
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
	
	/**Creates 3 random monsters and items with random prices*/
	public void storeItemsGeneration() {
		gold = gold + 100; 
		for (int i = 0; i < 3; i++) 
	      { 		      
			RandomisingItems item = new RandomisingItems(1);
			GettingItems items = item.getItem(); 
			addToStore(items);
			
	      }
		
		for (int i = 0; i < 3; i++) { 		      
			RandomisingMonster mon = new RandomisingMonster(1);
			Monster randMon = mon.getMonster(); 
			addMonToStore(randMon);	
		  }
	}
	
	
	
	/**Adds Monster from store to inventory and takes cost off gold*/
	public void chosenMonsterStore(int numMon) {
		if (yourTeam.size() < 4) {
			if ((gold - getStoreItems().get(numMon).getBuyPrice()) >= 0) {
				addToTeam(getStoreMon().get(numMon)); 
				gold = gold - getStoreItems().get(numMon).getBuyPrice(); 
				System.out.println("Monster "+(numMon+4)+" Added to Inventory");
			}
		}
		else {
			System.out.println("To many monsters on team or not enough gold to buy please disgard monster or pick an item");
		}
	}
	
	/**Adds item from store to inventory and takes cost off gold*/
	public void chosenItemStore(int numItem) {
		if (yourItems.size() < 4) {
			if ((gold - getStoreItems().get(numItem).getBuyPrice()) >= 0) {
				addToItems(getStoreItems().get(numItem)); 
				gold = gold - getStoreItems().get(numItem).getBuyPrice(); 
				System.out.println("Item "+(numItem+1)+" Added to Inventory"); 
			}
		}
		else {
			System.out.println("To many Items in invetory or not enough gold to buy. Please disgard an item or pick a monster\n");
		}
	}
	/**Creates store and lets person choose items and monsters*/
	public void createStore() {
		System.out.println("ITEM STORE FOR ITEMS:");
		System.out.println("Items will be added to invetory and can be used after / before battles \n");
		System.out.println("Pick and item between 1 - 6 or press anything else to leave");
		for (int i = 0; i < getStoreItems().size();i++) 
	      { 		      
	          System.out.println(getStoreItems().get(i).toString()); 		
	      } 
		for (int i = 0; i < getStoreMon().size();i++) 
	      { 		      
	          System.out.println(getStoreMon().get(i).storeMonString()); 		
	      } 
		Scanner sc = new Scanner(System.in);
		int chosenItem = sc.nextInt();
		if (chosenItem == 1) {
			chosenItemStore(0); 
		} else if (chosenItem == 2) {
			chosenItemStore(1);
		} else if (chosenItem == 3) {
			chosenItemStore(2);
		} 
		else if (chosenItem == 4){
			chosenMonsterStore(0); 
		}
		else if (chosenItem == 5) {
			chosenMonsterStore(1); 
		}
		else if (chosenItem == 6) {
			chosenMonsterStore(2); 
		}
		else {
			System.out.println("\n");
		}
		
	}
	
	/**Selects monster in the players team*/
	public Monster selectMonster() {
		Scanner sc = new Scanner(System.in);
		Monster mon;
		System.out.println("Select a monster from: 1 - "+getYourTeam().size());
		for(Monster mons : yourTeam) {
			System.out.println(mons.storeMonString());
		}
		int a = sc.nextInt();
		mon = yourTeam.get(a-1);
		return mon;
	}
	
	/**Selects items from players item list*/
	public GettingItems selectItem() {
		Scanner sc = new Scanner(System.in);
		GettingItems item; 
		System.out.println("Select which item: 0 - "+getYourItems().size());
		for(GettingItems items : yourItems) {
			System.out.println(items.toString());
		}
		int a = sc.nextInt();
		item = yourItems.get(a-1); 
		return item; 
	}
	
	/**Picks the monsters from players team to use and item on the monster*/
	public void usingItem() {
		Monster mon = selectMonster(); 
		GettingItems item = selectItem(); 
		item.getFainted(); 
		if (mon.getfaintStatus() == true && item.getFainted() == false) {
			mon.setfaintStatus(false);
			mon.updateAttack(item.getAttackUpdate(), 3); 
			mon.updateCurrentHealth(item.getHealing());
			getYourItems().remove(item); 
			System.out.println("Item removed from use"); 
		}
		else if (mon.getfaintStatus() == false){
			mon.updateCurrentHealth(item.getHealing());
			mon.updateAttack(item.getAttackUpdate(), 3); 
			getYourItems().remove(item); 
			System.out.println("Item removed from use"); 
		}
		else {
			System.out.println("Item dosent work with chosen monstor \n"); 
			useItems();
		}	
		
	}
	
	/**Uses items on Monsters and takes out of the inventory*/ 
	public void useItems() {
		if (getYourItems().size() > 0) {
			System.out.println("1 = use items or anything else to leave");
			Scanner sc = new Scanner(System.in);
			int chosenItem = sc.nextInt();
			if (chosenItem == 1) {
				usingItem();
			}
			else{
				System.out.println();
			}
		}
		else {
			System.out.println("Unable to use items becuase none in inventory"); 
		}
	}
	
	/**Selects monster to sell back to store and removes from team*/
	public void sellingMonsters() {
		Monster mon = selectMonster();
		gold = gold + mon.getSellPrice(); 
		getYourTeam().remove(mon); 
	}
	/**Selects item to sell back to store and removes from team*/
	public void sellingItems() {
		GettingItems item = selectItem(); 
		gold = gold + item.getSellPrice(); 
		getYourItems().remove(item); 
	}
	
	/**Used to sell items and monsters owned by player back to store*/
	public void sellingToStore() {
		try {
			System.out.println("Current gold: " + gold);
			System.out.println("Selling Items or Monsters ? 1 ,2 or anything else to leave\n");
			Scanner sc = new Scanner(System.in);
			int chosenItem = sc.nextInt();
			if (chosenItem == 1 && getYourItems().size() > 0) {
				sellingItems(); 
				System.out.println(gold);
					 
			} else if (chosenItem == 2 && getYourTeam().size() > 1) {
				sellingMonsters(); 
				System.out.println(gold);
			}else if (chosenItem == 2 && getYourTeam().size() < 1) {
				System.out.println("Unable to sell because only 1 monster in team");
				System.out.println("Must keep 1 Monster in team for battle");
			}	else if (chosenItem == 1 && getYourItems().size() == 0) {
				System.out.println("No items in inventory please pick some monsters to sell or buy some items");
				sellingToStore(); 
			}
					 
			else {
				System.out.println("\n");
			}
		}catch(InputMismatchException e) {
			System.out.println("Please enter a valid number from the choices \n");
			sellingToStore();  
		}
	}

	public void visitingStore() { 
		if (day > 1) {
			System.out.println("Current gold: " + gold);
			System.out.println("Would you like To buy or sell an item / monster \n");
			System.out.println("Please pick numbers 1 or 2 (anything else to carry on to next fight) \n");
			Scanner sc = new Scanner(System.in);
			try {
				int chosenItem = sc.nextInt();
				if (chosenItem == 1) {
					createStore();
					System.out.println("Would you like to buy another item or sell and item? 1 = return to shop or 0 to leave shop\n");
					int chosenItem1 = sc.nextInt();
					if (chosenItem1 == 1){
						visitingStore();   
					}
					else {
						resetStoreItems(); 
						System.out.println("Now left the store \\n"); 
					}
				} else if (chosenItem == 2) {
					sellingToStore(); 
					System.out.println("Would you like to buy another item or sell and item? 1 = return to shop or any number to skip\n");
					int chosenItem1 = sc.nextInt();
					if (chosenItem1 == 1){
						visitingStore(); 
					}
					else {
						resetStoreItems(); 
						System.out.println("Now left the store \\n");
					}
				}else{
					resetStoreItems(); 
					System.out.println("Now left the store \n");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Please enter a valid number from the choices \n");
				visitingStore(); 
			}
			
			
		}
	}
	
	public void usingItems() {
		try {
			if (day > 1) {
				System.out.println("Would you like To use your Items on your monsters? yes or no.");
				System.out.println("Please pick numbers 1 or anything else to carry on to next fight \n");
				Scanner sc = new Scanner(System.in);
				int chosenItem = sc.nextInt();
				if (chosenItem == 1) {
					useItems(); 
					System.out.println("would you like to use another item? yes or no \n");
					int chosenItem1 = sc.nextInt();
					if (chosenItem1 == 1){
						usingItems(); 
					}
				} else {
					System.out.println("Now moving to next battle \n");
				}
			}
			
		}catch(InputMismatchException e) {
			System.out.println("Please enter a valid number from the choices \n");
			usingItems(); 
		}
	}
	/**First allows the user to select a given valid battle by integer or iterate to the next day
	 * 
	 * If a battle is chosen, calls Battle class to generate a battle. 
	 * 
	 * If user selects to skip the day, the day counter increases by one.
	 */
	public void createBattle() {
		try {
			levelGeneration();
			Scanner sc = new Scanner(System.in);
			String bat1 = "";
			String bat2 = "";
			String bat3 = "";
			boolean outcome = false;
			
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
				getValidBattles().remove(Integer.valueOf(chosenBattle));
				Battle bat = new Battle(getYourTeam(), getEnemyTeamOne());
				System.out.println(bat.fullBattle());
				outcome = bat.getOutcome();
			} else if (chosenBattle == 2) {
				getValidBattles().remove(Integer.valueOf(chosenBattle));
				Battle bat = new Battle(getYourTeam(), getEnemyTeamTwo());
				System.out.println(bat.fullBattle());
				outcome = bat.getOutcome();
			} else if (chosenBattle == 3) {
				getValidBattles().remove(Integer.valueOf(chosenBattle));
				Battle bat = new Battle(getYourTeam(), getEnemyTeamThree());
				System.out.println(bat.fullBattle());
				outcome = bat.getOutcome();
			} else {
				increaseDay();
			}
			addPointsFromBattle(getDifficulty(), chosenBattle, outcome);
			addGoldFromBattle(getDifficulty(), chosenBattle, outcome);
			if(outcome == true) {
				for(Monster mon: getYourTeam()) {
					mon.levelUp();
				}
			}
			
		}catch(InputMismatchException e) {
			System.out.println("Please enter a valid number from the choices \n");
			createBattle(); 
		}
	}
	
	/**Generates three independent random events.
	 * 
	 * First random event is that a monster in your team leaves by being removed in your team ArrayList.
	 * Second random event is that a monster in your team levels up by its stats increases.
	 * Third random event is that a randomly generated monster is added to your team. 
	 * 
	 * Method uses the RandomEvent class to determine whether these events are triggered.
	 */
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
			 getYourTeam().get(chosenMonster).updateCurrentHealth(10);
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
	
	
	/**The GameEnvironment main function*/
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		SetupGame set = new SetupGame();
		String playerName = set.getPlayerName();
		int maxDays = set.getMaxDays();
		Monster starter = set.getStarter();
		game.addToTeam(starter);
		game.difficulty = set.getDifficulty();
		while (game.getDay() < maxDays + 1) {
			System.out.println("Current Day: "+Integer.toString(game.getDay()));
			System.out.println("Days Remaining: "+Integer.toString(maxDays - game.getDay()));
			
			int currentDay = game.getDay();
			game.resetValidBattles();
			game.RanEvent();
			
			while(currentDay == game.getDay() && game.getValidBattles().size() != 0) {
				System.out.println("Gold: "+game.getGold()+"\n");
				System.out.println("Points: "+game.getPoints()+"\n");
				
				System.out.println("Your Current Team");
				int var = 1;
				for(Monster mon : game.getYourTeam()) {
					System.out.println(Integer.toString(var)+":"+"\n"+mon);
					var += 1;	
				}
				game.createBattle();
			}
			
				game.storeItemsGeneration();
				game.visitingStore();
				game.usingItems();

			
			for(Monster mon: game.getYourTeam()) {
				mon.updateCurrentHealth(mon.getHealAmount());
			}
		}
	}

}
