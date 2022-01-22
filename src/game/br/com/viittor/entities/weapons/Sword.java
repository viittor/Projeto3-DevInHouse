package game.br.com.viittor.entities.weapons;

public class Sword extends Weapon{

	public Sword(int damage) {
		super(damage);
	}
	
	public String complement() {
		String complement = "com sua Espada ";
		return complement;
	}

}
