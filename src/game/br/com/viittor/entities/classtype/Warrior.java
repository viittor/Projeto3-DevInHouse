package game.br.com.viittor.entities.classtype;

import game.br.com.viittor.entities.weapons.Arrow;
import game.br.com.viittor.entities.weapons.Axe;
import game.br.com.viittor.entities.weapons.Sword;

public class Warrior extends ClassTypes {

	public Warrior(int attackPoints, int defensePoints) {
		super(attackPoints, defensePoints);
	}

	// Instance of Weapons
	Axe axe = new Axe(20); // Machado
	Sword sword = new Sword(20);// espada
	Arrow arrow = new Arrow(15);// arco

	public Axe getAxe() {
		return axe;
	}

	public Sword getSword() {
		return sword;
	}

	public Arrow getArrow() {
		return arrow;
	}

}
