package game.br.com.viittor.entities.combat;

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

	// Instance of dice
	Random generator = new Random();
	int dice = generator.nextInt(20) + 1;

	// Instance of player
	Player player = new Player(null, 0, 0, 0, 100);
	// Variable to control initialPlayerHealth
	int initialPlayerHealth = player.getHealth();

	// Instance of enemy
	Enemy enemy = new Enemy();
	Gunman gunman = new Gunman(10, 200, 10, 10);
	Alchemist alchemist = new Alchemist(10, 300, 10, 10);
	Leader leader = new Leader(20, 300, 10, 10);

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
		enemy.setAttack(alchemist.getAttack());
		System.out.println(enemy.getAttack());
		enemy.setHealth(alchemist.getHealth());
		System.out.println(enemy.getHealth());
		enemy.setDefense(alchemist.getDefense());
		System.out.println(enemy.getDefense());
		enemy.setWeapon(alchemist.getWeapon());
		System.out.println(enemy.getWeapon());
	}

	// GunMan
	public void chooseGunman() {
		enemy.setAttack(gunman.getAttack());
		enemy.setHealth(gunman.getHealth());
		enemy.setDefense(gunman.getDefense());
		enemy.setWeapon(gunman.getWeapon());
	}

	// Leader
	public void chooseLeader() {
		enemy.setAttack(leader.getAttack());
		enemy.setHealth(leader.getHealth());
		enemy.setDefense(leader.getDefense());
		enemy.setWeapon(leader.getWeapon());
	}

	// Attack of Enemy
	public void attackEnemy() {
		int damageEnemy = enemy.getAttack() + enemy.getWeapon() + dice;
		System.out.println(dice);
		if (dice == 1) {
			damageEnemy = 0;
			System.out.println("O inimigo errou o ataque! Você não sofreu nenhum dano.");
		} else if (dice == 20) {
			player.setHealth(player.getHealth() - damageEnemy);
			System.out.printf(
					"O inimigo acertou um ataque crítico! Você sofreu %d de dano e agora\npossui %d pontos de vida.",
					damageEnemy, player.getHealth());
			this.finishPlayer();
		} else {
			damageEnemy = damageEnemy - player.getDefensePoints();
			player.setHealth(player.getHealth() - damageEnemy);
			System.out.printf("O inimigo atacou! Você sofreu %d de dano e agora possui %d pontos de vida.", damageEnemy,
					player.getHealth());
			this.finishPlayer();
		}

	}
	
	//Finish enemy
	public void finishEnemy() {
		if (player.getHealth() <= 0) {
			if (player.getMotivation() == 1) {
				System.out.println(
						"Você não estava preparado para a força do inimigo. Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
				System.out.println("\n\n***** JOGO ENCERRADO *****");
				System.exit(0);
			} else if (player.getMotivation() == 2) {
				System.out.printf(
						"Você não estava preparado para a força do inimigo.A glória que buscavas não será sua, e a cidade aguarda por s%s próxim%s her%s.",
						player.setSuffixUA(), player.getSuffix(), player.setSuffixNA());
				System.out.println("\n\n***** JOGO ENCERRADO *****");
				System.exit(0);
			}
		}
	}
	
	//Finish Player
	public void finishPlayer() {
		if (enemy.getHealth() <= 0) {
			System.out.println("Você derrotou o inimigo");
			System.out.println("\n\n***** JOGO ENCERRADO *****");
			System.exit(0);
		}
		
	}

	// Attack of Player
	public void attackPlayer() {
		System.out.println(dice);
		System.out.println("Você deseja atacar ou fugir?\n" + "1 - Atacaaar!!!\n" + "2 - Fugir!");
		System.out.print("Sua escolha: ");
		int fightOrRun = keyboard.nextInt();

		if (fightOrRun == 1) {
			int damagePlayer = player.getAttackPoints() + player.getWeaponDamage() + dice;

			System.out.println(damagePlayer);
			if (dice == 1) {
				damagePlayer = 0;
				System.out.println(damagePlayer);
				System.out.println("Você errou o ataque! O inimigo não sofreu nenhum dano.");
			} else if (dice == 20) {
				System.out.println(damagePlayer);
				System.out.printf(
						"Você acertou um ataque crítico! O inimigo sofreu %d de dano e agora\npossui %d pontos de vida.",
						damagePlayer, enemy.getHealth());
				this.finishPlayer();
			} else {
				damagePlayer = damagePlayer - enemy.getDefense();
				System.out.println(damagePlayer);
				System.out.println(enemy.getHealth());
				enemy.setHealth(enemy.getHealth() - damagePlayer);
				// **************************************
				System.out.printf("Você atacou %se causou %d de dano no inimigo!", player.getWeaponComplement(),
						damagePlayer);
				this.finishPlayer();
			}

		} else if (fightOrRun == 2) {
			System.out.println(
					"Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
			System.out.println("\n\n***** JOGO ENCERRADO *****");
			System.exit(0);
		}

	}

	// Combat Loop
	public void combatLoop() {
		while (player.getHealth() > 0 || enemy.getHealth() > 0) {
			this.attackEnemy();
			this.finishEnemy();
			this.attackPlayer();
			this.finishPlayer();
		}
	}

}
