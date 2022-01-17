package game.br.com.viittor.entities.classtypes;

import java.util.Scanner;

import game.br.com.viittor.entities.weapons.Hammer;
import game.br.com.viittor.entities.weapons.Staff;

public class Healer extends ClassType {
	// Instance of Weapons
	Staff staff = new Staff(10);// cajado
	Hammer hammer = new Hammer(15);// martelo

	Scanner keyboard = new Scanner(System.in);

	public Healer(int defensePoints, int attackPoints) {
		super(defensePoints, attackPoints);
	}

	public Staff getStaff() {
		return staff;
	}

	public Hammer getHammer() {
		return hammer;
	}

}
