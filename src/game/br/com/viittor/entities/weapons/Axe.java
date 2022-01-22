package game.br.com.viittor.entities.weapons;

public class Axe extends Weapon{

	public Axe(int damage) {
		super(damage);
	}
	
	public String complement() {
		String complement = "com seu Machado ";
		return complement;
	}

}
