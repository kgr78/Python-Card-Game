public class Ben extends Monster{
	
	/**Ben class constructor
	 *
	 * Initializes the Monsters name, faint status, description, attack1, attack2, attack3, attack1 odds, attack2 odds, attack3 odds, health upper bound, heath lower bound, attack1 upper bound, attack1 lower bound, attack2 upper bound, attack2 lower bound, attack3 upper bound, attack3 lower bound.
	*/
	public Ben(int health, int attack1, int attack2, int attack3) {
		super("Ben", false, "More of a Warrior than a Monster. It's nickname on the street is the 3rd Splash Bro. Stuns enemies with its devastating gas.", health, attack1, attack2, attack3, 100, 25, 10, 200, 100, 30, 5, 80, 55, 180, 155);
	}
}
