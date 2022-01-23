package game.br.com.viittor.entities.players;

import java.util.InputMismatchException;
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
	private int weaponDamage;
	private String nameWeapon;
	private int motivation;
	private String nameMotivation;
	private int defensePoints;
	private int attackPoints;
	private int health;
	private String weaponComplement;

	Gender playerGender = new Gender();

	Scanner keyboard = new Scanner(System.in);

	// Instance of ClassTypes
	Healer healer = new Healer(10, 15);
	Warrior warrior = new Warrior(20, 10);
	Wizard wizard = new Wizard(15, 15);

	public Player() {
		super();
	}

	public Player(String name, int gender, int classType, int weaponDamage, int health) {
		super();
		this.name = name;
		this.gender = gender;
		this.classType = classType;
		this.weaponDamage = weaponDamage;
		this.health = health;
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getWeaponComplement() {
		return weaponComplement;
	}

	// Get Player Gender
	public void defineGender() {
		this.gender = 0;
		while (this.gender != 1 || this.gender != 2 || this.gender != 3) {
			try {
				System.out.println("========================================");
				System.out.println("ESCOLHA O NÚMERO CORRESPONDENTE AO SEU GÊNERO: ");
				System.out.println("1 - Masculino\n" + "2 - Feminino\n" + "3 - Prefiro não dizer");
				System.out.print("Sua escolha: ");
				this.setGender(keyboard.nextInt());

				if (this.gender == 1) {
					System.out.println("========================================");
					System.out.println("Masculino selecionado!");
					System.out.println("========================================\n");
					break;
				} else if (this.gender == 2) {
					System.out.println("========================================");
					System.out.println("Feminino selecionado!");
					System.out.println("========================================\n");
					break;
				} else if (this.gender == 3) {
					System.out.println("========================================");
					System.out.println("Nenhum gênero selecionado!");
					System.out.println("========================================\n");
					break;
				}
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}
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

	public String setSuffixUA() {
		String suffixUA;
		if (this.gender == 1) {
			suffixUA = "eu";
		} else if (this.gender == 2) {
			suffixUA = "ua";
		} else {
			suffixUA = "eu(sua)";
		}
		return suffixUA;
	}

	public String setSuffixNA() {
		String suffixNA;
		if (this.gender == 1) {
			suffixNA = "ói";
		} else if (this.gender == 2) {
			suffixNA = "oína";
		} else {
			suffixNA = "ói(na)";
		}
		return suffixNA;
	}

	// Set ClassType
	public void setClasstypeMethod() {
		this.setClassType(0);
		while (this.getClassType() != 1 || this.getClassType() != 2 || this.getClassType() != 3) {
			try {
				System.out.println("========================================");
				System.out.printf(
						"ESCOLHA UMA CLASSE DE COMBATE:\n1 - Curandeiro (Defesa: %d Pontos | Ataque: %d pontos)\n2 - Guerreiro (Defesa: %d Pontos | Ataque: %d pontos)\n3 - Mago (Defesa: %d Pontos | Ataque: %d pontos)\n",
						healer.getDefensePoints(), healer.getAttackPoints(), warrior.getDefensePoints(),
						warrior.getAttackPoints(), wizard.getDefensePoints(), wizard.getAttackPoints());
				System.out.print("Sua escolha: ");
				this.setClassType(keyboard.nextInt());
				System.out.println("");
				this.changeClassType();

				// Set Attack and defense points
				if (this.getClassType() == 1) {
					this.setAttackPoints(healer.getAttackPoints());
					this.setDefensePoints(healer.getDefensePoints());
					break;
				} else if (this.getClassType() == 2) {
					this.setAttackPoints(warrior.getAttackPoints());
					this.setDefensePoints(warrior.getDefensePoints());
					break;
				} else if (this.getClassType() == 3) {
					this.setAttackPoints(wizard.getAttackPoints());
					this.setDefensePoints(wizard.getDefensePoints());
					break;
				}
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}
		System.out.println("\n****************************************");
		System.out.printf("Você escolheu ser %s!\n", this.getNameClassType());
		System.out.println("****************************************\n");
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

	// Set Weapon
	public void changeWeapon() {
		int numberWeapon = 0;
		if (this.classType == 1) {
			// Healer
			while (numberWeapon != 1 || numberWeapon != 2) {
				try {
					System.out.println("1 -  Cajado (Força do ataque: 10)\n" + "2 - Martelo (Força do ataque: 15)\n");
					System.out.print("Sua escolha: ");
					numberWeapon = keyboard.nextInt();
					if (numberWeapon == 1) {
						System.out.println("========================================");
						System.out.println("Você escolheu usar o Cajado!");
						System.out.println("========================================\n");
						this.setWeaponDamage(healer.getStaff().getDamage());
						this.setNameWeapon("Cajado");
						this.weaponComplement = healer.getStaff().complement();
						break;
					} else if (numberWeapon == 2) {
						System.out.println("========================================");
						System.out.println("Você escolheu usar o Martelo!");
						System.out.println("========================================\n");
						this.setWeaponDamage(healer.getHammer().getDamage());
						this.setNameWeapon("Martelo");
						this.weaponComplement = healer.getHammer().complement();
						break;
					}
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				} catch (InputMismatchException exception) {
					System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Opção Inválida! Por favor digite apenas números!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					keyboard.next();
				}
			}

		} else if (this.classType == 2) {
			// Warrior
			while (numberWeapon != 1 || numberWeapon != 2 || numberWeapon != 3) {
				try {
					System.out.println("========================================");
					System.out.println("1 -  Machado (Força do ataque: 20)\n" + "2 - Espada (Força do ataque: 20)\n"
							+ "3 - Arco (Força do ataque: 15)");
					System.out.print("Sua escolha: ");
					numberWeapon = keyboard.nextInt();
					if (numberWeapon == 1) {
						System.out.println("========================================");
						System.out.println("Você escolheu usar o Machado!");
						System.out.println("========================================\n");
						this.setWeaponDamage(warrior.getAxe().getDamage());
						this.setNameWeapon("Machado");
						this.weaponComplement = warrior.getAxe().complement();
						break;
					} else if (numberWeapon == 2) {
						System.out.println("========================================");
						System.out.println("Você escolheu usar a Espada!");
						System.out.println("========================================\n");
						this.setWeaponDamage(warrior.getSword().getDamage());
						this.setNameWeapon("Espada");
						this.weaponComplement = warrior.getSword().complement();
						break;
					} else if (numberWeapon == 3) {
						System.out.println("========================================");
						System.out.println("Você escolheu usar o Arco e Flecha!");
						System.out.println("========================================\n");
						this.setWeaponDamage(warrior.getArrow().getDamage());
						this.setNameWeapon("Arco e Flecha");
						this.weaponComplement = warrior.getArrow().complement();
						break;
					}
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				} catch (InputMismatchException exception) {
					System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Opção Inválida! Por favor digite apenas números!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					keyboard.next();
				}
			}
		} else if (this.classType == 3) {
			// Wizard
			while (numberWeapon != 1 || numberWeapon != 2) {
				try {
					System.out.println("1 -  Livro (Força do ataque: 20)\n" + "2 - Besta (Força do ataque: 15)\n");
					System.out.print("Sua escolha: ");
					numberWeapon = keyboard.nextInt();
					if (numberWeapon == 1) {
						System.out.println("========================================");
						System.out.println("Você escolheu usar o Livro!");
						System.out.println("========================================\n");
						this.setWeaponDamage(wizard.getBook().getDamage());
						this.setNameWeapon("Livro");
						this.weaponComplement = wizard.getBook().complement();
						break;
					} else if (numberWeapon == 2) {
						System.out.println("========================================");
						System.out.println("Você escolheu usar a Besta e Virote!");
						System.out.println("========================================\n");
						this.setWeaponDamage(wizard.getCrossBow().getDamage());
						this.setNameWeapon("Besta e Virote");
						this.weaponComplement = wizard.getCrossBow().complement();
						break;
					}
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				} catch (InputMismatchException exception) {
					System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Opção Inválida! Por favor digite apenas números!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					keyboard.next();
				}
			}
		}

	}

}
