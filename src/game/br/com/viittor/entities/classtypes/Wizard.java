package game.br.com.viittor.entities.classTypes;

import game.br.com.viittor.entities.weapons.Book;
import game.br.com.viittor.entities.weapons.CrossBow;

public class Wizard extends ClassTypes {

	// Instance of Weapons
	Book book = new Book(20);//livro
	CrossBow crossBow = new CrossBow(15);//besta
	
	public Wizard(int attackPoints, int defensePoints) {
		super(attackPoints, defensePoints);
	}

	public Book getBook() {
		return book;
	}

	public CrossBow getCrossBow() {
		return crossBow;
	}

}
