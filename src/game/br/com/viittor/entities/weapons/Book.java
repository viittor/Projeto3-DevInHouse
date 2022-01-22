package game.br.com.viittor.entities.weapons;

public class Book extends Weapon{

	public Book(int damage) {
		super(damage);
	}
	
	public String complement() {
		String complement = "absorvendo energia do livro com uma mão e liberando com a outra ";
		return complement;
	}

}
