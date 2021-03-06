package player;

/**
 * permet de creer un type de joueur
 * @author amielco
 */
public class JouerFactory {
	
	public Joueur getJouer(String jouerType) {
		
		if(jouerType == "HUMAN") {
			return new Human();
		}
		
		else if(jouerType == "IA_FACILE") {
			return new IaFacile() ;
                        
		}
		
		else if(jouerType == "IA_MOYENNE") {
			return new IaMoyenne();
		}
		
		else if(jouerType == "IA_DIFFICILE") {
			return new IaDifficile();
		}
		
		return null;	
	}
}
