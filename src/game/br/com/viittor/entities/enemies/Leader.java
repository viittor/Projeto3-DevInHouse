package game.br.com.viittor.entities.enemies;

import game.br.com.viittor.entities.weapons.Axe;

public class Leader extends Enemy {

	Axe axe = new Axe(20);

	public Leader(int damage, int health, int defense, int weapon) {
		super(damage, health, defense, weapon);
	}

	public Axe getAxe() {
		return axe;
	}

}
