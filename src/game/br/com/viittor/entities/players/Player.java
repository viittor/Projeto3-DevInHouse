package game.br.com.viittor.entities.players;

import java.util.Scanner;

import game.br.com.viittor.entities.classTypes.Healer;
import game.br.com.viittor.entities.classTypes.Warrior;
import game.br.com.viittor.entities.classTypes.Wizard;

public class Player {
	private String name;
	private int gender;
	private int classType;
	private String nameClassType;
	private String suffix;
	private int weaponDamage; // ataque arma
	private String nameWeapon;
	private int motivation;
	private String nameMotivation;
	private int defensePoints;
	private int attackPoints; // ataque personagem

	Gender playerGender = new Gender();

	Scanner keyboard = new Scanner(System.in);

	// Instance of ClassTypes
	Healer healer = new Healer(400, 10);
	Warrior warrior = new Warrior(300, 15);
	Wizard wizard = new Wizard(250, 20);
	
	public Player() {
		super();
	}

	public Player(String name, int gender, int classType, int weaponDamage) {
		super();
		this.name = name;
		this.gender = gender;
		this.classType = classType;
		this.weaponDamage = weaponDamage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
	}

	public int getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	public String getNameClassType() {
		return nameClassType;
	}

	public void setNameClassType(String nameClassType) {
		this.nameClassType = nameClassType;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getNameWeapon() {
		return nameWeapon;
	}

	public void setNameWeapon(String nameWeapon) {
		this.nameWeapon = nameWeapon;
	}

	public int getMotivation() {
		return motivation;
	}

	public void setMotivation(int motivation) {
		this.motivation = motivation;
	}

	public String getNameMotivation() {
		return nameMotivation;
	}

	public void setNameMotivation(String nameMotivation) {
		this.nameMotivation = nameMotivation;
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

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public Healer getHealer() {
		return healer;
	}

	public void setHealer(Healer healer) {
		this.healer = healer;
	}

	public Warrior getWarrior() {
		return warrior;
	}

	public void setWarrior(Warrior warrior) {
		this.warrior = warrior;
	}

	public Wizard getWizard() {
		return wizard;
	}

	public void setWizard(Wizard wizard) {
		this.wizard = wizard;
	}

	// Gender
//		1 - Masculino
//		2 - Feminino
//		3 - Prefiro não dizer
	// Get Player Gender
	public void defineGender() {
		System.out.println("\nEscolha o número correspondente ao seu gênero: ");
		System.out.println("1 - Masculino\n" + "2 - Feminino\n" + "3 - Prefiro não dizer");
		System.out.print("Sua escolha: ");
		do {
			this.setGender(keyboard.nextInt());
			if (this.getGender() == 1) {
				System.out.println("\nMasculino selecionado!\n");
			} else if (this.getGender() == 2) {
				System.out.println("\nFeminino selecionado!\n");
			} else if (this.getGender() == 3) {
				System.out.println("\nNenhum gênero selecionado!\n");
			} else {
				System.out.print("Opção Inválida!\n" + "Por favor insira o numero da opção que deseja: ");
			}
		} while (this.getGender() < 1 || this.getGender() > 3);
	}

	// Set Suffix
	public void setSuffixGender() {
		if (this.gender == 1) {
			suffix = playerGender.men;
		} else if (this.gender == 2) {
			suffix = playerGender.women;
		} else {
			suffix = playerGender.noneGender;
		}
	}

	public String setSuffixUM() {
		String suffixUm;
		if (this.gender == 1) {
			suffixUm = "";
		} else if (this.gender == 3) {
			suffixUm = "(a)";
		} else {
			suffixUm = suffix;
		}
		return suffixUm;

	}

	// Set ClassType Name
	public void changeClassType() {
		if (this.getClassType() == 1) {
			this.nameClassType = "Curandeir" + this.suffix;
		} else if (this.getClassType() == 2) {
			this.nameClassType = "Guerreir" + this.suffix;
		} else if (this.getClassType() == 3) {
			this.nameClassType = "Mag" + this.suffix;
		}
	}

	// Set ClassType
	public void setClasstypeMethod() {
		System.out.printf(
				"Escolha uma classe de combate:\n1 - Curandeiro (Vida: %d Pontos | Força do Ataque: %d pontos)\n2 - Guerreiro (Vida: %d Pontos | Força do Ataque: %d pontos)\n3 - Mago (Vida: %d Pontos | Força do Ataque: %d pontos)\n",
				healer.getDefensePoints(), healer.getAttackPoints(), warrior.getDefensePoints(),
				warrior.getAttackPoints(), wizard.getDefensePoints(), wizard.getAttackPoints());
		System.out.print("Sua escolha: ");
		this.setClassType(keyboard.nextInt());
		this.changeClassType();

		// Set Attack and defense points
		if (this.getClassType() == 1) {
			this.setAttackPoints(healer.getAttackPoints());
			this.setDefensePoints(healer.getDefensePoints());
		} else if (this.getClassType() == 2) {
			this.setAttackPoints(warrior.getAttackPoints());
			this.setDefensePoints(warrior.getDefensePoints());
		} else if (this.getClassType() == 3) {
			this.setAttackPoints(wizard.getAttackPoints());
			this.setDefensePoints(wizard.getDefensePoints());
		}
	}

	// Set Weapon
	public void changeWeapon() {
		int numberWeapon = 0;
		if (this.classType == 1) {
			// Healer
			System.out.println("1 -  Cajado (Força do ataque: 10)\n" + "2 - Martelo (Força do ataque: 15)\n");
			System.out.print("Sua escolha: ");
			numberWeapon = keyboard.nextInt();
			if (numberWeapon == 1) {
				System.out.println("\nVocê escolheu usar o Cajado!");
				this.setWeaponDamage(healer.getStaff().getDamage());
				this.setNameWeapon("Cajado");
			} else if (numberWeapon == 2) {
				System.out.println("\nVocê escolheu usar o Martelo!");
				this.setWeaponDamage(healer.getHammer().getDamage());
				this.setNameWeapon("Martelo");
			}
		} else if (this.classType == 2) {
			// Warrior
			System.out.println("1 -  Machado (Força do ataque: 20)\n" + "2 - Espada (Força do ataque: 20)\n"
					+ "3 - Arco (Força do ataque: 15)");
			System.out.print("Sua escolha: ");
			numberWeapon = keyboard.nextInt();
			if (numberWeapon == 1) {
				System.out.println("\nVocê escolheu usar o Machado!");
				this.setWeaponDamage(warrior.getAxe().getDamage());
				this.setNameWeapon("Machado");
			} else if (numberWeapon == 2) {
				System.out.println("\nVocê escolheu usar a Espada!");
				this.setWeaponDamage(warrior.getSword().getDamage());
				this.setNameWeapon("Espada");
			} else if (numberWeapon == 3) {
				System.out.println("\nVocê escolheu usar o Arco e Flecha!");
				this.setWeaponDamage(warrior.getArrow().getDamage());
				this.setNameWeapon("Arco e Flecha");

			}
		} else if (this.classType == 3) {
			// Wizard
			System.out.println("1 -  Livro (Força do ataque: 20)\n" + "2 - Besta (Força do ataque: 15)\n");
			System.out.print("Sua escolha: ");
			numberWeapon = keyboard.nextInt();
			if (numberWeapon == 1) {
				System.out.println("\nVocê escolheu usar o Livro!");
				this.setWeaponDamage(wizard.getBook().getDamage());
				this.setNameWeapon("Livro");
			} else if (numberWeapon == 2) {
				System.out.println("\nVocê escolheu usar a Besta e Virote!");
				this.setWeaponDamage(wizard.getCrossBow().getDamage());
				this.setNameWeapon("Besta e Virote");

			}
		}

	}

	// Set Motivation
	public void changeMotivation() {
		System.out.println("Escolha sua motivação para invadir a caverna do inimigo e derrotá-lo:\n" + "1 - Vingança\n"
				+ "2 - Glória");
		System.out.print("Sua escolha: ");
		this.motivation = keyboard.nextInt();
		if (motivation == 1) {
			this.nameMotivation = "Vingança";
		} else if (motivation == 2) {
			this.nameMotivation = "Glória";
		}

		System.out.printf("Você escolheu %s\n\n", this.getNameMotivation());
	}

}
