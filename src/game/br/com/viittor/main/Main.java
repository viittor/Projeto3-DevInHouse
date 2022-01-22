package game.br.com.viittor.main;

import java.util.Random;
import java.util.Scanner;

import game.br.com.viittor.entities.combat.Combat;
import game.br.com.viittor.entities.motivation.Glory;
import game.br.com.viittor.entities.motivation.Revenge;
import game.br.com.viittor.entities.players.Player;

public class Main {
	public static void main(String[] args) {

		// Instance of player
		Player player = new Player();

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

		String texto = "========================================\n" + "TEXTO\n"
				+ "========================================";

//		// START
//		System.out.println("Seja bem vindo(a) a BATALHA FINAL!\n");
//
//		// Set the difficulty parameters
//		int difficulty = 0;
//		while (difficulty < 1 || difficulty > 3) {
//			// try {
//			System.out.println("Escolha seu n�vel de dificuldade:\n" + "1 - F�cil\n" + "2 - Normal\n" + "3 - Dif�cil");
//			System.out.print("Sua escolha: ");
//			difficulty = keyboard.nextInt();
//			if (difficulty == 1) {
//				combat.getGunman().easyLevel();
////				System.out.println(combat.getGunman().getAttack());
////				System.out.println(combat.getGunman().getDefense());
//				combat.getAlchemist().easyLevel();
////				System.out.println(combat.getAlchemist().getAttack());
////				System.out.println(combat.getAlchemist().getDefense());
//				combat.getLeader().easyLevel();
////				System.out.println(combat.getLeader().getAttack());
////				System.out.println(combat.getLeader().getDefense());
//				System.out.println("\nN�vel F�cil Selecionado!\n");
//			} else if (difficulty == 3) {
//				combat.getPlayer().getHealer().hardLevel();
////				System.out.println(player.getHealer().getAttackPoints());
////				System.out.println(player.getHealer().getDefensePoints());
//				combat.getPlayer().getWarrior().hardLevel();
////				System.out.println(player.getWarrior().getAttackPoints());
////				System.out.println(player.getWarrior().getDefensePoints());
//				combat.getPlayer().getWizard().hardLevel();
////				System.out.println(player.getWizard().getAttackPoints());
////				System.out.println(player.getWizard().getDefensePoints());
//				System.out.println("\nN�vel Dif�cil Selecionado!\n");
//			} else if (difficulty == 2) {
//				System.out.println("\nN�vel Normal Selecionado!\n");
//			} else {
//				System.out.println("\nOp��o Inv�lida! Por favor insira o n�mero correspondente a sua escolha: ");
//			}
////			}catch(Exception e) {
////				System.out.println("\nOp��o Inv�lida! Por favor Digite apenas n�meros:");
////				difficulty = keyboard.nextInt();
////			}
//		}
//
//		//// Set Player Name
//		System.out.print("Digite seu nome: ");
//		player.setName(keyboard.next());
//
//		// Set Player Gender
//		player.defineGender();
//		player.setSuffixGender();
//
//		// Set ClassType
//		player.setClasstypeMethod();
//
//		System.out.printf("\n");
//
//		System.out.printf("Voc� escolheu ser %s! \n\n", player.getNameClassType());
//
//		// ****** aqui vai o c�digo que define os pontos do personagem
//
//		System.out.printf("Agora que voc� � um%s %s, escolha uma arma:\n", player.setSuffixUM(),
//				player.getNameClassType());
//		player.changeWeapon();
//
//		System.out.println(texto);
//
//		// ChangeMotivation
//		player.changeMotivation();
//
//		// Text of motivation
//		if (player.getMotivation() == 1) {
//			revenge.initialText();
//		} else if (player.getMotivation() == 2) {
//			glory.initialText();
//		}
//
//		System.out.println(texto);
//
//		// Choose give up or move on
//		System.out.println("Escolha o que quer fazer agora: \n" + "1 - Desistir\n" + "2 - Seguir em frente");
//		System.out.print("Sua escolha: ");
//		int chooseWay = keyboard.nextInt();
//
//		if (chooseWay == 1) {
//			System.out.println("\nDESISTIR: o medo invade o seu cora��o e voc� sente que ainda n�o est�\n"
//					+ "� altura do desafio. Voc� se volta para a noite l� fora e corre em dire��o\n" + "� seguran�a.");
//			System.out.println("***** JOGO ENCERRADO *****");
//			System.exit(0);// End game
//		} else if (chooseWay == 2) {
//			System.out.println("\nSEGUIR: voc� caminha, atento a todos os seus sentidos, por v�rios metros,\n"
//					+ "at� visualizar a frente uma fonte de luz, que voc� imagina ser a chama de\n"
//					+ "uma tocha, vindo de dentro de uma porta aberta.\n");
//		}
//		System.out.println(texto);
//
//		// Go through the door
//		System.out.println(
//				"Escolha como quer entrar: \n" + "1 - Andando cuidadosamente\n" + "2 - Correndo\n" + "3 - Saltando");
//		System.out.print("Sua escolha: ");
//		int firstDoor = keyboard.nextInt();
//
//		if (firstDoor == 1) {
//			System.out.println("\nANDANDO: Voc� toma cuidado e vai caminhando vagarosamente em dire��o � luz. Quando\n"
//					+ "voc� pisa exatamente embaixo da porta, voc� sente o ch�o ceder levemente, como se\n"
//					+ "tivesse pisado em uma pedra solta. Voc� ouve um ru�do de mecanismos se movimentando,\n"
//					+ "e uma escotilha se abre no teto atr�s de voc�, no corredor. Flechas voam da\n"
//					+ "escotilha em sua dire��o, e voc� salta para dentro da sala, por�m uma delas te\n"
//					+ "acerta na perna.\n");
//			int lostPoints = player.getWarrior().getArrow().getDamage() + dice;
//			combat.getPlayer().setHealth(combat.getPlayer().getHealth() - lostPoints);
//			System.out.printf("VOC� PERDEU %d PONTOS DE VIDA! SUA VIDA ATUAL � DE %d PONTOS\n", lostPoints,
//					combat.getPlayer().getHealth());
//		} else if (firstDoor == 2) {
//			System.out.println(
//					"CORRENDO: Voc� respira fundo e desata a correr em dire��o � sala. Quando passa pela porta,\n"
//							+ "sente que pisou em uma pedra solta, mas n�o d� muita import�ncia e segue para dentro da sala,\n"
//							+ "olhando ao redor � procura de inimigos. N�o tem ningu�m, mas voc� ouve sons de flechas batendo\n"
//							+ "na pedra atr�s de voc�, e quando se vira, v� v�rias flechas no ch�o. Espiando pela porta, voc�\n"
//							+ "entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por\n"
//							+ "sorte voc� entrou correndo e conseguiu escapar desse ataque surpresa.");
//		} else if (firstDoor == 3) {
//			System.out.println("SALTANDO: Voc� se concentra e pula em dire��o � luz, saltando de antes da porta\n"
//					+ "at� o interior da sala.");
//		}
//
//		System.out.println(texto);
//		
//		// ** Change Enemy **
//		combat.chooseGunman();
//		System.out.println("INIMIGO MUDOU");
//
//		// COMBAT LOOP
//		combat.combatLoop();
//
//		System.out.println(texto);
//
//		// Choose if take the armor
//		System.out.printf("%s, quer pegar a armadura nova?\n", player.getName());
//		System.out.println("1 - Pegar armadura nova\n" + "2 - Manter minha armadura atual");
//		System.out.print("Sua escolha: ");
//		int armor = keyboard.nextInt();
//
//		if (armor == 1) {
//			System.out
//					.println("\nVoc� resolve usar os equipamentos do inimigo contra ele, e trocar algumas pe�as suas,\n"
//							+ "que estavam danificadas, pelas pe�as de armaduras existentes na sala. De armadura nova,\n"
//							+ "voc� se sente mais protegido para os desafios � sua frente.\n");
//			player.setDefensePoints(player.getDefensePoints() + 5);
//			System.out.printf("\nVOC� RECEBEU 5 PONTOS EXTRAS DE DEFESA. SUA DEFESA ATUAL � %d PONTOS\n",
//					player.getDefensePoints());
//		} else if (armor == 2) {
//			System.out.println("\nVoc� decide que n�o precisa utilizar nada que venha das m�os do inimigo.\n");
//		}
//
//		// ** Change Enemy **
		combat.chooseAlchemist();
//		System.out.println("INIMIGO MUDOU");
//		
//		System.out.println(texto);
//
//		// COMBAT LOOP
//		combat.combatLoop();
//
//		// Choose if drink potion
//		System.out.printf("%s, quer beber a po��o?\n", player.getName());
//		System.out.println("1 - Beber\n" + "2 - N�o beber");
//		System.out.print("Sua escolha: ");
//		int drink = keyboard.nextInt();
//		if (drink == 1) {
//			System.out.println("\nVoc� se sente revigorado para seguir adiante!\n");
//			player.setHealth(combat.getInitialPlayerHealth());
//			System.out.printf("\nVoc� recuperou todos os seus pontos de vida. Sua vida atual � %d pontos\n",
//					player.getHealth());
//		} else if (drink == 2) {
//			System.out.println("\nVoc� fica receoso de beber algo produzido pelo inimigo.\n");
//		}
//		
//		// ** Change Enemy **
//		combat.chooseLeader();
//			System.out.println("INIMIGO MUDOU");
//
//		// Choose if attack leader
//		System.out.printf("%s, quer atacar o L�der?\n", player.getName());
//		System.out.println("1 - Atacar\n" + "2 - Esperar");
//		System.out.print("Sua escolha: ");
//		int attackLeader = keyboard.nextInt();
//		if (attackLeader == 1) {
//			
//			// COMBAT LOOP
//  		combat.combatLoop();
//
//		} else if (attackLeader == 2) {
//			System.out.println("Voc� decidiu fugir!");
//			System.exit(0);
//		}
//
//		System.out.println(texto);
//
//		if (player.getMotivation() == 1) {
//			System.out
//					.println("Voc� obteve sua vingan�a. Voc� se ajoelha e cai no choro, invadido por uma sensa��o de\n"
//							+ "al�vio e felicidade. Voc� se vingou, tudo que sempre quis, est� feito. Agora voc� pode\n"
//							+ "seguir sua vida.");
//		} else if (player.getMotivation() == 2) {
//			System.out.println(
//					"O �xtase em que voc� se encontra n�o cabe dentro de si. Voc� se ajoelha e grita de alegria.\n"
//							+ "A gl�ria o aguarda, voc� a conquistou.");
//		}
//
//		System.out.println(
//				"Voc� se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos voc�s saem em\n"
//						+ "dire��o � noite, retornando � cidade. Seu dever est� cumprido.");
//
		combat.getPlayer().setClassType(1);
		combat.getPlayer().changeWeapon();
		combat.getEnemy().getHealth();
		combat.combatLoop();
		
//		int attackDamage = combat.getPlayer().getAttackPoints() + combat.getPlayer().getWeaponDamage() + dice;
//		System.out.println(combat.getPlayer().getAttackPoints());
//		System.out.println(combat.getPlayer().getWeaponDamage());
//		System.out.println(dice);
//		System.out.println(attackDamage);
//		
//		
//		
//		System.out.println(generator.nextInt(21));
//		System.out.println(generator.nextInt(21));
//		System.out.println(generator.nextInt(21));
		
		keyboard.close();
		System.out.println("\n\n***** JOGO ENCERRADO *****");

	}

}
