public class Hugo extends Monster 
{
	/**Hugo class constructor
	 *
	 * Initializes the Monsters name, faint status, description, attack1, attack2, attack3, attack1 odds, attack2 odds, attack3 odds, health upper bound, heath lower bound, attack1 upper bound, attack1 lower bound, attack2 upper bound, attack2 lower bound, attack3 upper bound, attack3 lower bound.
	*/
	public Hugo(int health, int attack1, int attack2, int attack3) {
		super("Hugo", false, "A very calculated Monster. Rarely misses attacks due to the monster's understanding of probability thereom. Also extremely tanky due to diet of chicken jalfrezi.", health, attack1, attack2, attack3, 100, 95, 85, 300, 200, 28, 3, 31, 6, 40, 15);
	}
}
