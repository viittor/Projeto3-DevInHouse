package game.br.com.viittor.entities.classTypes;

import game.br.com.viittor.entities.weapons.Hammer;
import game.br.com.viittor.entities.weapons.Staff;

public class Healer extends ClassTypes {

	// Instance of Weapons
	Staff staff = new Staff(10);// cajado
	Hammer hammer = new Hammer(15);// martelo

	public Healer(int attackPoints, int defensePoints) {
		super(attackPoints, defensePoints);
		}
	
	public Staff getStaff() {
		return staff;
	}

	public Hammer getHammer() {
		return hammer;
	}

}
