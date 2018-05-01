/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;
import waffle.Waffle;
import general.Case;

/**
 *
 * @author amielco
 */
public abstract class Joueur{
    
    public Waffle g ;
    public int x,y;
    
    public void setGaufre(Waffle w){
        this.g = w;
        this.x = w.getHeight();
        this.y = w.getLength();
    }
    
        /**
     * analyse la situation et retourne la case à jouer (le coup du joueur)
     * @return la case correspondant au coup du joueur
     */
    public abstract Case reflechir();
    
}
