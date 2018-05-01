import static org.junit.Assert.*;

import waffle.*;
import general.*;
import player.*;
import system.*;
import graphque.*;

import org.junit.Test;

public class IaFacile {

  publc void testCreationIa(){
  
    Gaufre g = new Gaufre(5,5);
    IaFacile ia = new IaFacile(g);
    
    assertTrue("On ne peut pas creer d'IA facile", ia!=null);
  
  }
  
  publc void testCreationListe(){
  
    Gaufre g = new Gaufre(5,5);
    IaFacile ia = new IaFacile(g);
    
    assertTrue("On ne peut pas creer de liste de cases comestibles", ia.listeCaseComestible!=null);
  
  }
  
  publc void testCreationListe(){
  
    Gaufre g = new Gaufre(5,5);
    IaFacile ia = new IaFacile(g);
    
    assertTrue("On ne peut pas creer de liste de cases comestibles", ia.listeCaseComestible!=null);
  
  }
  
  




}















