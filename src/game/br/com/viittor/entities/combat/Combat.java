package game.br.com.viittor.entities.combat;

import game.br.com.viittor.entities.enemies.Enemy;
import game.br.com.viittor.entities.players.Player;

public class Combat {
	// Instance of dice
	DiceTwenty diceTwenty = new DiceTwenty();
	
	// Instance of player
	Player player = new Player();
	
	//Instance of enemy
	Enemy enemy = new Enemy();

	// Attack Enemy
	public void attackEnemy() {
		int attackDamage = enemy.getDamage() + enemy.getWeapon() + diceTwenty.getDiceTwenty();

		if (diceTwenty.getDiceTwenty() == 1) {
			attackDamage = 0;
			System.out.println(attackDamage);
			System.out.println("O inimigo errou o ataque! Você não sofreu nenhum dano.");
		} else if (diceTwenty.getDiceTwenty() == 20) {
			attackDamage = 100;
			System.out.println(attackDamage);
			System.out.printf(
					"O inimigo acertou um ataque crítico! Você sofreu %d de dano e agora\npossui X pontos de vida.",
					attackDamage);
		} else {
			System.out.println(attackDamage);
			System.out.printf("O inimigo atacou! Você sofreu %d de dano e agora possui Y pontos de vida.",
					attackDamage);
		}
		System.out.println(attackDamage);
		System.out.printf("Rolagem: %d", diceTwenty.getDiceTwenty());
	}
	
	// Attack Player
//	public void attackPlayer() {
//		int attackDamage = gunman.getDamage() + gunman.getSword().getDamage() + diceTwenty.getDiceTwenty();
//
//		if (diceTwenty.getDiceTwenty() == 1) {
//			attackDamage = 0;
//			System.out.println(attackDamage);
//			System.out.println("O inimigo errou o ataque! Você não sofreu nenhum dano.");
//		} else if (diceTwenty.getDiceTwenty() == 20) {
//			attackDamage = 100;
//			System.out.println(attackDamage);
//			System.out.printf(
//					"O inimigo acertou um ataque crítico! Você sofreu %d de dano e agora\npossui X pontos de vida.",
//					attackDamage);
//		} else {
//			System.out.println(attackDamage);
//			System.out.printf("O inimigo atacou! Você sofreu %d de dano e agora possui Y pontos de vida.",
//					attackDamage);
//		}
//		System.out.println(attackDamage);
//		System.out.printf("Rolagem: %d", diceTwenty.getDiceTwenty());
//	}

}
