import static org.junit.Assert.*;
import waffle.*;

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
}