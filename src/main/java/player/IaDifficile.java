package player;

import general.Case;
import waffle.Gaufre;
import waffle.CaseType;

/*TODO implement*/
public class IaDifficile extends Joueur {
	private int x, y;
	private Case choisi;
	
	
	public IaDifficile(Gaufre g){
		this.x =g.getHeight() ;
		this.y= g.getLength();
		this.g =g;
		
	}
	
	public IaDifficile() {
		
	}
	
	@Override
	public Case reflechir() {
		
            choisi = null;
            int valeurcoup = -2;            // On initialise à -2 puisque le minimum d'un coup est -1 (perdu), donc on sait qu'on trouvera supérieur
            Gaufre g2 = (Gaufre)g;
                
            for(int i=0;i<=this.x;i++){
		for(int j=0;j<=this.y;j++){                     // Cette double boucle sert à parcourir toutes les cases
                    if(g.getCase(i,j)!=CaseType.EATEN){         // et le if à ne s'occuper que de celles non-mangées
                        g2 = (Gaufre)g;
                        
                        Case coupcourant = new Case(i,j);
                        int valeurcoupcourant = minimax(g2,0,true);
                        
                        g2.manger(coupcourant);                 // Histoire d'envoyer à minimax une simulation de gauffre où le coup a été joué
                        
                        
                        if(valeurcoup < valeurcoupcourant)
                        {
                            valeurcoup = valeurcoupcourant;
                            choisi = coupcourant;
                        }
                        
                                    
			}
				
                    }
			
		}
                
                 
            return choisi;
	}
        
        /**
         * L'algorithme qui estime la "valeur" des coups à jouer (sommaire pour l'instant)
         * @param g : la gaufre "courante", celle qu'on analyse
         * @param tour : le tour auquel on en est : pour l'instant aucune utilité mais si on trouve le temps
         * ça servira à faire un algo qui prend en compte le nombre de coups pour gagner.
         * @param tourmax : true si c'est le tour de l'ordi qui est simulé, false si c'est un adversaire
         * @return la valeur du coup le plus avantageux
         */
        public int minimax(Gaufre g, int tour, boolean tourmax)
        {
            int bestvalue=0;
            
            if(g.getCase(0, 1) == CaseType.EATEN && g.getCase(1, 0) == CaseType.EATEN)  // Si les cases 0,1 et 1,0 sont mangées, le jeu est "fini" : il ne reste qu'un coup perdant à jouer.
            {
                if(tourmax) return -1;
                else return 1;
            }
            
            // Si c'est le tour de l'ordi qui est simulé
            if(tourmax)
            {
                bestvalue = -2;
                Gaufre g2 = g;
                for(int i=0;i<=this.x;i++){
			for(int j=0;j<=this.y;j++){                 // La même double boucle que dans réfléchir()
				if(g.getCase(i,j)!=CaseType.EATEN){
                                    
                                    g2 = g;
                                    g2.manger(new Case(i,j));
                                    bestvalue = Math.max(bestvalue, minimax(g2,tour+1,false));      // Récursivité toute bête, avec juste une alternance tour-ordi/tour-adversaire
                                    
                                    
				}
				
			}
			
		}
                return bestvalue;
            }
            else    // Si c'est le tour de l'adversaire qu'on gère, on cherche donc ici à minimiser plutôt qu'à maximiser
            {
                bestvalue = 2;
                Gaufre g2 = g;
                for(int i=0;i<=this.x;i++){
			for(int j=0;j<=this.y;j++){
				if(g.getCase(i,j)!=CaseType.EATEN){
                                    g2 = g;
                                    g2.manger(new Case(i,j));
                                    bestvalue = Math.min(bestvalue, minimax(g2,tour+1,false));
                                    
                                    
				}
				
			}
			
		}
                return bestvalue;
            }
        }
    
}
