package game.br.com.viittor.entities.classtypes;

import game.br.com.viittor.entities.players.Player;

public abstract class ClassType {
	private int defensePoints;
	private int attackPoints;
	
	Player player = new Player(null, 0, 0, 0);
	
	public ClassType(int defensePoints, int attackPoints) {
		this.defensePoints = defensePoints;
		this.attackPoints = attackPoints;
	}

	public int getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}

	public int getAttackPoints() {
		return attackPoints;
	}
	
	public int hardLevel() {
		attackPoints = (int) (attackPoints * 0.90);
		return attackPoints;
	}
	
	

}
