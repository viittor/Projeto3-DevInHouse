package game.br.com.viittor.entities.dices;

import java.util.Random;

public class DiceTen {
	Random random = new Random();
	
	public int getDiceTen(int diceTen) {
		diceTen = random.nextInt(10) + 1;
		return diceTen;
	}
}
