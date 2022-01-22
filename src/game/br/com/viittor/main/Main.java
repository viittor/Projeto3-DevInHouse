package game.br.com.viittor.main;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import game.br.com.viittor.entities.combat.Combat;
import game.br.com.viittor.entities.motivation.Glory;
import game.br.com.viittor.entities.motivation.Revenge;

public class Main {
	public static void main(String[] args) {

		// Instance of Motivations
		Revenge revenge = new Revenge();
		Glory glory = new Glory();

		// Instance of Dices
		Random generator = new Random();
		int dice = generator.nextInt(10) + 1;

		// Instance of Combat
		Combat combat = new Combat();

		// Instance of Scanner
		Scanner keyboard = new Scanner(System.in);

		// Method Validade Int

		String texto = "========================================\n" + "TEXTO\n"
				+ "========================================";

		// START
		System.out.println("========================================");
		System.out.println("== Seja bem vindo(a) a BATALHA FINAL! ==");
		System.out.println("========================================\n");

		// Set the difficulty parameters
		int difficulty = 0;
		while (difficulty != 1 || difficulty != 2 || difficulty != 3) {
			try {
				System.out.println("========================================");
				System.out.println(
						"ESCOLHA SEU NÍVEL DE DIFICULDADE:\n" + "1 - Fácil\n" + "2 - Normal\n" + "3 - Difícil");
				System.out.print("Sua escolha: ");
				difficulty = keyboard.nextInt();
				if (difficulty == 1) {
					combat.getGunman().easyLevel();
					combat.getAlchemist().easyLevel();
					combat.getLeader().easyLevel();
					System.out.println("========================================");
					System.out.println("======= Nível Fácil Selecionado! =======");
					System.out.println("========================================\n");
					break;
				} else if (difficulty == 3) {
					combat.getPlayer().getHealer().hardLevel();
					combat.getPlayer().getWarrior().hardLevel();
					combat.getPlayer().getWizard().hardLevel();
					System.out.println("========================================");
					System.out.println("====== Nível Difícil Selecionado! ======");
					System.out.println("========================================\n");
					break;
				} else if (difficulty == 2) {
					System.out.println("========================================");
					System.out.println("====== Nível Normal Selecionado! =======");
					System.out.println("========================================\n");
					break;
				}
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}
		//// Set Player Name
		System.out.println("========================================");
		System.out.print("DIGITE SEU NOME: ");
		combat.getPlayer().setName(keyboard.next());
		System.out.println("");
		
		// Set Player Gender
		combat.getPlayer().defineGender();
		combat.getPlayer().setSuffixGender();

		// Set ClassType
		combat.getPlayer().setClasstypeMethod();

		System.out.println("****************************************");
		System.out.printf("Você escolheu ser %s!\n", combat.getPlayer().getNameClassType());
		System.out.println("****************************************\n");

		// ****** aqui vai o código que define os pontos do personagem
		System.out.println("========================================");
		System.out.printf("Agora que você é um%s %s, escolha uma arma:\n", combat.getPlayer().setSuffixUM(),
				combat.getPlayer().getNameClassType());
		combat.getPlayer().changeWeapon();

		System.out.println(texto);

		// ChangeMotivation
		combat.changeMotivation();

		// Text of motivation
		if (combat.getPlayer().getMotivation() == 1) {
			revenge.initialText();
		} else if (combat.getPlayer().getMotivation() == 2) {
			glory.initialText();
		}

		System.out.println(texto);

		// Choose give up or move on
		int chooseWay = 0;
		while (chooseWay != 1 || chooseWay != 2) {
			try {
				System.out.println("========================================");
				System.out.println("ESCOLHA O QUE QUER FAZER AGORA: \n" + "1 - Desistir\n" + "2 - Seguir em frente");
				System.out.print("Sua escolha: ");
				chooseWay = keyboard.nextInt();
				System.out.println(chooseWay);
				break;
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				keyboard.next();
			}
		}

		System.out.println("");

		if (chooseWay == 1) {
			System.out.println(
					"O medo invade o seu coração e você sente que ainda não está à altura do desafio. Você se volta para a noite lá fora e corre em direção à segurança.");
			System.out.println("***** JOGO ENCERRADO *****");
			System.exit(0);// End game
		} else if (chooseWay == 2) {
			System.out.println(
					"Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.");
		}
		System.out.println(texto);

		// Go through the door
		int firstDoor = 0;
		while (firstDoor != 1 || firstDoor != 2 || firstDoor != 3) {
			try {
				System.out.println("========================================");
				System.out.println("ESCOLHA COMO QUER ENTRAR: \n" + "1 - Andando cuidadosamente\n" + "2 - Correndo\n"
						+ "3 - Saltando");
				System.out.print("Sua escolha: ");
				firstDoor = keyboard.nextInt();
				System.out.println("");

				if (firstDoor == 1) {
					System.out.println(
							"Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta. Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor. Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");
					int lostPoints = combat.getPlayer().getWarrior().getArrow().getDamage() + dice;
					combat.getPlayer().setHealth(combat.getPlayer().getHealth() - lostPoints);
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.printf("Você perdeu %d pontos de vida! sua vida atual é de %d pontos\n", lostPoints,
							combat.getPlayer().getHealth());
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					break;
				} else if (firstDoor == 2) {
					System.out.println(
							"Você respira fundo e desata a correr em direção à sala. Quando passa pela porta, sente que pisou em uma pedra solta, mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você, e quando se vira, vê várias flechas no chão. Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
					break;
				} else if (firstDoor == 3) {
					System.out.println(
							"Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
					break;
				}
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				keyboard.next();
			}
		}

		System.out.println(texto);

		// ** Change Enemy **
		combat.chooseGunman();

		// COMBAT LOOP
		combat.combatLoop();

		System.out.println(texto);

		// Choose if take the armor
		int armor = 0;
		while (armor != 1 || armor != 2) {
			try {
				System.out.println("========================================");
				System.out.printf("%s, QUER PEGAR A ARMADURA NOVA?\n", combat.getPlayer().getName().toUpperCase());
				System.out.println("1 - Pegar armadura nova\n" + "2 - Manter minha armadura atual");
				System.out.print("Sua escolha: ");
				armor = keyboard.nextInt();

				if (armor == 1) {
					System.out.println(
							"Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova, você se sente mais protegido para os desafios à sua frente.");
					combat.getPlayer().setDefensePoints(combat.getPlayer().getDefensePoints() + 5);
					System.out.println("++++++++++++++++++++++++++++++++++++++++");
					System.out.printf("Você recebeu 5 pontos extras de defesa. Sua defesa atual é %d pontos.",
							combat.getPlayer().getDefensePoints());
					System.out.println("++++++++++++++++++++++++++++++++++++++++");
					break;
				} else if (armor == 2) {
					System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.\n");
					break;
				}

			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}

		// ** Change Enemy **

		System.out.println(texto);

		// COMBAT LOOP
		combat.combatLoop();

		// Choose if drink potion

		int drink = 0;
		while (drink != 1 || drink != 2) {
			try {
				System.out.println("========================================");
				System.out.printf("%s, QUER BEBER A POÇÃO?\n", combat.getPlayer().getName().toUpperCase());
				System.out.println("1 - Beber\n" + "2 - Não beber");
				System.out.print("Sua escolha: ");
				drink = keyboard.nextInt();
				if (drink == 1) {
					System.out.println("++++++++++++++++++++++++++++++++++++++++");
					System.out.println("Você se sente revigorado para seguir adiante!");
					combat.getPlayer().setHealth(combat.getInitialPlayerHealth());
					System.out.printf("Você recuperou todos os seus pontos de vida. Sua vida atual é %d pontos",
							combat.getPlayer().getHealth());
					System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
					break;
				} else if (drink == 2) {
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Você fica receoso de beber algo produzido pelo inimigo.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					break;
				}

			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}

		// ** Change Enemy **
		combat.chooseLeader();

		// Choose if attack leader
		int attackLeader = 0;
		while (attackLeader != 1 || attackLeader != 2) {
			try {
				System.out.println("========================================");
				System.out.printf("%s, QUER ATACAR O LÍDER?\n", combat.getPlayer().getName().toUpperCase());
				System.out.println("1 - Atacar\n" + "2 - Esperar");
				System.out.print("Sua escolha: ");
				attackLeader = keyboard.nextInt();
				if (attackLeader == 1) {
					// COMBAT LOOP
					combat.combatLoop();
					break;
				} else if (attackLeader == 2) {
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Você decidiu fugir!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					System.exit(0);
				}

			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}

		System.out.println(texto);
		System.out.println("");
		System.out.println("*     *   ****    *      *    *           *    *    *       *");
		System.out.println(" *   *   *    *   *      *    *           *    *    * *     *");
		System.out.println("  * *   *      *  *      *    *           *    *    *  *    *");
		System.out.println("   *    *      *  *      *     *    *    *     *    *   *   *");
		System.out.println("   *    *      *  *      *      *   *   *      *    *    *  *");
		System.out.println("   *     *    *    *    *        * * * *       *    *     * *");
		System.out.println("   *      ****      ****          *   *        *    *       *");
		System.out.println("");

		if (combat.getPlayer().getMotivation() == 1) {
			System.out.println(
					"Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
		} else if (combat.getPlayer().getMotivation() == 2) {
			System.out.println(
					"O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
		}

		System.out.println(
				"Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem em direção à noite, retornando à cidade. Seu dever está cumprido.");

		keyboard.close();
		System.out.println("\n\n***** JOGO ENCERRADO *****");

	}

}
