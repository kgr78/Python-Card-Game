public class Charlie extends Monster {
	
	
	/**Charlie class constructor
	 *
	 * Initializes the Monsters name, faint status, description, attack1, attack2, attack3, attack1 odds, attack2 odds, attack3 odds, health upper bound, heath lower bound, attack1 upper bound, attack1 lower bound, attack2 upper bound, attack2 lower bound, attack3 upper bound, attack3 lower bound.
	*/
	public Charlie(int health, int attack1, int attack2, int attack3,int price) {
		super("Charlie", false, "Dormant through the day, but awake and ready to fight during the night. This monster is sure to get busy through the night.", health, attack1, attack2, attack3, 90, 70, 40, 240, 140, 45, 20, 60, 35, 85, 60, 170, 20, price, 20, 100);
	}
	
	
	public static void main(String[] args) {
	}
	
	
}
