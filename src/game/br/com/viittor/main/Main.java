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

		// START
		System.out.println("========================================");
		System.out.println("== Seja bem vindo(a) a BATALHA FINAL! ==");
		System.out.println("========================================\n");

		int start = 0;
		while (start != 1 || start != 2) {
			try {
				System.out.println("DESEJA INICIAR O JOGO?");
				System.out.println("1 - Jogar\n" + "2 - Sair");
				System.out.print("Sua escolha: ");
				start = keyboard.nextInt();
				System.out.println("");
				if (start == 1) {
					System.out.println("========================================");
					System.out.println("    ***   *****   ***   ****   *****");
					System.out.println("   *        *    *   *  *   *    *  ");
					System.out.println("    ***     *   * * * * * *      *  ");
					System.out.println("       *    *   *     * *  *     *  ");
					System.out.println("    ***     *   *     * *   *    *  ");
					System.out.println("========================================\n");
					break;
				} else if (start == 2) {
					System.out.println("***** JOGO ENCERRADO *****");
					System.exit(0);// End game
				}
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas 1 n�mero!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}

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

				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas 1 n�mero!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

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

		System.out.println("========================================");
		System.out.printf("Agora que voc� � um%s %s, escolha uma arma:\n", combat.getPlayer().setSuffixUM(),
				combat.getPlayer().getNameClassType());
		combat.getPlayer().changeWeapon();

		System.out.println("\n\n\n=========== RESUMO DO JOGADOR ==========");
		System.out.printf("  JOGADOR: %s%n", combat.getPlayer().getName());
		System.out.printf("  TOTAL DE VIDA: %d%n", combat.getPlayer().getHealth());
		System.out.printf("  CLASSE: %s (Defesa: %d pontos | Ataque: %d)%n", combat.getPlayer().getNameClassType(),
				combat.getPlayer().getDefensePoints(), combat.getPlayer().getAttackPoints());
		System.out.printf("  ARMA: %s (Ataque: %d)%n", combat.getPlayer().getNameWeapon(),
				combat.getPlayer().getWeaponDamage());
		System.out.println("========================================\n\n\n");

		System.out.println(
				"A noite se aproxima, a lua j� surge no c�u, estrelas v�o se acendendo, e sob a luz do crep�sculo voc� est� prestes a entrar na fase final da sua miss�o. Voc� olha para o portal � sua frente, e sabe que a partir desse ponto, sua vida mudar� para sempre.\r\n"
						+ "\r\n"
						+ "Mem�rias do caminho percorrido para chegar at� aqui invadem sua mente. Voc� se lembra de todos os inimigos j� derrotados para alcan�ar o covil do l�der maligno. Olha para seu equipamento de combate, j� danificado e desgastado depois de tantas lutas. Voc� est� a um passo de encerrar para sempre esse mal.\r\n"
						+ "\r\n"
						+ "Buscando uma inje��o de �nimo, voc� se for�a a lembrar o que te trouxe at� aqui.\r\n" + "");

		// ChangeMotivation
		combat.changeMotivation();

		// Text of motivation
		if (combat.getPlayer().getMotivation() == 1) {
			revenge.initialText();
		} else if (combat.getPlayer().getMotivation() == 2) {
			glory.initialText();
		}

		System.out.println(
				"Inspirado pelo motivo que te trouxe at� aqui, voc� sente seu cora��o ardendo em chamas, suas m�os formigarem em volta da sua arma. Voc� a segura com firmeza. Seu foco est� renovado. Voc� avan�a pelo portal.\r\n"
						+ "\r\n"
						+ "A escuridao te envolve. Uma ilumina��o muito fraca entra pelo portal �s suas costas. � sua frente, s� � poss�vel perceber que voc� se encontra em um corredor extenso. Voc� s� pode ir � frente, ou desistir.\r\n"
						+ "");

		// Choose give up or move on
		int chooseWay = 0;
		while (chooseWay != 1 || chooseWay != 2) {
			try {
				System.out.println("========================================");
				System.out.println("ESCOLHA O QUE QUER FAZER AGORA: \n" + "1 - Desistir\n" + "2 - Seguir em frente");
				System.out.print("Sua escolha: ");
				chooseWay = keyboard.nextInt();

				System.out.println("");

				if (chooseWay == 1) {
					System.out.println(
							"O medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio. Voc� se volta para a noite l� fora e corre em dire��o � seguran�a.");
					System.out.println("***** JOGO ENCERRADO *****");
					System.exit(0);// End game
				} else if (chooseWay == 2) {
					System.out.println(
							"Voc� caminha, atento a todos os seus sentidos, por v�rios metros, at� visualizar a frente uma fonte de luz, que voc� imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.");
					System.out.println(
							"Voc� se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, e pondera sobre como passar pela porta.\r\n"
									+ "");
					break;
				}
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas 1 n�mero!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				keyboard.next();
			}

		}

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
					System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.printf("VOC� PERDEU %d PONTOS DE VIDA! SUA VIDA ATUAL � DE %d PONTOS.\n", lostPoints,
							combat.getPlayer().getHealth());
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
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
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas 1 n�mero!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				keyboard.next();
			}
		}

		System.out.println(
				"Voc� se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma delas foi aquela pela qual voc� entrou, que estava aberta, e as outras tr�s est�o fechadas. A porta � sua frente � a maior das quatro, com inscri��es em seu entorno em uma l�ngua que voc� n�o sabe ler, mas reconhece como sendo a l�ngua antiga utilizada pelo inimigo. Voc� se aproxima da porta e percebe que ela est� trancada por duas fechaduras douradas, e voc� entende que precisar� primeiro derrotar o que estiver nas outras duas portas laterais, antes de conseguir enfrentar o l�der.\r\n"
						+ "\r\n" + "Voc� se dirige para a porta � direita.\r\n" + "\r\n"
						+ "Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada. Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra. Ao entrar, voc� se depara com uma sala espa�osa, com v�rios equipamentos de batalha pendurados nas paredes e dispostos em arm�rios e mesas. Voc� imagina que este seja o arsenal do inimigo, onde est�o guardados os equipamentos que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da regi�o.\r\n"
						+ "\r\n"
						+ "Enquanto seu olhar percorre a sala, voc� ouve a porta se fechando e gira rapidamente para olhar para tr�s. Ali, de p� entre voc� e a porta fechada, bloqueando o caminho do seu destino, est� um dos capit�es do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posi��o de combate. Ele avan�a em sua dire��o."
						+ "");

		// ** Change Enemy **
		combat.chooseGunman();

		// COMBAT LOOP
		combat.combatLoop();

		System.out.println(
				"Ap�s derrotar o Armeiro, voc� percebe que seus equipamentos est�o muito danificados, e olha em volta, encarando todas aquelas pe�as de armaduras resistentes e em �timo estado.\r\n"
						+ "");

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
					System.out.println("\n++++++++++++++++++++++++++++++++++++++++");
					System.out.printf("VOC� RECEBEU 5 PONTOS EXTRAS DE DEFESA. SUA DEFESA ATUAL � %d PONTOS.\n",
							combat.getPlayer().getDefensePoints());
					System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
					break;
				} else if (armor == 2) {
					System.out.println("Voc� decide que n�o precisa utilizar nada que venha das m�os do inimigo.\n");
					break;
				}
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas 1 n�mero!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}

		// ** Change Enemy **
		combat.chooseAlchemist();

		System.out.println(
				"Em uma mesa, voc� encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do l�der inimigo. Voc� pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

		System.out.println(
				"Voc� retorna � sala anterior e se dirige � porta da esquerda. Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada. Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra. Ao entrar, voc� se depara com uma sala parecida com a do arsenal, mas em vez de armaduras, existem v�rios potes e garrafas de vidro com conte�dos misteriosos e de cores diversas, e voc� entende que o capit�o que vive ali, realiza experimentos com diversos ingredientes, criando po��es utilizadas pelos soldados para aterrorizar a regi�o.\r\n"
						+ "No fundo da sala, olhando em sua dire��o, est� outro dos capit�es do inimigo. Um orque horrendo, de armadura, cajado em punho, em posi��o de combate. Ele avan�a em sua dire��o.\r\n"
						+ "");

		// COMBAT LOOP
		combat.combatLoop();

		System.out.println(
				"Ap�s derrotar o Alquimista, voc� olha em volta, tentando reconhecer alguma po��o do estoque do inimigo. Em uma mesa, voc� reconhece uma pequena garrafa de vidro contendo um l�quido levemente rosado, pega a garrafa e pondera se deve beber um gole.\n");

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
					System.out.println("\n++++++++++++++++++++++++++++++++++++++++");
					System.out.println("VOC� SE SENTE REVIGORADO PARA SEGUIR ADIANTE!");
					combat.getPlayer().setHealth(combat.getInitialPlayerHealth());
					System.out.printf("VOC� RECUPEROU TODOS OS SEUS PONTOS DE VIDA. SUA VIDA ATUAL � %d PONTOS\n",
							combat.getPlayer().getHealth());
					System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
					break;
				} else if (drink == 2) {
					System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Voc� fica receoso de beber algo produzido pelo inimigo.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					break;
				}
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas 1 n�mero!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}

		// ** Change Enemy **
		combat.chooseLeader();

		System.out.println(
				"Ao lado da porta, voc� v� uma chave dourada em cima de uma mesa, e sabe que aquela chave abre a outra fechadura da porta do l�der inimigo. Voc� pega a chave e guarda na pequena bolsa que leva presa ao cinto.\r\n"
						+ "\r\n"
						+ "De volta � sala das portas, voc� se dirige � porta final. Coloca as chaves nas fechaduras, e a porta se abre. Seu cora��o acelera, mem�rias de toda a sua vida passam pela sua mente, e voc� percebe que est� muito pr�ximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que voc� sabe que ir� se seguir, e adentra a porta.\r\n"
						+ "\r\n"
						+ "L� dentro, voc� v� o l�der sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados �s paredes.\r\n"
						+ "\r\n"
						+ "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de l�mina dupla.\r\n"
						+ "");

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
					System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Voc� decidiu fugir!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					System.exit(0);
				}

				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas 1 n�mero!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}

		if (combat.getPlayer().getMotivation() == 1) {
			System.out.println(
					"Voc� obteve sua vingan�a. Voc� se ajoelha e cai no choro, invadido por uma sensa��o de al�vio e felicidade. Voc� se vingou, tudo que sempre quis, est� feito. Agora voc� pode seguir sua vida.");
		} else if (combat.getPlayer().getMotivation() == 2) {
			System.out.println(
					"O �xtase em que voc� se encontra n�o cabe dentro de si. Voc� se ajoelha e grita de alegria. A gl�ria o aguarda, voc� a conquistou.");
		}

		System.out.println(
				"Voc� se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos voc�s saem em dire��o � noite, retornando � cidade. Seu dever est� cumprido.");

		System.out.println("");
		System.out.println("");
		System.out.println("*     *   ****    *      *    *           *    *    *       *");
		System.out.println(" *   *   *    *   *      *    *           *    *    * *     *");
		System.out.println("  * *   *      *  *      *    *           *    *    *  *    *");
		System.out.println("   *    *      *  *      *      *   *   *      *    *    *  *");
		System.out.println("   *     *    *    *    *        * * * *       *    *     * *");
		System.out.println("   *      ****      ****          *   *        *    *       *");
		System.out.println("");
		keyboard.close();
		System.out.println("\n\n***** JOGO ENCERRADO *****");

	}

}
