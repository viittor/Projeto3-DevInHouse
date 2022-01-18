package game.br.com.viittor.entities.enemies;

import game.br.com.viittor.entities.weapons.Staff;

public class Alchemist extends Enemy {

	Staff staff = new Staff(10);

	public Alchemist(int damage, int health, int defense, int weapon) {
		super(damage, health, defense, weapon);
	}

	public Staff getStaff() {
		return staff;
	}

}
