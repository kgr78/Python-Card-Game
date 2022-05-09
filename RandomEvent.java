import java.util.Random;

public class RandomEvent {
	private int teamLength;
	
	/**RandomEvent class constructor
	 *
	 *Initializes the teamLength which is the size of the player team ArrayList.
	*/
	public RandomEvent(int teamLength) {
		this.teamLength = teamLength;
	}
	
	/**Returns the the team length*/
	public int getTeamLength() {
		return this.teamLength;
	}
	
	/**Returns a boolean value randomly generated which represents whether a Monster in the player team leaves*/
	public boolean MonsterLeaves() {
		boolean result = false;
		if(getTeamLength() > 1) {
			Random x = new Random();
			if(x.nextInt(0, 101) < 3) {
				result = true;
			}
		}
		return result;
	}

	/**Returns a boolean value randomly generated which represents whether a Monster in the player team levels up*/
	public boolean MonsterLevels() {
		boolean result = false;
		Random x = new Random();
		if(x.nextInt(0,101) < 10) {
			result = true;
		}
		return result;
	}
	
	/**Returns a boolean value randomly generated which represents whether a random Monster the player's team*/
	public boolean MonsterJoins() {
		boolean result = false;
		if(getTeamLength() < 4) {
			Random x = new Random();
			if(x.nextInt(0, 101) < 3) {
				result = true;
			}
		}
		return result;
	}
 }
