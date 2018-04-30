package player;

import java.util.ArrayList;
import java.util.Random;

import general.Case;
import waffle.CaseType;
import waffle.Waffle;
import waffle.Gaufre;


/*TODO implement*/
public class IaFacile extends Joueur {
	
	private Case choisi;
        ArrayList<Case> listeCaseCommestible ;
                
	/*public IaFacile(Gaufre g){
		this.x =g.getHeight() ;
		this.y= g.getLength();
		this.g =g;
		
	}*/
        
        public IaFacile(){}
                
       public void creerListe(){
           ArrayList<Case> list = new ArrayList<Case>();
		for(int i=0;i<=this.x;i++){
			for(int j=0;j<=this.y;j++){
				if(((Gaufre)this.g).getCase(i,j)!=CaseType.EATEN){
					list.add(new Case(i,j));		
				}
				
			}
			
		}
           this.listeCaseCommestible = list;
       }	
	@Override
	public Case reflechir() {
                this.creerListe();
		Case choix = new Case(1,1); 
		Random rand = new Random();
                //System.out.println("taille de la liste = "+this.listeCaseCommestible.size());
		int element = rand.nextInt(this.listeCaseCommestible.size());
		choix = this.listeCaseCommestible.remove(element);
        return choix;
		
	}
	
	

}
