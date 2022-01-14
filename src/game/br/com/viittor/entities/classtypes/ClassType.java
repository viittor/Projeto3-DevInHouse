package game.br.com.viittor.entities.classtypes;

public abstract class ClassType {
	private int defensePoints;
	private int attackPoints;
	
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
	
	
	

}
