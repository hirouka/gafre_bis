import static org.junit.Assert.*;

import waffle.*;
import general.*;
import player.*;
import system.*;
import graphque.*;

import org.junit.Test;

public class IaFacile {

  public void testCreationIa(){
  
    Gaufre g = new Gaufre(5,5);
    IaFacile ia = new IaFacile(g);
    
    assertTrue("On ne peut pas creer d'IA facile", ia!=null);
  
  }
  
  public void testCreationListe(){
  
    Gaufre g = new Gaufre(5,5);
    IaFacile ia = new IaFacile(g);
    
    assertTrue("On ne peut pas creer de liste de cases comestibles", ia.listeCaseComestible!=null);
  
  }
  
  public void testReflechir(){
  
    Gaufre g = new Gaufre(5,5);
    IaFacile ia = new IaFacile(g);
    
    Case c = ia.reflechir();
    
    
    assertTrue("On ne peut choisir de case", c!=null);
  
  }
  
  public void testReflechir2(){
  
    Gaufre g = new Gaufre(5,5);
    IaFacile ia = new IaFacile(g);
    Case c1 = new Case(0,1);
    int i;
    int k=0;
    
    ia.g.manger(c1); 
    
    for(i=0;i<20;i++){ 
      c1 = ia.reflechr();
      if(c1.getX()!=0 || c1.getY()==0){
        k++;
      }
    } 
    assertTrue("Reflechir renvoie des cases incorrectes", k==0);
  
  }
  
  




}















