package game.br.com.viittor.entities.weapons;

public class Book extends Weapon{

	public Book(int damage) {
		super(damage);
	}
	
	public String complement() {
		String complement = "absorvendo energia do livro com uma m�o e liberando com a outra ";
		return complement;
	}

}
