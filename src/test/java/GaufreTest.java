import static org.junit.Assert.*;

import waffle.*;
import general.*;
import player.*;
import player.*;

import org.junit.Test;

public class GaufreTest {
        
	@Test
	public void creationOk() {
		Gaufre g= new Gaufre(5,5);
		assertTrue( g != null);
	}
	
	@Test
	public void poisonOk() {
		Gaufre g= new Gaufre(5,5);
		int i, j;
		for(i=0;i<5;i++){
			for(j=0;j<5; j++){
				if(i==0 && j==0){
					if(g.getCase(i,j)!=CaseType.POISON){
						fail("La premiere POISON case est fausse");
					}
					
				}
			}
		}
	}
	
	@Test
	public void casNul(){
		Gaufre g= new Gaufre(0,5);
		assertTrue("Probleme lorsqu'on iniatlise une gaufre de longueur 0", g!=null);
	}
	
	@Test
	public void caseMangee(){
		Gaufre g = new Gaufre(5,5);
		g.setCase(2,2, CaseType.EATEN);
		assertEquals("Probleme lors du get(i,j,c)/set(i,j,c) Case", g.getCase(2,2),CaseType.EATEN);
	}
	/**
	@Test
	public void mangerHorsGaufreRobuste(){
		Gaufre g = new Gaufre(5,5);
		g.setCase(-1,-5, CaseType.FREE);
		fail("On peut ecrire hors limite"); 
	}*/
        /**
	@Test
	public void lireHorsGaufreRobuste(){
		Gaufre g = new Gaufre(5,5);
		g.getCase(1,6);
		fail("On peut lire hors limite"); 
	}*/
        
        
	@Test
	public void testIterateurGaufre(){
		Gaufre g = new Gaufre(5,5);
		Iterator i= g.getIterator();
		assertTrue("Iterator est NULL", i !=null);
		
	}	
        
        @Test
        public void testMangerUneCase(){
		Gaufre g = new Gaufre(5,5);
                Case c = new Case(4,4);
                g.manger(c);
                assertEquals("La case n'est pas mangée", CaseType.EATEN, g.getCase(4,4));
	}
        
        @Test
        public void testMangerPlusieursCases(){
		Gaufre g = new Gaufre(5,5);
                Case c = new Case(3,3);
                int k=0;
                g.manger(c);
                if(g.getCase(3,3)!=CaseType.EATEN){
                    k++;
                }
                if(g.getCase(4,3)!=CaseType.EATEN){
                    k++;
                }
                if(g.getCase(3,4)!=CaseType.EATEN){
                    k++;
                }
                if(g.getCase(4,4)!=CaseType.EATEN){
                    k++;
                }
                assertEquals("On ne mange pas toutes les cases", k, 0);
	}
        
        @Test
        public void testMangerVides(){
		Gaufre g = new Gaufre(5,5);
                Case c = new Case(3,3);
                g.setCase(3,3,CaseType.EATEN);
                int k=0;
                g.manger(c);
                if(g.getCase(3,3)!=CaseType.EATEN){
                    k++;
                }
                if(g.getCase(4,3)!=CaseType.EATEN){
                    k++;
                }
                if(g.getCase(3,4)!=CaseType.EATEN){
                    k++;
                }
                if(g.getCase(4,4)!=CaseType.EATEN){
                    k++;
                }
                assertEquals("Manger une case vide fait n'importe quoi", k, 0);
	}
        @Test
        public void testMangerPoison(){
		Gaufre g = new Gaufre(5,5);
                Case c = new Case(0,0);
                int k=0, i, j;
                g.manger(c);
                
                for(i=0;i<5;i++){
                    for(j=0;j<5;j++){
                        if(g.getCase(i,j)!=CaseType.EATEN){
                            k++;
                        }
                    }
                }
                
                assertEquals("Manger le poison ne marche pas", k, 0);
                
	}
        
}