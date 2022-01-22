package game.br.com.viittor.entities.weapons;

public class Arrow extends Weapon{

	public Arrow(int damage) {
		super(damage);
	}

	public String complement() {
		String complement = "com seu Arco e a Flexa atingiu o inimigo ";
		return complement;
	}

}
