package GUI;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Ecouteur_Souris implements EventHandler<MouseEvent> {
	Dessin d; double x,y;
	//Gaufre ga;
	
	public Ecouteur_Souris(Dessin d, double x, double y){
		this.d = d;
		this.x = x;
		this.y = y;
	}
	
	 @Override
	 public void handle(MouseEvent event) {
	     if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
	    	
	    	int a = (int) (event.getX() / x);
	    	int b = (int) (event.getY() / y);
	    			
	    	System.out.println(a+" "+b);
	    	
	    	//Case c = new Case (x, y);
	    			
	        //ga.manger(c);
	    			
	    }
	 }

}
