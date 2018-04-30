package player;
import general.Case;

public interface Jouer {
    
    /**
     * analyse la situation et retourne la case à jouer (le coup du joueur)
     * @return la case correspondant au coup du joueur
     */
	Case reflechir();
}
