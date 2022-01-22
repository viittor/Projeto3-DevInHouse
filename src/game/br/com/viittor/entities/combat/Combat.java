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

	// Instance of player
	Player player = new Player(null, 0, 0, 0, 1000);
	// Variable to control initialPlayerHealth
	int initialPlayerHealth = player.getHealth();

	// Instance of enemy
	Enemy enemy = new Enemy();
	Gunman gunman = new Gunman(10, 100, 10, 10);
	Alchemist alchemist = new Alchemist(10, 100, 10, 10);
	Leader leader = new Leader(10, 100, 10, 10);

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
		System.out.println("Escolha sua motiva��o para invadir a caverna do inimigo e derrot�-lo:\n" + "1 - Vingan�a\n"
				+ "2 - Gl�ria");
		System.out.print("Sua escolha: ");
		this.player.setMotivation(keyboard.nextInt());
		System.out.println("");
		if (this.player.getMotivation() == 1) {
			this.player.setNameMotivation("Vingan�a");
		} else if (this.player.getMotivation() == 2) {
			this.player.setNameMotivation("Gl�ria");
		}
		System.out.printf("Voc� escolheu %s\n\n", this.player.getNameMotivation());
	}

	// Finish enemy
	public void finishEnemy() {
		if (this.getPlayer().getHealth() <= 0) {
			if (this.player.getMotivation() == 1) {
				System.out.println(
						"Voc� n�o estava preparado para a for�a do inimigo. N�o foi poss�vel concluir sua vingan�a, e agora resta saber se algu�m se vingar� por voc�.");
				System.out.println("\n\n***** JOGO ENCERRADO *****");
				System.exit(0);
			} else if (this.getPlayer().getMotivation() == 2) {
				System.out.printf(
						"Voc� n�o estava preparado para a for�a do inimigo.A gl�ria que buscavas n�o ser� sua, e a cidade aguarda por s%s pr�xim%s her%s.",
						this.player.setSuffixUA(), this.player.getSuffix(), this.player.setSuffixNA());
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
		System.out.println(damageEnemy);
		System.out.println(this.enemy.getAttack());
		System.out.println(this.enemy.getWeapon());
		System.out.println(dice);
		if (dice == 1) {
			damageEnemy = 0;
			System.out.println("O inimigo errou o ataque! Voc� n�o sofreu nenhum dano.");
		} else if (dice == 20) {
			this.player.setHealth(this.player.getHealth() - damageEnemy);
			this.finishEnemy();
			System.out.printf(
					"O inimigo acertou um ataque cr�tico! Voc� sofreu %d de dano e agora\npossui %d pontos de vida.",
					damageEnemy, this.player.getHealth());
		} else {
			damageEnemy = damageEnemy - this.player.getDefensePoints();
			this.player.setHealth(this.player.getHealth() - damageEnemy);
			this.finishEnemy();
			System.out.printf("O inimigo atacou! Voc� sofreu %d de dano e agora possui %d pontos de vida.", damageEnemy,
					this.player.getHealth());
		}

	}

	// Finish Player
	public void finishPlayer() {
		if (this.enemy.getHealth() <= 0) {
			System.out.println("Voc� derrotou o inimigo");
		}

	}

	// Attack of Player
	public void attackPlayer() {
		Random generator = new Random();
		int dice = generator.nextInt(20) + 1;
		int damagePlayer = this.player.getAttackPoints() + this.player.getWeaponDamage() + dice;
		System.out.println("Voc� deseja atacar ou fugir?\n" + "1 - Atacaaar!!!\n" + "2 - Fugir!");
		System.out.print("Sua escolha: ");
		int fightOrRun = keyboard.nextInt();
		System.out.println("");

		if (fightOrRun == 1) {
			if (dice == 1) {
				damagePlayer = 0;
				System.out.println("Voc� errou o ataque! O inimigo n�o sofreu nenhum dano.");
			} else if (dice == 20) {
				this.enemy.setHealth(this.enemy.getHealth() - damagePlayer);
				System.out.printf(
						"Voc� acertou um ataque cr�tico! O inimigo sofreu %d de dano e agora\npossui %d pontos de vida.",
						damagePlayer, this.enemy.getHealth());
				this.finishPlayer();
			} else {
				damagePlayer = damagePlayer - this.enemy.getDefense();
				this.enemy.setHealth(this.enemy.getHealth() - damagePlayer);
				// **************************************
				System.out.printf("Voc� atacou %s e causou %d de dano no inimigo!", player.getWeaponComplement(),
						damagePlayer);
				this.finishPlayer();
			}

		} else if (fightOrRun == 2) {
			System.out.println(
					"Voc� n�o estava preparado para a for�a do inimigo, e decide fugir para que possa tentar novamente em uma pr�xima vez.");
			System.out.println("\n\n***** JOGO ENCERRADO *****");
			System.exit(0);
		}

	}

	// Combat Loop
	public void combatLoop() {
		while (player.getHealth() > 0 && enemy.getHealth() > 0) {
			this.attackEnemy();
			this.attackPlayer();
		}
	}

}
