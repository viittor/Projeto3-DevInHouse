package game.br.com.viittor.entities.classtypes;

import game.br.com.viittor.entities.weapons.Book;
import game.br.com.viittor.entities.weapons.CrossBow;

public class Wizard extends ClassType {
	// Instance of Weapons
	Book book = new Book(20);//livro
	CrossBow crossBow = new CrossBow(15);//besta
	
	public Wizard(int defensePoints, int attackPoints) {
		super(defensePoints, attackPoints);
	}

	public Book getBook() {
		return book;
	}

	public CrossBow getCrossBow() {
		return crossBow;
	}

}
