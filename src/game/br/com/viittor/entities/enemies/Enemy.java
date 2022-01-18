package game.br.com.viittor.entities.enemies;

public class Enemy {

	private int attack;
	private int health;
	private int defense;
	private int weapon;

	public Enemy() {
		super();
	}

	public Enemy(int damage, int health, int defense, int weapon) {
		this.attack = damage;
		this.health = health;
		this.defense = defense;
		this.weapon = weapon;
	}

	public int getDamage() {
		return attack;
	}

	public void setDamage(int damage) {
		this.attack = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int easyLevel() {
		attack = (int) (attack * 0.80);
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getWeapon() {
		return weapon;
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

}
