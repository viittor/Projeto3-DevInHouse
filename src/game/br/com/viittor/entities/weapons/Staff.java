package game.br.com.viittor.entities.weapons;

public class Staff extends Weapon{

	public Staff(int damage) {
		super(damage);
		}
	
	public String complement() {
		String complement = "com seu Cajado, lan�ando uma bola de fogo ";
		return complement;
	}
}
