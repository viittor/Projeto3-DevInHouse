package game.br.com.viittor.main;

import java.util.Scanner;

import game.br.com.viittor.entities.combat.Combat;
import game.br.com.viittor.entities.combat.DiceTen;
import game.br.com.viittor.entities.enemies.Alchemist;
import game.br.com.viittor.entities.enemies.Gunman;
import game.br.com.viittor.entities.enemies.Leader;
import game.br.com.viittor.entities.motivation.Glory;
import game.br.com.viittor.entities.motivation.Revenge;
import game.br.com.viittor.entities.players.Player;

public class Main {

	public static void main(String[] args) {
		// Instance of Player
		Player player = new Player(null, 0, 0, 0);
		
		// Instance of Enemies
		Gunman gunman = new Gunman(10, 100, 10, 10);
		Alchemist alchemist = new Alchemist(10, 100, 10, 10);
		Leader leader = new Leader(20, 200, 10, 10);

		// Instance of Motivations
		Revenge revenge = new Revenge();
		Glory glory = new Glory();

		// Instance of Dices
		DiceTen diceTen = new DiceTen();

		// Instance of Combat
		Combat combat = new Combat();

		// Instance of Scanner
		Scanner keyboard = new Scanner(System.in);

		String texto = "========================================\n" + "TEXTO\n"
				+ "========================================";

		// START
		System.out.println("Seja bem vindo(a) a BATALHA FINAL!\n");

		// Set the difficulty parameters
		int difficulty = 0;
		while (difficulty < 1 || difficulty > 3) {
			// try {
			System.out.println("Escolha seu nível de dificuldade:\n" + "1 - Fácil\n" + "2 - Normal\n" + "3 - Difícil");
			System.out.print("Sua escolha: ");
			difficulty = keyboard.nextInt();
			if (difficulty == 1) {
				gunman.easyLevel();
				alchemist.easyLevel();
				leader.easyLevel();
				System.out.println("\nNível Fácil Selecionado!\n");
			} else if (difficulty == 3) {
				player.getHealer().hardLevel();
				player.getWarrior().hardLevel();
				player.getWizard().hardLevel();
				System.out.println("\nNível Difícil Selecionado!\n");
			} else if (difficulty == 2) {
				System.out.println("\nNível Normal Selecionado!\n");
			} else {
				System.out.println("\nOpção Inválida! Por favor insira o número correspondente a sua escolha: ");
			}
//			}catch(Exception e) {
//				System.out.println("\nOpção Inválida! Por favor Digite apenas números:");
//				difficulty = keyboard.nextInt();
//			}
		}

		//// Set Player Name
		System.out.print("Digite seu nome: ");
		player.setName(keyboard.next());

		// Set Player Gender
		player.defineGender();
		player.setSuffixGender();

		// Set ClassType
		player.setClasstypeMethod();

		System.out.printf("\n");

		System.out.printf("Você escolheu ser %s! \n\n", player.getNameClassType());

		// ****** aqui vai o código que define os pontos do personagem

		System.out.printf("Agora que você é um%s %s, escolha uma arma:\n", player.setSuffixUM(),
				player.getNameClassType());
		player.changeWeapon();

		System.out.println(texto);

		// ChangeMotivation
		player.changeMotivation();

		// Text of motivation
		if (player.getMotivation() == 1) {
			revenge.initialText();
		} else if (player.getMotivation() == 2) {
			glory.initialText();
		}

		System.out.println(texto);

		// Choose give up or move on
		System.out.println("Escolha o que quer fazer agora: \n" + "1 - Desistir\n" + "2 - Seguir em frente");
		System.out.print("Sua escolha: ");
		int chooseWay = keyboard.nextInt();

		if (chooseWay == 1) {
			System.out.println("\nDESISTIR: o medo invade o seu coração e você sente que ainda não está\n"
					+ "à altura do desafio. Você se volta para a noite lá fora e corre em direção\n" + "à segurança.");
			System.out.println("***** JOGO ENCERRADO *****");
			System.exit(0);// End game
		} else if (chooseWay == 2) {
			System.out.println("\nSEGUIR: você caminha, atento a todos os seus sentidos, por vários metros,\n"
					+ "até visualizar a frente uma fonte de luz, que você imagina ser a chama de\n"
					+ "uma tocha, vindo de dentro de uma porta aberta.\n");
		}
		System.out.println(texto);

		// Go through the door
		System.out.println(
				"Escolha como quer entrar: \n" + "1 - Andando cuidadosamente\n" + "2 - Correndo\n" + "3 - Saltando");
		System.out.print("Sua escolha: ");
		int firstDoor = keyboard.nextInt();

		if (firstDoor == 1) {
			System.out.println("\nANDANDO: Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando\n"
					+ "você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se\n"
					+ "tivesse pisado em uma pedra solta. Você ouve um ruído de mecanismos se movimentando,\n"
					+ "e uma escotilha se abre no teto atrás de você, no corredor. Flechas voam da\n"
					+ "escotilha em sua direção, e você salta para dentro da sala, porém uma delas te\n"
					+ "acerta na perna.\n");
			int lostPoints = 10 + diceTen.getDiceTen(0);
			player.setDefensePoints(player.getDefensePoints() - lostPoints);
			System.out.printf("VOCÊ PERDEU %d PONTOS DE VIDA! SUA VIDA ATUAL É DE %d PONTOS\n", lostPoints,
					player.getDefensePoints());
		} else if (firstDoor == 2) {
			System.out.println(
					"CORRENDO: Você respira fundo e desata a correr em direção à sala. Quando passa pela porta,\n"
							+ "sente que pisou em uma pedra solta, mas não dá muita importância e segue para dentro da sala,\n"
							+ "olhando ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons de flechas batendo\n"
							+ "na pedra atrás de você, e quando se vira, vê várias flechas no chão. Espiando pela porta, você\n"
							+ "entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por\n"
							+ "sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
		} else if (firstDoor == 3) {
			System.out.println("SALTANDO: Você se concentra e pula em direção à luz, saltando de antes da porta\n"
					+ "até o interior da sala.");
		}

		System.out.println(texto);

		// LOOP DE COMBATE

		System.out.println(texto);

		// Choose if take the armor
		System.out.printf("%s, quer pegar a armadura nova?\n", player.getName());
		System.out.println("1 - Pegar armadura nova\n" + "2 - Manter minha armadura atual");
		System.out.print("Sua escolha: ");
		int armor = keyboard.nextInt();

		if (armor == 1) {
			System.out
					.println("\nVocê resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas,\n"
							+ "que estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova,\n"
							+ "você se sente mais protegido para os desafios à sua frente.\n");
			player.setDefensePoints(player.getDefensePoints() + 5);
			System.out.printf("\nVOCÊ RECEBEU 5 PONTOS DE VIDA. SUA VIDA ATUAL É %d\n", player.getDefensePoints());
		} else if (armor == 2) {
			System.out.println("\nVocê decide que não precisa utilizar nada que venha das mãos do inimigo.\n");
		}

		System.out.println(texto);

		// LOOP DE COMBATE

		// Choose if drink potion
		System.out.printf("%s, quer beber a poção?\n", player.getName());
		System.out.println("1 - Beber\n" + "2 - Não beber");
		System.out.print("Sua escolha: ");
		int drink = keyboard.nextInt();
		if (drink == 1) {
			System.out.println("\nVocê se sente revigorado para seguir adiante!\n");
			player.setDefensePoints(player.getHealer().getDefensePoints());
			System.out.printf("\nVocê recuperou todos os seus pontos de defesa. Sua vida atual é %d pontos\n",
					player.getDefensePoints());
		} else if (drink == 2) {
			System.out.println("\nVocê fica receoso de beber algo produzido pelo inimigo.\n");
		}

		// Choose if attack leader
		System.out.printf("%s, quer atacar o Líder?\n", player.getName());
		System.out.println("1 - Atacar\n" + "2 - Esperar");
		System.out.print("Sua escolha: ");
		int attackLeader = keyboard.nextInt();
		if (attackLeader == 1) {
			// LOOP DE COMBATE
		} else if (attackLeader == 2) {
			System.out.println("Você decidiu fugir!");
			System.exit(0);
		}

		System.out.println(texto);

		if (player.getMotivation() == 1) {
			System.out
					.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de\n"
							+ "alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode\n"
							+ "seguir sua vida.");
		} else if (player.getMotivation() == 2) {
			System.out.println(
					"O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria.\n"
							+ "A glória o aguarda, você a conquistou.");
		}

		System.out.println(
				"Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem em\n"
						+ "direção à noite, retornando à cidade. Seu dever está cumprido.");

		combat.attackEnemy();
		keyboard.close();
		System.out.println("\n\n***** JOGO ENCERRADO *****");

	}

}
