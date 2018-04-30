package graphique;

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;
import javafx.scene.input.MouseEvent;

import javafx.event.EventHandler;

import java.io.File;
import javax.print.DocFlavor.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;

import waffle.*;
import general.*;


public class Dessin extends Application {
   
	Gaufre ga;
	int lignes;
	int col;
	
  	public Dessin(Gaufre ga){
		this.ga = ga;
		lignes = ga.getLength();
		col = ga.getHeight();
  	}
	
	public void tracer (Canvas c, Pane p){
		
		GraphicsContext g = c.getGraphicsContext2D();
		
		 double width = c.getWidth();
		 double l = width / col;
		 double height = c.getHeight();
		 double h = height  / lignes;
		 
		 for(Iterator it_h = ga.getIterator(); it_h.hasNext_height();){
                    ga.setTo_length(0);
                    for(Iterator it_l = ga.getIterator(); it_l.hasNext_length();){
                        Case casCour = ga.getIndex();
                        if(ga.getCase() == CaseType.FREE){
                           g.setFill(Color.WHITE);
                           g.strokeRect(casCour.getX()*l, casCour.getY()*h, l, h);
                           g.fillRect(casCour.getX()*l, casCour.getY()*h, l, h);

                        }
                        else if(ga.getCase() == CaseType.POISON){
                          /* final String imageURI = new File("/home/n/ndourno/workspace/Gaufre/rsc/poison.png").toURI().toString(); 
                           final Image image = new Image(imageURI);
                           final ImageView imageView = new ImageView(image); 
                           imageView.setFitHeight(h);
                           imageView.setFitWidth(l);
                           p.getChildren().add(imageView); */
                        }
                       else if(ga.getCase()  == CaseType.EATEN){
                           g.setFill(Color.WHITE);
                           g.strokeRect(casCour.getX()*l, casCour.getY()*h, l, h);
                           g.fillRect(casCour.getX()*l, casCour.getY()*h, l, h);
                       }
                        it_l.next_length();
                    }
                    it_h.next_height();
		 }

	}
	
	
	@Override
    public void start(Stage primaryStage) throws Exception {
		
		Canvas c = new Canvas();
		Pane p = new Pane(c);
	    c.widthProperty().bind(p.widthProperty());
	    c.heightProperty().bind(p.heightProperty());
	    Scene s = new Scene(p, 800, 600);
	    
	    double width = c.getWidth();
		double l = width / col;
		double height = c.getHeight();
		double h = height  / lignes;
	   
        final Ecouteur_Souris ecouteurS = new Ecouteur_Souris(this, l, h);
        
        s.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	ecouteurS.handle(event);
            	
            }
        });
        
        primaryStage.setTitle("Gaufre");
        primaryStage.setScene(s);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          @Override
          public void handle(WindowEvent we) {
              System.exit(0);
          }
        }); 
        primaryStage.show();
        tracer(c,p);
	}
	
	
	public static void main(String [] args) {
		launch(args);
	}

}


