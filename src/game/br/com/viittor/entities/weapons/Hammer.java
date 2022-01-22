package game.br.com.viittor.entities.weapons;

public class Hammer extends Weapon{

	public Hammer(int damage) {
		super(damage);
	}
		
	public String complement() {
		String complement = "com seu Martelo ";
		return complement;
	}

}
