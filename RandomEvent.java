import java.util.Random;

public class RandomEvent {
	private int teamLength;
	public RandomEvent(int teamLength) {
		this.teamLength = teamLength;
	}
	
	public int getTeamLength() {
		return this.teamLength;
	}
	
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

	public boolean MonsterLevels() {
		boolean result = false;
		Random x = new Random();
		if(x.nextInt(0,101) < 10) {
			result = true;
		}
		return result;
	}
	
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
