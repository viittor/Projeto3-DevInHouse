package game.br.com.viittor.entities.weapons;

public abstract class Weapon {
	private int damage;

	public Weapon(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}	

}
