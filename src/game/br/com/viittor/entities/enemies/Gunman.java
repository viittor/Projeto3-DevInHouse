package game.br.com.viittor.entities.enemies;

import game.br.com.viittor.entities.weapons.Sword;

public class Gunman extends Enemy {

	Sword sword = new Sword(20);

	public Gunman(int damage, int health, int defense, int weapon) {
		super(damage, health, defense, weapon);
	}

	public Sword getSword() {
		return sword;
	}

}
