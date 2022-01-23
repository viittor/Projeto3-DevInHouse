package game.br.com.viittor.entities.combat;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import game.br.com.viittor.entities.enemies.Alchemist;
import game.br.com.viittor.entities.enemies.Enemy;
import game.br.com.viittor.entities.enemies.Gunman;
import game.br.com.viittor.entities.enemies.Leader;
import game.br.com.viittor.entities.players.Player;

public class Combat {
	// Instance of Scanner
	Scanner keyboard = new Scanner(System.in);

	// Instance of player
	Player player = new Player(null, 0, 0, 0, 700);
	// Variable to control initialPlayerHealth
	int initialPlayerHealth = player.getHealth();

	// Instance of enemy
	Enemy enemy = new Enemy();
	Gunman gunman = new Gunman(20, 150, 15, this.player.getWarrior().getSword().getDamage());
	Alchemist alchemist = new Alchemist(15, 100, 15, this.player.getHealer().getStaff().getDamage());
	Leader leader = new Leader(25, 200, 20, this.player.getWarrior().getAxe().getDamage());

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getInitialPlayerHealth() {
		return initialPlayerHealth;
	}

	public Gunman getGunman() {
		return gunman;
	}

	public void setGunman(Gunman gunman) {
		this.gunman = gunman;
	}

	public Alchemist getAlchemist() {
		return alchemist;
	}

	public void setAlchemist(Alchemist alchemist) {
		this.alchemist = alchemist;
	}

	public Leader getLeader() {
		return leader;
	}

	public void setLeader(Leader leader) {
		this.leader = leader;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	// ** Change Enemy **
	// alchemist
	public void chooseAlchemist() {
		this.enemy.setAttack(this.alchemist.getAttack());
//		System.out.println(enemy.getAttack());
		this.enemy.setHealth(this.alchemist.getHealth());
//		System.out.println(enemy.getHealth());
		this.enemy.setDefense(this.alchemist.getDefense());
//		System.out.println(enemy.getDefense());
		this.enemy.setWeapon(this.alchemist.getWeapon());
//		System.out.println(enemy.getWeapon());
	}

	// GunMan
	public void chooseGunman() {
		this.enemy.setAttack(this.gunman.getAttack());
		this.enemy.setHealth(this.gunman.getHealth());
		this.enemy.setDefense(this.gunman.getDefense());
		this.enemy.setWeapon(this.gunman.getWeapon());
	}

	// Leader
	public void chooseLeader() {
		this.enemy.setAttack(this.leader.getAttack());
		this.enemy.setHealth(this.leader.getHealth());
		this.enemy.setDefense(this.leader.getDefense());
		this.enemy.setWeapon(this.leader.getWeapon());
	}

	// Set Motivation
	public void changeMotivation() {
		this.player.setMotivation(0);
		while (this.player.getMotivation() != 1 || this.player.getMotivation() != 2) {
			try {
				System.out.println("========================================");
				System.out.println("ESCOLHA SUA MOTIVA��O PARA INVADIR A CAVERNA DO INIMIGO E DERROT�-LO:\n"
						+ "1 - Vingan�a\n" + "2 - Gl�ria");
				System.out.print("Sua escolha: ");
				this.player.setMotivation(keyboard.nextInt());
				System.out.println("");
				if (this.player.getMotivation() == 1) {
					this.player.setNameMotivation("Vingan�a");
					System.out.println("========================================");
					System.out.printf("Voc� escolheu %s%n", this.player.getNameMotivation());
					System.out.println("========================================\n");
					break;
				} else if (this.player.getMotivation() == 2) {
					this.player.setNameMotivation("Gl�ria");
					System.out.println("========================================");
					System.out.printf("Voc� escolheu %s%n", this.player.getNameMotivation());
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
	}

	// Finish enemy
	public void finishEnemy() {
		if (this.getPlayer().getHealth() <= 0) {
			if (this.player.getMotivation() == 1) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println(
						"Voc� n�o estava preparado para a for�a do inimigo. N�o foi poss�vel concluir sua vingan�a, e agora resta saber se algu�m se vingar� por voc�.");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				System.out.println("\n\n***** JOGO ENCERRADO *****");
				System.exit(0);
			} else if (this.getPlayer().getMotivation() == 2) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.printf(
						"Voc� n�o estava preparado para a for�a do inimigo.A gl�ria que buscavas n�o ser� sua, e a cidade aguarda por s%s pr�xim%s her%s.",
						this.player.setSuffixUA(), this.player.getSuffix(), this.player.setSuffixNA());
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				System.out.println("\n\n***** JOGO ENCERRADO *****");
				System.exit(0);
			}
		}
	}

	// Attack of Enemy
	public void attackEnemy() {
		Random generator = new Random();
		int dice = generator.nextInt(20) + 1;
		int damageEnemy = this.enemy.getAttack() + this.enemy.getWeapon() + dice;
		if (dice == 1) {
			damageEnemy = 0;
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			System.out.println("O inimigo errou o ataque! Voc� n�o sofreu nenhum dano.");
			System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
		} else if (dice == 20) {
			this.player.setHealth(this.player.getHealth() - damageEnemy);
			this.finishEnemy();
			if (this.player.getHealth() < 0) {
				this.player.setHealth(0);
			}
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.printf(
					"O inimigo acertou um ataque cr�tico! Voc� sofreu %d de dano e agora\npossui %d pontos de vida.\n",
					damageEnemy, this.player.getHealth());
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		} else {
			damageEnemy = damageEnemy - this.player.getDefensePoints();
			this.player.setHealth(this.player.getHealth() - damageEnemy);
			this.finishEnemy();
			if (this.player.getHealth() < 0) {
				this.player.setHealth(0);
			}
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.printf("O INIMIGO ATACOU! VOC� SOFREU %d DE DANO E AGORA POSSUI %d PONTOS DE VIDA.\n",
					damageEnemy, this.player.getHealth());
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		}

	}

	// Finish Player
	public void finishPlayer() {
		if (this.enemy.getHealth() <= 0) {
			System.out.println("========================================");
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			System.out.println("VOC� DERROTOU O INIMIGO!");
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			System.out.println("========================================\n");
		}

	}

	// Attack of Player
	public void attackPlayer() {
		int fightOrRun = 0;
		while (fightOrRun != 1 || fightOrRun != 2) {
			Random generator = new Random();
			int dice = generator.nextInt(20) + 1;
			int damagePlayer = this.player.getAttackPoints() + this.player.getWeaponDamage() + dice;
			try {
				System.out.println("========================================");
				System.out.println("VOC� DESEJA ATACAR OU FUGIR?\n" + "1 - Atacaaar!!!\n" + "2 - Fugir!");
				System.out.print("Sua escolha: ");
				fightOrRun = keyboard.nextInt();
				System.out.println("");
				if (fightOrRun == 1) {
					if (dice == 1) {
						damagePlayer = 0;
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("VOC� ERROU O ATAQUE! O INIMIGO N�O SOFREU NENHUM DANO.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					} else if (dice == 20) {
						this.enemy.setHealth(this.enemy.getHealth() - damagePlayer);
						if (this.enemy.getHealth() < 0) {
							this.enemy.setHealth(0);
						}
						System.out.println("++++++++++++++++++++++++++++++++++++++++");
						System.out.printf(
								"VOC� ACERTOU UM ATAQUE CR�TICO! O INIMIGO SOFREU %d DE DANO E AGORA POSSUI %d PONTOS DE VIDA.\n",
								damagePlayer, this.enemy.getHealth());
						System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
						this.finishPlayer();
					} else {
						damagePlayer = damagePlayer - this.enemy.getDefense();
						this.enemy.setHealth(this.enemy.getHealth() - damagePlayer);
						if (this.enemy.getHealth() < 0) {
							this.enemy.setHealth(0);
						}
						System.out.println("++++++++++++++++++++++++++++++++++++++++");
						System.out.printf(
								"VOC� ATACOU %s E CAUSOU %d DE DANO NO INIMIGO! ELE POSSUI %d PONTOS DE VIDA\n",
								player.getWeaponComplement().toUpperCase(), damagePlayer, this.enemy.getHealth());
						System.out.println("++++++++++++++++++++++++++++++++++++++++\n");
						this.finishPlayer();
						break;
					}
				} else if (fightOrRun == 2) {
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println(
							"Voc� n�o estava preparado para a for�a do inimigo, e decide fugir para que possa tentar novamente em uma pr�xima vez.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
					System.out.println("\n\n***** JOGO ENCERRADO *****");
					System.exit(0);
				}
			} catch (InputMismatchException exception) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("Op��o Inv�lida! Por favor digite apenas n�meros!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				keyboard.next();
			}
		}

	}

	// Combat Loop
	public void combatLoop() {
		System.out.println("\n========================================");
		System.out.println("  ***   ***   *   *  ****    ***   *****");
		System.out.println(" *     *   * * * * * *   *  *   *    *  ");
		System.out.println(" *     *   * *  *  * ****  * * * *   *  ");
		System.out.println(" *     *   * *     * *   * *     *   *  ");
		System.out.println("  * *   ***  *     * ****  *     *   *  ");
		System.out.println("========================================\n");
		while (player.getHealth() > 0 && enemy.getHealth() > 0) {

			this.attackEnemy();
			this.attackPlayer();
		}
	}

}
