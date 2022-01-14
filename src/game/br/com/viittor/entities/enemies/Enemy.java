package game.br.com.viittor.entities.enemies;

public abstract class Enemy {

	private double damage;
	private double health;

	public Enemy(int damage, int health) {
		this.damage = damage;
		this.health = health;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double d) {
		this.damage = d;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	
}
