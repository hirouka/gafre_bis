package player;

import java.util.ArrayList;
import java.util.Random;

import general.Case;
import waffle.CaseType;
import waffle.Gaufre;


/*TODO implement*/
public class IaFacile extends Joueur {
	
	private int x, y;
	Gaufre g = new Gaufre(x,y);
	private Case choisi;
	public IaFacile(Gaufre g){
		this.x =g.getHeight() ;
		this.y= g.getLength();
		this.g =g;
		
	}
        
        	public IaFacile(){
		
	}
	
	@Override
	public Case reflechir() {
		int element = 0; 
		int i, j ;
		Case c; 
		Case choisi;	
		Random rand = new Random();
		ArrayList<Case> list = new ArrayList<Case>();
		for(i=0;i!=x;i++){
			for(j=0;j!=y;j++){
				choisi = new Case(i,j);
				if(g.getCase(i,j)==CaseType.EATEN){
					list.add(choisi);		
				}
				
			}
			
		}
		element = rand.nextInt(list.size());
		c = list.remove(element);
        return c;
		
	}
	
	

}
