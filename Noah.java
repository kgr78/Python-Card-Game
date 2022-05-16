public class Noah extends Monster {
	
	/**Noah class constructor
	 *
	 * Initializes the Monsters name, faint status, description, attack1, attack2, attack3, attack1 odds, attack2 odds, attack3 odds, health upper bound, heath lower bound, attack1 upper bound, attack1 lower bound, attack2 upper bound, attack2 lower bound, attack3 upper bound, attack3 lower bound.
	*/
	public Noah(int health, int attack1, int attack2, int attack3, int price) {
		super("Noah", false, "Although one of the oldest monsters on the grid, the fiery monster rages in battle. With a dumbell in one hand and a tennis racket in the other, Noah does not lose many battles just alot tennis matches", health, attack1, attack2, attack3, 100, 80, 50, 200, 100, 35, 10, 45, 20, 65, 40, 130, 20, price, 20, 100);
	}
	
	
}
