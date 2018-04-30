package player;

import general.Case;

/*TODO implement*/
public class Human implements Jouer {
	private int x, y;
	private Case choisi;
	
	@Override
	public Case reflechir() {
		
		choisi = new Case(x,y);
		return choisi;
	}
}
