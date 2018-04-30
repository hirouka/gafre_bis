package player;

/**
 * permet de creer un type de joueur
 * @author amielco
 */
public class JouerFactory {
	
	public Jouer getJouer(String jouerType) {
		
		if(jouerType == "HUMAN") {
			return new Human();
		}
		
		else if(jouerType == "IA_FACILE") {
			return new IaFacile() ; //TODO remplacer par IA facile
                        
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
