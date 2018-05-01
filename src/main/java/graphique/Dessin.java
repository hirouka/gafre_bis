package graphique;

import general.Case;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;
import waffle.CaseType;
import waffle.Gaufre;


public class Dessin extends Application {
    GraphicsContext g;
	Gaufre ga = new Gaufre(5,5);
	int lignes = ga.getLength();
	int col = ga.getHeight();
    //Image poison = null;
	
	
	/*public Dessin(Gaufre ga){
		this.ga = ga;
	}*/
	
	
	@Override
    public void start(final Stage primaryStage) throws Exception {
		StackPane lool = new StackPane();
		MenuGraphique menug = new MenuGraphique(lool, primaryStage);
        lool.getChildren().add(menug);  
	    Scene s = new Scene(lool, 800, 600);
	    
        primaryStage.setTitle("Gaufre");
        primaryStage.setScene(s);
       // affichage_gaufre(ga, c);

        primaryStage.show();
        menug.dessin();
       

	}
	

	
	public static void main(String [] args) {
		launch(args);
	}

}
