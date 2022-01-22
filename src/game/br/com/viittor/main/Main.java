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
						"ESCOLHA SEU N�VEL DE DIFICULDADE:\n" + "1 - F�cil\n" + "2 - Normal\n" + "3 - Dif�cil");
				System.out.print("Sua escolha: ");
				difficulty = keyboard.nextInt();
				if (difficulty == 1) {
					combat.getGunman().easyLevel();
					combat.getAlchemist().easyLevel();
					combat.getLeader().easyLevel();
					System.out.println("========================================");
					System.out.println("======= N�vel F�cil Selecionado! =======");
					System.out.println("========================================\n");
					break;
				} else if (difficulty == 3) {
					combat.getPlayer().getHealer().hardLevel();
					combat.getPlayer().getWarrior().hardLevel();
					combat.getPlayer().getWizard().hardLevel();
					System.out.println("========================================");
					System.out.println("====== N�vel Dif�cil Selecionado! ======");
					System.out.println("========================================\n");
					break;
				} else if (difficulty == 2) {
					System.out.println("========================================");
					System.out.println("====== N�vel Normal Selecionado! =======");
					System.out.println("========================================\n");
					break;
				}
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
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
		System.out.printf("Voc� escolheu ser %s!\n", combat.getPlayer().getNameClassType());
		System.out.println("****************************************\n");

		// ****** aqui vai o c�digo que define os pontos do personagem
		System.out.println("========================================");
		System.out.printf("Agora que voc� � um%s %s, escolha uma arma:\n", combat.getPlayer().setSuffixUM(),
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
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				keyboard.next();
			}
		}

		System.out.println("");

		if (chooseWay == 1) {
			System.out.println(
					"O medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio. Voc� se volta para a noite l� fora e corre em dire��o � seguran�a.");
			System.out.println("***** JOGO ENCERRADO *****");
			System.exit(0);// End game
		} else if (chooseWay == 2) {
			System.out.println(
					"Voc� caminha, atento a todos os seus sentidos, por v�rios metros, at� visualizar a frente uma fonte de luz, que voc� imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.");
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
							"Voc� toma cuidado e vai caminhando vagarosamente em dire��o � luz. Quando voc� pisa exatamente embaixo da porta, voc� sente o ch�o ceder levemente, como se tivesse pisado em uma pedra solta. Voc� ouve um ru�do de mecanismos se movimentando, e uma escotilha se abre no teto atr�s de voc�, no corredor. Flechas voam da escotilha em sua dire��o, e voc� salta para dentro da sala, por�m uma delas te acerta na perna.");
					int lostPoints = combat.getPlayer().getWarrior().getArrow().getDamage() + dice;
					combat.getPlayer().setHealth(combat.getPlayer().getHealth() - lostPoints);
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.printf("Voc� perdeu %d pontos de vida! sua vida atual � de %d pontos\n", lostPoints,
							combat.getPlayer().getHealth());
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					break;
				} else if (firstDoor == 2) {
					System.out.println(
							"Voc� respira fundo e desata a correr em dire��o � sala. Quando passa pela porta, sente que pisou em uma pedra solta, mas n�o d� muita import�ncia e segue para dentro da sala, olhando ao redor � procura de inimigos. N�o tem ningu�m, mas voc� ouve sons de flechas batendo na pedra atr�s de voc�, e quando se vira, v� v�rias flechas no ch�o. Espiando pela porta, voc� entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por sorte voc� entrou correndo e conseguiu escapar desse ataque surpresa.");
					break;
				} else if (firstDoor == 3) {
					System.out.println(
							"Voc� se concentra e pula em dire��o � luz, saltando de antes da porta at� o interior da sala.");
					break;
				}
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
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
							"Voc� resolve usar os equipamentos do inimigo contra ele, e trocar algumas pe�as suas, que estavam danificadas, pelas pe�as de armaduras existentes na sala. De armadura nova, voc� se sente mais protegido para os desafios � sua frente.");
					combat.getPlayer().setDefensePoints(combat.getPlayer().getDefensePoints() + 5);
					System.out.println("++++++++++++++++++++++++++++++++++++++++");
					System.out.printf("Voc� recebeu 5 pontos extras de defesa. Sua defesa atual � %d pontos.",
							combat.getPlayer().getDefensePoints());
					System.out.println("++++++++++++++++++++++++++++++++++++++++");
					break;
				} else if (armor == 2) {
					System.out.println("Voc� decide que n�o precisa utilizar nada que venha das m�os do inimigo.\n");
					break;
				}

			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
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
				System.out.printf("%s, QUER BEBER A PO��O?\n", combat.getPlayer().getName().toUpperCase());
				System.out.println("1 - Beber\n" + "2 - N�o beber");
				System.out.print("Sua escolha: ");
				drink = keyboard.nextInt();
				if (drink == 1) {
					System.out.println("++++++++++++++++++++++++++++++++++++++++");
					System.out.println("Voc� se sente revigorado para seguir adiante!");
					combat.getPlayer().setHealth(combat.getInitialPlayerHealth());
					System.out.printf("Voc� recuperou todos os seus pontos de vida. Sua vida atual � %d pontos",
							combat.getPlayer().getHealth());
					System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
					break;
				} else if (drink == 2) {
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Voc� fica receoso de beber algo produzido pelo inimigo.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					break;
				}

			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
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
				System.out.printf("%s, QUER ATACAR O L�DER?\n", combat.getPlayer().getName().toUpperCase());
				System.out.println("1 - Atacar\n" + "2 - Esperar");
				System.out.print("Sua escolha: ");
				attackLeader = keyboard.nextInt();
				if (attackLeader == 1) {
					// COMBAT LOOP
					combat.combatLoop();
					break;
				} else if (attackLeader == 2) {
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Voc� decidiu fugir!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					System.exit(0);
				}

			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
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
					"Voc� obteve sua vingan�a. Voc� se ajoelha e cai no choro, invadido por uma sensa��o de al�vio e felicidade. Voc� se vingou, tudo que sempre quis, est� feito. Agora voc� pode seguir sua vida.");
		} else if (combat.getPlayer().getMotivation() == 2) {
			System.out.println(
					"O �xtase em que voc� se encontra n�o cabe dentro de si. Voc� se ajoelha e grita de alegria. A gl�ria o aguarda, voc� a conquistou.");
		}

		System.out.println(
				"Voc� se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos voc�s saem em dire��o � noite, retornando � cidade. Seu dever est� cumprido.");

		keyboard.close();
		System.out.println("\n\n***** JOGO ENCERRADO *****");

	}

}
