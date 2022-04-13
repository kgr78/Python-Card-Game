public class Monster {
	private String name;
	private int health;
	private int attack;
	private int heal;
	private boolean faintStatus;
	private String type;
	private String description;
	
	public Monster(String name, int health, int attack, int heal, boolean faintStatus, String type, String description) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.heal = heal;
		this.faintStatus = faintStatus;
		this.type = type;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getHeal() {
		return heal;
	}
	
	public boolean getfaintStatus() {
		return faintStatus;
	}
	
	public String getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}
}