package player;

import general.Case;
import waffle.CaseType;
import waffle.Gaufre;

/*TODO implement*/
public class Human extends Joueur {
	private int x, y;
	private Case choisi;
        private Gaufre g;
	
        
        /* NON FONCTIONNEL */
	@Override
	public Case reflechir() {
		
		choisi = new Case(x,y);
		return choisi;
	}
        
        public boolean cliqueCase(Case c){
            
            boolean mangeable = (g.getCase(c.getY(), c.getX())== CaseType.FREE);
            
            if(mangeable)
            {
                this.choisi = c;
            }
            
            return mangeable;
        }
}
