package system;

/**
* Un arbitre gere le systeme de jeu
*/ 

import waffle.*;
import general.*;
import player.*;

public abstract class Arbitre {

	protected Waffle plateau ;
	protected Joueur[] listeJoueur;
	protected boolean termine ;
	protected int joueurCourant;


 /**
* cree un jeu par defaut
*
*/
public Arbitre(){
	creerGaufre(4,5);
        this.listeJoueur = new Joueur[2];
	creerJoueur(0, "IA_FACILE");
	creerJoueur(1, "IA_FACILE");
        this.listeJoueur[0].setGaufre(this.plateau);
        this.listeJoueur[1].setGaufre(this.plateau);
	this.termine = false ;
	this.joueurCourant = 0;
}
        
/**
* cree un jeu
* @param 	L la longueur du plateau
* 			l la largeur du plateau
*			natureJ1 la nature du premier joueur
*			natureJ2 la nature 
*/
public Arbitre(int L, int l, String natureJ1, String natureJ2){
	creerGaufre(L,l);
	creerJoueur(0, natureJ1);
	creerJoueur(1, natureJ2);
	this.termine = false ;
	this.joueurCourant = 0;
}

public void creerJoueur(int num, String nature){
	JouerFactory f1 = new JouerFactory();

	Joueur p1 = f1.getJouer(nature);

	this.listeJoueur[num] = p1;
}

/**
 * cree la gaufre.
 * @param L la longueur de la gaufre
 * @param l la largeur de la gaufre
 */
public void creerGaufre(int L, int l){
}

/**
* Met fin au tour du joueur et passe au suivant
*/
 
public void finDeTour(){
	if(this.joueurCourant==0){
		joueurCourant =1;
	}else{
		joueurCourant = 0;
	}
}

/**
* Joue au jeu
*/

public void jouer(){
	while(this.termine!=true){

		Case caseJouee = listeJoueur[joueurCourant].reflechir();
		this.plateau.manger(caseJouee);
		finDeTour();
		this.termine=this.plateau.isWon(caseJouee);
           
	}
        System.out.println("joueur gagnant = "+this.joueurCourant);
}

}