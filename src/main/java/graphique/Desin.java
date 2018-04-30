package GUI;

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


public class Dessin extends Application {
   
	Gaufre ga;
	int lignes;
	int col;
	
  	public Dessin(Gaufre ga){
		this.ga = ga;
		lignes = ga.getLenght();
		col = ga.getHeight();
  	}
	
	public void tracer (Canvas c, Pane p){
		
		GraphicsContext g = c.getGraphicsContext2D();
		
		 double width = c.getWidth();
		 double l = width / col;
		 double height = c.getHeight();
		 double h = height  / lignes;
		 
		 for(Case c : ga){
			 if(ga.getCase(c.getX(), c.getY()) == CaseType.FREE){
				 g.setFill(Color.WHITE);
        		 g.strokeRect(c.getX()*l, c.getY()*h, l, h);
        		 g.fillRect(c.getX()*l, c.getY()*h, l, h);
				 
			 }
			 else if(ga.getCase(c.getX(), c.getY()) == caseType.POISON){
				 final String imageURI = new File("/home/n/ndourno/workspace/Gaufre/rsc/poison.png").toURI().toString(); 
				 final Image image = new Image(imageURI);
                 final ImageView imageView = new ImageView(image); 
				 imageView.setFitHeight(h);
				 imageView.setFitWidth(l);
				 p.getChildren().add(imageView); 

			 }
             else if(ga.getCase(c.getX(), c.getY())  == caseType.EATEN){
            	 g.setFill(Color.WHITE);
        		 g.strokeRect(c.getX()*l, c.getY()*h, l, h);
        		 g.fillRect(c.getX()*l, c.getY()*h, l, h);
			 }
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
	   
        Ecouteur_Souris ecouteurS = new Ecouteur_Souris(this, l, h);
        
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


