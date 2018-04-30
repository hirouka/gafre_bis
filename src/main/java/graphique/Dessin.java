package application;

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;
import javafx.scene.input.MouseEvent;

import javafx.event.EventHandler;

import java.io.File;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;


public class Dessin extends Application {
    GraphicsContext g;
	//Gaufre ga;
	int lignes = 5; /*ga.hauteur()*/;
	int col = 5;/*ga.largeur()*/;
    //Image poison = null;
	
	
	/*public Dessin(Gaufre ga){
		this.ga = ga;
	}*/
	
	public void tracer (Canvas c){
		
		GraphicsContext g = c.getGraphicsContext2D();
		
		 double width = c.getWidth();
		 double l = width / col;
		 double height = c.getHeight();
		 double h = height  / lignes;
	
		 g.setFill(Color.BROWN);
		 for(int i = 0; i<=lignes; i++){
			 
			 for(int j = 0; j<=col; j++){ 
				 
				 g.strokeRect(i*l,j*h, l, h);
				 g.fillRect(i*l,j*h, l, h);
				// System.out.println(i*l+" "+j*h);
				
			 } 
			 
		 }
		 g.setFill(Color.BLUE);
		 g.strokeRect(0,0, l, h);
		 g.fillRect(0, 0, l, h);
	}
	
	
	@Override
    public void start(Stage primaryStage) throws Exception {
		
		Canvas c = new Canvas();
		Pane p = new Pane(c);
	    c.widthProperty().bind(p.widthProperty());
	    c.heightProperty().bind(p.heightProperty());
	    Scene s = new Scene(p, 800, 600);
	    
        double x = c.getWidth() / col;             //largeur d'une case
	    double y = c.getHeight() / lignes;         //hauteur d'une case
	   
	    final String imageURI = new File("/home/n/ndourno/workspace/ZZZ/src/image/poison.png/").toURI().toString(); 
		final Image image = new Image(imageURI);
        final ImageView imageView = new ImageView(image); 
		 imageView.setFitHeight(y);
		 imageView.setFitWidth(x);
		 p.getChildren().add(imageView); 
	    
        Ecouteur_Souris ecouteurS = new Ecouteur_Souris(this, x, y);
        
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
        tracer(c);
	}
	
	public void affichage_gaufre(Gaufre ga, Canvas c){
		
		
		int i, j;
		
		GraphicsContext g = c.getGraphicsContext2D();
		
		int l=ga.largeur();
	    int h = ga.hauteur();
		double x = c.getWidth() / h;             //largeur d'une case
	    double y = c.getHeight() / l;         //hauteur d'une case
	    
	    
	    for(i=0;i<l; i++){
	    	for(j=0;j<h;j++){
	    		
	    		if(ga.getCase(i,j)==CaseType.EATEN){ 
	    			g.setFill(Color.WHITE);
	    			g.strokeRect(i*x,j*y, l, h);
	    			g.fillRect(i*x,j*y, l, h);
	    			
	    		}else if (ga.getCase(i,j)==CaseType.FREE){
	    			g.setFill(Color.ORANGE);
	    			g.strokeRect(i*x,j*y, l, h);
	    			g.fillRect(i*x,j*y, l, h);
	    			
	    		}else if (ga.getCase(i,j)==CaseType.POISON){
	    			g.setFill(Color.GREEN);
	    			g.strokeRect(i*x,j*y, l, h);
	    			g.fillRect(i*x,j*y, l, h);
	    			 		
	    		}
	    	}
	    }
		
	}
	
	
	
	public static void main(String [] args) {
		launch(args);
	}

}



