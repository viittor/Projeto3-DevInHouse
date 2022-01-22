package game.br.com.viittor.entities.weapons;

public class CrossBow extends Weapon{

	public CrossBow(int damage) {
		super(damage);
	}

	public String complement() {
		String complement = "com sua Besta e o Virote atingiu o inimigo ";
		return complement;
	}
}
