package game.br.com.viittor.entities.players;

import java.util.Scanner;

public class Player {
	private String name;
	private int gender;
	private String classType;
	private String weapon;
	
	Scanner keyboard = new Scanner(System.in);
	
	public Player(String name, int gender, String classType, String weapon) {
		super();
		this.name = name;
		this.gender = gender;
		this.classType = classType;
		this.weapon = weapon;
	}
// Gender
//	1 - Masculino
//	2 - Feminino
//	3 - Prefiro não dizer
	
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

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	// Get Player Gender
	public void defineGender() {
		do {
			this.setGender(keyboard.nextInt());
			if (this.getGender() == 1) {
				System.out.println("Masculino selecionado!\n");
			} else if (this.getGender() == 2) {
				System.out.println("Feminino selecionado!\n");
			} else if (this.getGender() == 3) {
				System.out.println("Nenhum gênero selecionado!\n");
			} else {
				System.out.print("Opção Inválida!\n" + "Por favor insira o numero da opção que deseja: ");
			}
		} while (this.getGender() < 1 || this.getGender() > 3);
	}

	

}
