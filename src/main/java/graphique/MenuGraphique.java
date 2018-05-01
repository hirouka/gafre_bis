package graphique;



import general.Case;
import player.*;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import player.JouerFactory;
import system.Arbitre;
import system.ArbitreSimple;
import waffle.CaseType;
import waffle.Gaufre;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.*;


public class MenuGraphique extends BorderPane {
	private Stage primaryStage;
	private ArbitreSimple jeu;
	private StackPane root;
	Gaufre ga = new Gaufre(5,5);
	int lignes = ga.getLength();
	int col = ga.getHeight();

	MenuGraphique(StackPane root, Stage primaryStage) {
		this.jeu = new ArbitreSimple(5,5,"HUMAN","HUMAN");      
		this.root = root;
		this.primaryStage = primaryStage;
		dessin();
	}
	void dessin() {
    	this.getChildren().clear();
    	 Button jouer = new Button("JOUER");
         jouer.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
            	 
            	 
            	 
            	 
            	 StackPane ia = new StackPane();
         		MenuGraphique menuia = new MenuGraphique(ia, primaryStage);
                 ia.getChildren().add(menuia);  
         	    Scene s = new Scene(ia, 800, 600);
         	    
                 primaryStage.setTitle("h");
                 primaryStage.setScene(s);
                // affichage_gaufre(ga, c);

                 primaryStage.show();
                 menuia.dessinia();
                 
                
            	 

         		/*final Canvas c = new Canvas();
         		Pane p = new Pane(c);
         	    c.widthProperty().bind(p.widthProperty());
         	    c.heightProperty().bind(p.heightProperty());
         	    Scene s = new Scene(p, 800, 600);
         	    
                 final double x = c.getWidth() / col;             //largeur d'une case
         	    final double y = c.getHeight() / lignes;         //hauteur d'une case
         	    
         	    
         	   s.setOnMousePressed(new EventHandler<MouseEvent>() {
                   @Override
                   public void handle(MouseEvent event) {
                   	if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {	
               	    	int a = (int) (event.getX() / x);
               	    	int b = (int) (event.getY() / y);
               	    	Case m = new Case(a,b);
               	    	System.out.println("  "+a+"  "+b);		
               	        ga.manger(m);
               	        if(ga.isWon(m)) {
               	        	primaryStage.close();

               	        }else {
                   	        affichage_gaufre(ga, c);

               	        }

               	    			
               	    }
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
               Gaufre ga = new Gaufre(5,5);
               affichage_gaufre(ga, c);*/
             }
         });
         
         
         VBox vb = new VBox();    
         vb.setAlignment(Pos.CENTER);
         vb.setPadding(new Insets(10, 50, 50, 50));
         vb.setSpacing(10);

         Label lbl = new Label("GAUFRE");
         lbl.setFont(Font.font("Amble CN", FontWeight.NORMAL, 28));
         vb.getChildren().add(lbl);
         vb.getChildren().add(jouer);
         this.setCenter(vb);

	}
	
    
protected void dessinia() {
		
	this.getChildren().clear();
	 Button joueur = new Button("HUMAN");
	 Button iafacile = new Button("IA_FACILE");
	 Button iamoyen = new Button("IA_MOYENNE");
	 Button iadifficile = new Button("IA_DIFFICILE");

    joueur.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	final Canvas c = new Canvas();
     		Pane p = new Pane(c);
     	    c.widthProperty().bind(p.widthProperty());
     	    c.heightProperty().bind(p.heightProperty());
     	    Scene s = new Scene(p, 800, 600);
            final double x = c.getWidth() / col;             //largeur d'une case
     	    final double y = c.getHeight() / lignes;         //hauteur d'une case
     	    s.setOnMousePressed(new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent event) {
               	if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {	
           	    	int a = (int) (event.getX() / x);
           	    	int b = (int) (event.getY() / y);
           	    	Case m = new Case(a,b);
           	    	System.out.println("  "+a+"  "+b);		
           	        ga.manger(m);
           	        if(ga.isWon(m)) {
           	        	primaryStage.close();

           	        }else {
               	        affichage_gaufre(ga, c);

           	        }

           	    			
           	    }
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
           Gaufre ga = new Gaufre(5,5);
           affichage_gaufre(ga, c);
            
           
       	 
		
	}
    });
    
    
    iafacile.setOnAction(new EventHandler<ActionEvent>() {
    	 public void handle(ActionEvent event) {
         	final Canvas c = new Canvas();
      		Pane p = new Pane(c);
      	    c.widthProperty().bind(p.widthProperty());
      	    c.heightProperty().bind(p.heightProperty());
      	    Scene s = new Scene(p, 800, 600);
             final double x = c.getWidth() / col;             //largeur d'une case
      	    final double y = c.getHeight() / lignes;   
      	    //hauteur d'une case
      	    int joueur =0, machine = 1;
      	    int comp =0;
      	 boolean terminer = true; 
      // Gaufre ga =new Gaufre(5,5);
  	        affichage_gaufre(ga, c);

  	      primaryStage.setTitle("Gaufre");
          primaryStage.setScene(s);
          primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent we) {
                System.exit(0);
            }
          }); 
          primaryStage.show();
         final Gaufre ga = new Gaufre(5,5);
          affichage_gaufre(ga, c);
      	 //  while(terminer) {
      	    	if(comp==0) {
      	    		System.out.println("JE SUIS DANS JOUEUR");

      	    		comp=1;
      	    		s.setOnMousePressed(new EventHandler<MouseEvent>() {
      	                @Override
      	                public void handle(MouseEvent event) {
      	                	if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {	
      	            	    	int a = (int) (event.getX() / x);
      	            	    	int b = (int) (event.getY() / y);
      	            	    	Case m = new Case(a,b);
      	            	    	System.out.println("  clique sur "+a+"  "+b);		
      	            	        ga.manger(m);
      	        	            affichage_gaufre(ga, c);


      	            	    			
      	            	    }
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
      	           // Gaufre ga = new Gaufre(5,5);

      	            affichage_gaufre(ga, c);
      	    		//continue;
      	    		 
      	    	}
      	    	
      	    	if(comp==1) {
      	    	
      	    		System.out.println("JE SUIS DANS MACH");
      	    		comp =0;
      	    		System.out.println("helloo");
      	    		
      	    		IaFacile facil = new IaFacile(ga);
      	    		Case m = facil.reflechir();
      	    		System.out.println(" on a recu   x "+m.getX()+" y "+m.getY());
      	    		
          	        ga.manger(m);
          	     
      	            affichage_gaufre(ga, c);
      	          

          	 	 
      	      
  	            primaryStage.show();
  	           // Gaufre ga = new Gaufre(5,5);

  	            affichage_gaufre(ga, c);
      	    
      	    	
      	    		// continue;
      	    		
      	    		
      	    		
      	    	}
      	 	/* primaryStage.setTitle("Gaufre");
	            primaryStage.setScene(s);
	            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	              @Override
	              public void handle(WindowEvent we) {
	                  System.exit(0);
	              }
	            }); 
	            primaryStage.show();
	           Gaufre ga = new Gaufre(5,5);
	            affichage_gaufre(ga, c);*/
      		
      	    	
      			

       	        
    	// }
        	 
 		
 	}
     });
    VBox vb = new VBox();    
    vb.setAlignment(Pos.CENTER);
    vb.setPadding(new Insets(10, 50, 50, 50));
    vb.setSpacing(10);

    Label lbl = new Label("GAUFRE");
    lbl.setFont(Font.font("Amble CN", FontWeight.NORMAL, 28));
    vb.getChildren().add(lbl);
    vb.getChildren().addAll(joueur,iafacile,iamoyen,iadifficile);
    this.setCenter(vb);

}
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
public void affichage_gaufre(Gaufre ga, Canvas c){
	int i, j;
	
	GraphicsContext g = c.getGraphicsContext2D();
	
	int l=ga.getLength();
    int h = ga.getHeight();
	double x = c.getWidth() / h;             //largeur d'une case
    double y = c.getHeight() / l;         //hauteur d'une case
    
    
    for(i=0;i<l+1; i++){
    	for(j=0;j<h+1;j++){
    		
    		if(ga.getCase(i,j)==CaseType.EATEN){ 
    			g.setFill(Color.WHITE);
    			g.strokeRect(i*x,j*y, x, y);
    			g.fillRect(i*x,j*y, x, y);
    			
    		}else if (ga.getCase(i,j)==CaseType.FREE){
    			g.setFill(Color.ORANGE);
    			g.strokeRect(i*x,j*y, x, y);
    			g.fillRect(i*x,j*y, x, y);
    			
    		}else if (ga.getCase(i,j)==CaseType.POISON){
    			g.setFill(Color.GREEN);
    			g.strokeRect(i*x,j*y, x, y);
    			g.fillRect(i*x,j*y, x, y);
    			 		
    		}
    	}
    }
	
}


    }
