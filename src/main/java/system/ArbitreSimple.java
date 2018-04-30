/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;
import waffle.Gaufre;

/**
 *
 * @author amielco
 * implementation triviale concrete d'un arbitre
 */
public class ArbitreSimple extends Arbitre {
    public ArbitreSimple(){
        super();
    }
    
    public void creerGaufre(int L, int l){
        this.plateau = new Gaufre(l,L);
    }
}
