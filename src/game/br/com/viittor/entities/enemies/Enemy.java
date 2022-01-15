package game.br.com.viittor.entities.enemies;

public abstract class Enemy {

	private int damage;
	private int health;

	public Enemy(int damage, int health) {
		this.damage = damage;
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int easyLevel() {
		damage = (int) (damage * 0.80);
		return damage;
	}
}
