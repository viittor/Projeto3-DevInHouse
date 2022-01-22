package game.br.com.viittor.main;

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
				combat.getGunman().easyLevel();
//				System.out.println(combat.getGunman().getAttack());
//				System.out.println(combat.getGunman().getDefense());
				combat.getAlchemist().easyLevel();
//				System.out.println(combat.getAlchemist().getAttack());
//				System.out.println(combat.getAlchemist().getDefense());
				combat.getLeader().easyLevel();
//				System.out.println(combat.getLeader().getAttack());
//				System.out.println(combat.getLeader().getDefense());
				System.out.println("\nNível Fácil Selecionado!\n");
			} else if (difficulty == 3) {
				combat.getPlayer().getHealer().hardLevel();
//				System.out.println(player.getHealer().getAttackPoints());
//				System.out.println(player.getHealer().getDefensePoints());
				combat.getPlayer().getWarrior().hardLevel();
//				System.out.println(player.getWarrior().getAttackPoints());
//				System.out.println(player.getWarrior().getDefensePoints());
				combat.getPlayer().getWizard().hardLevel();
//				System.out.println(player.getWizard().getAttackPoints());
//				System.out.println(player.getWizard().getDefensePoints());
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
		combat.getPlayer().setName(keyboard.next());

		// Set Player Gender
		combat.getPlayer().defineGender();
		combat.getPlayer().setSuffixGender();

		// Set ClassType
		combat.getPlayer().setClasstypeMethod();

		System.out.printf("Você escolheu ser %s!\n\n", combat.getPlayer().getNameClassType());

		// ****** aqui vai o código que define os pontos do personagem

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
		System.out.println("Escolha o que quer fazer agora: \n" + "1 - Desistir\n" + "2 - Seguir em frente");
		System.out.print("Sua escolha: ");
		int chooseWay = keyboard.nextInt();
		System.out.println("");

		if (chooseWay == 1) {
			System.out.println(
					"DESISTIR: o medo invade o seu coração e você sente que ainda não está à altura do desafio. Você se volta para a noite lá fora e corre em direção à segurança.");
			System.out.println("***** JOGO ENCERRADO *****");
			System.exit(0);// End game
		} else if (chooseWay == 2) {
			System.out.println(
					"SEGUIR: você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.");
		}
		System.out.println(texto);

		// Go through the door
		System.out.println(
				"Escolha como quer entrar: \n" + "1 - Andando cuidadosamente\n" + "2 - Correndo\n" + "3 - Saltando");
		System.out.print("Sua escolha: ");
		int firstDoor = keyboard.nextInt();
		System.out.println("");

		if (firstDoor == 1) {
			System.out.println(
					"ANDANDO: Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta. Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor. Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");
			int lostPoints = combat.getPlayer().getWarrior().getArrow().getDamage() + dice;
			combat.getPlayer().setHealth(combat.getPlayer().getHealth() - lostPoints);
			System.out.printf("VOCÊ PERDEU %d PONTOS DE VIDA! SUA VIDA ATUAL É DE %d PONTOS\n", lostPoints,
					combat.getPlayer().getHealth());
		} else if (firstDoor == 2) {
			System.out.println(
					"CORRENDO: Você respira fundo e desata a correr em direção à sala. Quando passa pela porta, sente que pisou em uma pedra solta, mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você, e quando se vira, vê várias flechas no chão. Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
		} else if (firstDoor == 3) {
			System.out.println(
					"SALTANDO: Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
		}

		System.out.println(texto);

		// ** Change Enemy **
		combat.chooseGunman();
		System.out.println("INIMIGO MUDOU");

		// COMBAT LOOP
		combat.combatLoop();

		System.out.println(texto);

		// Choose if take the armor
		System.out.printf("%s, quer pegar a armadura nova?\n", combat.getPlayer().getName());
		System.out.println("1 - Pegar armadura nova\n" + "2 - Manter minha armadura atual");
		System.out.print("Sua escolha: ");
		int armor = keyboard.nextInt();

		if (armor == 1) {
			System.out.println(
					"Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova, você se sente mais protegido para os desafios à sua frente.");
			combat.getPlayer().setDefensePoints(combat.getPlayer().getDefensePoints() + 5);
			System.out.printf("VOCÊ RECEBEU 5 PONTOS EXTRAS DE DEFESA. SUA DEFESA ATUAL É %d PONTOS.",
					combat.getPlayer().getDefensePoints());
		} else if (armor == 2) {
			System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
		}

		// ** Change Enemy **
		combat.chooseAlchemist();
		System.out.println("INIMIGO MUDOU");

		System.out.println(texto);

		// COMBAT LOOP
		combat.combatLoop();

		// Choose if drink potion
		System.out.printf("%s, quer beber a poção?\n", combat.getPlayer().getName());
		System.out.println("1 - Beber\n" + "2 - Não beber");
		System.out.print("Sua escolha: ");
		int drink = keyboard.nextInt();
		if (drink == 1) {
			System.out.println("Você se sente revigorado para seguir adiante!");
			combat.getPlayer().setHealth(combat.getInitialPlayerHealth());
			System.out.printf("Você recuperou todos os seus pontos de vida. Sua vida atual é %d pontos",
					combat.getPlayer().getHealth());
		} else if (drink == 2) {
			System.out.println("Você fica receoso de beber algo produzido pelo inimigo.");
		}

		// ** Change Enemy **
		combat.chooseLeader();
		System.out.println("INIMIGO MUDOU");

		// Choose if attack leader
		System.out.printf("%s, quer atacar o Líder?", combat.getPlayer().getName());
		System.out.println("1 - Atacar\n" + "2 - Esperar");
		System.out.print("Sua escolha: ");
		int attackLeader = keyboard.nextInt();
		if (attackLeader == 1) {
			// COMBAT LOOP
			combat.combatLoop();

		} else if (attackLeader == 2) {
			System.out.println("Você decidiu fugir!");
			System.exit(0);
		}

		System.out.println(texto);

		if (combat.getPlayer().getMotivation() == 1) {
			System.out
					.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
		} else if (combat.getPlayer().getMotivation() == 2) {
			System.out.println(
					"O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
		}

		System.out.println(
				"Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem em direção à noite, retornando à cidade. Seu dever está cumprido.");

//		combat.getPlayer().setClassType(2);
//		combat.getPlayer().changeWeapon();
//		combat.getEnemy().getHealth();
//		combat.combatLoop();
//		
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
