package game.br.com.viittor.entities.dices;

import java.util.Random;

public class DiceTwenty {
	Random random = new Random();
	
	public int getDiceTwenty(int diceTwenty) {
		diceTwenty = random.nextInt(20) + 1;
		return diceTwenty;
	}	

}
