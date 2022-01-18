package game.br.com.viittor.entities.classTypes;

public class ClassTypes {

	int attackPoints;
	int defensePoints;

	public ClassTypes(int attackPoints, int defensePoints) {
		super();
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public int getDefensePoints() {
		return defensePoints;
	}

	// Choose level
	public int hardLevel() {
		attackPoints = (int) (attackPoints * 0.90);
		return attackPoints;
	}

}
