public class Noah extends Monster {
	/*COMMENT*/
	
	public Noah(int health, int attack1, int attack2, int attack3) {
		super("Noah", false, "Although one of the oldest monsters on the grid, the fiery monster rages in battle. With a dumbell in one hand and a tennis racket in the other, Noah does not lose many battles just alot tennis matches", health, attack1, attack2, attack3, 100, 80, 50, 200, 100, 35, 10, 45, 20, 65, 40);
	}
	
	public static void main(String[] args) {
		Monster noah = new Noah(100, 20, 30, 60);
		System.out.println(noah.getDescription());
	}
	
	
}
