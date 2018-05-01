package player;

import general.Case;
import waffle.CaseType;
import waffle.Gaufre;

/*TODO implement*/
public class IaMoyenne implements Jouer {
    private int x, y;
    private Case choisi;
        Gaufre g = new Gaufre(x,y);
    
    @Override
    public Case reflechir() {
        Case poison= new Case(0,0);
            Case c2 = new Case(1,0);
        Case c1 = new Case(0,1);
            Case c = null;    
            int element = 0; 
        int i, j ;
            if((g.getCase(0,1)==CaseType.EATEN)||(g.getCase(1,0)==CaseType.EATEN)){
                 if((g.getCase(0,1)==CaseType.EATEN) && (g.getCase(1,0)==CaseType.EATEN)){
                    c=poison;
                 }else if((g.getCase(0,1)==CaseType.EATEN)) {
                      c = c2  ;  
                     }else{
                         c=c1;
                    }           
                
        }else{
                 if((g.getCase(0,2)==CaseType.EATEN)&&(g.getCase(2,0)==CaseType.EATEN)&&(g.getCase(1,1)==CaseType.EATEN)){
                     c=c2;
                 }else {
                     IaFacile iaf = new IaFacile(g,x,y);
                     c = iaf.reflechir();
                     while((c.equals(c2)) || (c.equals(c1)) || (c.equals(poison))){
                c = iaf.reflechir();
                     }
                    
                    }
                     
                 }
            return c;
    
    }
