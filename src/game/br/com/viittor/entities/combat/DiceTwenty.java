package game.br.com.viittor.entities.combat;

import java.util.Random;

public class DiceTwenty {
	Random random = new Random();
	int diceTwenty = random.nextInt(20) + 1;
	
	public int getDiceTwenty() {
		return diceTwenty;
	}	

}
