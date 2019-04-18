import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.paint.Color; 
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.TextAlignment;
import java.util.*;


public class GuessingGame extends Application {
   
   
   
   GridPane grid; 
   Button reset = new Button("Click to Reset Board");  
   Button[][] allBlanks = new Button[4][4]; //{row1,row2,row3};
   Label header = new Label("Guessing Game");
   int turnCnt;
   ImageView[] images = new ImageView[16];
   ImageView[][] imagesGrid = new ImageView[4][4];
   int sizeChoice = 4;
   //if you do small, medium, and large (for A-Code), you can't instantiate arrays up here – create them once sizechoice is determined

   
   
   public static void main(String[] args){

   launch(args);
   }
   
   @Override
   public void start(Stage stage){
      
      header.setFont(Font.font("League Spartan",34));
      header.setTextFill(Color.web("#381E22"));
      
      reset.setFont(Font.font("League Spartan",20));
      reset.setTextFill(Color.web("#381E22"));
      reset.setStyle("-fx-background-color: #F9EAED"); 
      
      reset.setOnAction(new ResetBoard());

      
      grid = new GridPane();
      grid.setMinWidth(638);
      grid.setMaxWidth(638); 
      grid.setMinHeight(638);
      grid.setMaxHeight(638); 
      
      grid.setVgap(8); 
      grid.setHgap(8);
      grid.setStyle("-fx-background-color: #381E22"); 
      grid.setAlignment(Pos.CENTER); 
      
      
      
      for (int r=0;r<4;r++){ 
         for (int c=0;c<4;c++){
            allBlanks[r][c] = makeBlank();
            grid.add(allBlanks[r][c],c,r);
            allBlanks[r][c].setStyle("-fx-background-color: #FDF5F6;-fx-background-radius: 0");
         }
      }
      
      
      
      VBox vbox = new VBox(header,grid,reset);
      vbox.setAlignment(Pos.CENTER);
      vbox.setStyle("-fx-background-color: #F9EAED");
      
      Scene scene = new Scene(vbox,1200,1200); 
      stage.setScene(scene);
      stage.setTitle("Guessing Game"); 
      stage.show(); 

   }
   
             
            
      Button makeBlank(){

         Button newButton =  new Button(""); 
      
         newButton.setPrefWidth(150);
         newButton.setPrefHeight(150);
         

         return(newButton); 
   }
   
      ImageView[][] images(){
         
         int num = 0;
         for (int p=1;p<2;p++){
            for (int i=1;i<8;i++){
               images[i-1] = new ImageView(i+".jpg");
               }
            }
         //***for i<8:  make the 8 a variable that can change based on the size of the grid (for A-Code) –– sizechoice!!***
            

         for (int r=0;r<4;r++){ 
            for (int c=0;c<4;c++){
            imagesGrid[r][c] = images[num];

            num = num + 1;
            }
         
            }
      return(imagesGrid);

      }

   class ResetBoard implements EventHandler<ActionEvent> {      
      @Override
      
      public void handle(ActionEvent event) {

      for (int r=0;r<4;r++){ 
         for (int c=0;c<4;c++){
            allBlanks[r][c] = makeBlank();
            grid.add(allBlanks[r][c],c,r);
            allBlanks[r][c].setStyle("-fx-background-color: #FDF5F6;-fx-background-radius: 0");
         }
      }}}
      

}


