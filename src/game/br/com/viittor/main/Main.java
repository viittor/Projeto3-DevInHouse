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
				System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
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

				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

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

		System.out.println("========================================");
		System.out.printf("Agora que você é um%s %s, escolha uma arma:\n", combat.getPlayer().setSuffixUM(),
				combat.getPlayer().getNameClassType());
		combat.getPlayer().changeWeapon();

		System.out.println("\n=========== RESUMO DO JOGADOR ==========");
		System.out.printf("  JOGADOR: %s%n", combat.getPlayer().getName());
		System.out.printf("  TOTAL DE VIDA: %d%n", combat.getPlayer().getHealth());
		System.out.printf("  CLASSE: %s (Defesa: %d pontos | Ataque: %d)%n", combat.getPlayer().getNameClassType(),
				combat.getPlayer().getDefensePoints(), combat.getPlayer().getAttackPoints());
		System.out.printf("  ARMA: %s (Ataque: %d)%n", combat.getPlayer().getNameWeapon(),
				combat.getPlayer().getWeaponDamage());
		System.out.println("========================================\n");

		System.out.println(
				"A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão. Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.\r\n"
						+ "\r\n"
						+ "Memórias do caminho percorrido para chegar até aqui invadem sua mente. Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno. Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas. Você está a um passo de encerrar para sempre esse mal.\r\n"
						+ "\r\n"
						+ "Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.\r\n" + "");

		// ChangeMotivation
		combat.changeMotivation();

		// Text of motivation
		if (combat.getPlayer().getMotivation() == 1) {
			revenge.initialText();
		} else if (combat.getPlayer().getMotivation() == 2) {
			glory.initialText();
		}

		System.out.println(
				"Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado. Você avança pelo portal.\r\n"
						+ "\r\n"
						+ "A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua frente, só é possível perceber que você se encontra em um corredor extenso. Você só pode ir à frente, ou desistir.\r\n"
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
							"O medo invade o seu coração e você sente que ainda não está à altura do desafio. Você se volta para a noite lá fora e corre em direção à segurança.");
					System.out.println("***** JOGO ENCERRADO *****");
					System.exit(0);// End game
				} else if (chooseWay == 2) {
					System.out.println(
							"Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.");
					System.out.println(
							"Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, e pondera sobre como passar pela porta.\r\n"
									+ "");
					break;
				}
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
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
							"Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta. Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor. Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");
					int lostPoints = combat.getPlayer().getWarrior().getArrow().getDamage() + dice;
					combat.getPlayer().setHealth(combat.getPlayer().getHealth() - lostPoints);
					System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.printf("VOCÊ PERDEU %d PONTOS DE VIDA! SUA VIDA ATUAL É DE %d PONTOS.\n", lostPoints,
							combat.getPlayer().getHealth());
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
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
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				keyboard.next();
			}
		}

		System.out.println(
				"Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas. A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler, mas reconhece como sendo a língua antiga utilizada pelo inimigo. Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas, e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais, antes de conseguir enfrentar o líder.\r\n"
						+ "\r\n" + "Você se dirige para a porta à direita.\r\n" + "\r\n"
						+ "Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara com uma sala espaçosa, com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas. Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da região.\r\n"
						+ "\r\n"
						+ "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate. Ele avança em sua direção."
						+ "");

		// ** Change Enemy **
		combat.chooseGunman();

		// COMBAT LOOP
		combat.combatLoop();

		System.out.println(
				"Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.\r\n"
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
							"Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova, você se sente mais protegido para os desafios à sua frente.");
					combat.getPlayer().setDefensePoints(combat.getPlayer().getDefensePoints() + 5);
					System.out.println("\n++++++++++++++++++++++++++++++++++++++++");
					System.out.printf("VOCÊ RECEBEU 5 PONTOS EXTRAS DE DEFESA. SUA DEFESA ATUAL É %d PONTOS.\n",
							combat.getPlayer().getDefensePoints());
					System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
					break;
				} else if (armor == 2) {
					System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.\n");
					break;
				}
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas 1 número!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Opção Inválida! Por favor digite apenas números!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}

		// ** Change Enemy **
		combat.chooseAlchemist();

		System.out.println(
				"Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

		System.out.println(
				"Você retorna à sala anterior e se dirige à porta da esquerda. Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras, existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas, e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes, criando poções utilizadas pelos soldados para aterrorizar a região.\r\n"
						+ "No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.\r\n"
						+ "");

		// COMBAT LOOP
		combat.combatLoop();

		System.out.println(
				"Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo. Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado, pega a garrafa e pondera se deve beber um gole.\n");

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
					System.out.println("\n++++++++++++++++++++++++++++++++++++++++");
					System.out.println("VOCÊ SE SENTE REVIGORADO PARA SEGUIR ADIANTE!");
					combat.getPlayer().setHealth(combat.getInitialPlayerHealth());
					System.out.printf("VOCÊ RECUPEROU TODOS OS SEUS PONTOS DE VIDA. SUA VIDA ATUAL É %d PONTOS\n",
							combat.getPlayer().getHealth());
					System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
					break;
				} else if (drink == 2) {
					System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Você fica receoso de beber algo produzido pelo inimigo.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
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

		// ** Change Enemy **
		combat.chooseLeader();

		System.out.println(
				"Ao lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave abre a outra fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.\r\n"
						+ "\r\n"
						+ "De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a porta se abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você percebe que está muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.\r\n"
						+ "\r\n"
						+ "Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.\r\n"
						+ "\r\n"
						+ "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.\r\n"
						+ "");

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
					System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("Você decidiu fugir!");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					System.exit(0);
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

		if (combat.getPlayer().getMotivation() == 1) {
			System.out.println(
					"Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
		} else if (combat.getPlayer().getMotivation() == 2) {
			System.out.println(
					"O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
		}

		System.out.println(
				"Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem em direção à noite, retornando à cidade. Seu dever está cumprido.");

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
