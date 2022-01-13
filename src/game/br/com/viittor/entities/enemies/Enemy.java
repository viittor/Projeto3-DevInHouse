package game.br.com.viittor.entities.enemies;

public abstract class Enemy {
	
	private int damage;
	private int health;
	
	public Enemy(int damage, int health) {
		this.damage = damage;
		this.health = health;
	}

	
}
