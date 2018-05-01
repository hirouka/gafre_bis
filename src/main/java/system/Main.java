/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

/**
 *
 * @author amielco
 */
public class Main {
    public static void main (String args[]){
           Arbitre referee = new ArbitreSimple(3,3,"IA_MOYENNE","IA_MOYENNE");
           referee.jouer();
    }
}
