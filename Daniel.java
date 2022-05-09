public class Daniel extends Monster {
	
	/**Daniel class constructor
	 *
	 * Initializes the Monsters name, faint status, description, attack1, attack2, attack3, attack1 odds, attack2 odds, attack3 odds, health upper bound, heath lower bound, attack1 upper bound, attack1 lower bound, attack2 upper bound, attack2 lower bound, attack3 upper bound, attack3 lower bound.
	*/
	public Daniel(int health, int attack1, int attack2, int attack3) {
		super("Daniel", false, "Although its health isn't the greatest with all the takeaways it eats, it is the hardest hitting Monster purely due to its leverish arms.", health, attack1, attack2, attack3, 70, 60, 30, 180, 80, 50, 25, 60, 35, 100, 75);
	}

}
