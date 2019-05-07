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
   ImageView[] images = new ImageView[16];
   ImageView[] shuffled = new ImageView[16];
   ImageView[][] imagesGrid = new ImageView[4][4];
   int sizeChoice = 4;
   Label p1Score = new Label("   Player 1 : 0");
   Label p2Score = new Label("Player 2: 0   ");
   Label turnCnt = new Label("Turn Count: 0");
   GuessingGameRes gg = new GuessingGameRes(); 
   Label status = new Label(gg.gameOverStatus());
   int turn=1;
   int [] guess = new int[4];
   //if you do small, medium, and large (for A-Code), you can't instantiate arrays up here â€“ create them once sizechoice is determined

   
   
   public static void main(String[] args){

   launch(args);
   }
   
   @Override
   public void start(Stage stage){
      imagesGrid=images();
      
      header.setFont(Font.font("League Spartan",34));
      header.setTextFill(Color.web("#1E2738"));
      
      reset.setFont(Font.font("League Spartan",20));
      reset.setTextFill(Color.web("#381E22"));
      reset.setStyle("-fx-background-color: #BECADD"); 
      
      reset.setOnAction(new ResetBoard());

      p1Score.setFont(Font.font("League Spartan",20));
      p1Score.setTextFill(Color.web("#FFFFFF"));
      
      p2Score.setFont(Font.font("League Spartan",20));
      p2Score.setTextFill(Color.web("#FFFFFF"));

      turnCnt.setFont(Font.font("League Spartan",15));
      turnCnt.setTextFill(Color.web("#FFFFFF"));

      grid = new GridPane();
      grid.setMinWidth(638);
      grid.setMaxWidth(638); 
      grid.setMinHeight(638);
      grid.setMaxHeight(638); 
      
      grid.setVgap(8); 
      grid.setHgap(8);
      grid.setStyle("-fx-background-color: #1E2738"); 
      grid.setAlignment(Pos.CENTER); 
      
      
      
      for (int r=0;r<4;r++){ 
         for (int c=0;c<4;c++){
            allBlanks[r][c] = makeBlank();
            grid.add(allBlanks[r][c],c,r);
            allBlanks[r][c].setStyle("-fx-background-color: #DEE5F2;-fx-background-radius: 0");
            allBlanks[r][c].setOnAction(new ButtonClickHandler());
         }
      }
      
      
      VBox vbox = new VBox(header,grid,reset,turnCnt);
      vbox.setAlignment(Pos.CENTER);
      vbox.setStyle("-fx-background-color: #BECADD");
      
      HBox hbox = new HBox(p1Score,vbox,p2Score);
      hbox.setStyle("-fx-background-color: #BECADD");
      vbox.setAlignment(Pos.CENTER);

      
      Scene scene = new Scene(hbox); 
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
           for (int i=1;i<9;i++){
               images[i-1] = new ImageView(i+".jpeg");
               images[i-1].setFitWidth(130); 
               images[i-1].setFitHeight(130);
               }
               
           for (int i=1;i<9;i++){
               images[i+7] = new ImageView(i+".jpeg");
               images[i+7] .setFitWidth(130); 
               images[i+7] .setFitHeight(130);
               }

           
         //***for i<8:  make the 8 a variable that can change based on the size of the grid (for A-Code) â€“â€“ sizechoice!!***
            

         for (int r=0;r<4;r++){ 
            for (int c=0;c<4;c++){
            imagesGrid[r][c] = images[num];
            num = num + 1;}
         
            }
      return(imagesGrid);

      }
      
      ImageView[] shuffle(){
   
      ArrayList<Integer> iHateJava = new ArrayList<Integer>();
      
      int[] random = new int[16];
      
      for(int i = 0;i<16;i++){
         iHateJava.add(new Integer(i)); }
         
      Collections.shuffle(iHateJava);
      //System.out.println(iHateJava);
      
      for(int j = 0;j<16;j++){
         int num = iHateJava.get(j);
         shuffled[j] = images[num]; 
      
         System.out.print(shuffled[j]); }
         
      for(int x = 0;x<16;x++){
         int num = iHateJava.get(x);
         random[x] = num; }
         
      gg.setCard(random);   

      return(shuffled);
      }     

   class ResetBoard implements EventHandler<ActionEvent> {      
      @Override
      
      public void handle(ActionEvent event) {
      imagesGrid=images();
      for (int r=0;r<4;r++){ 
         for (int c=0;c<4;c++){
            allBlanks[r][c] = makeBlank();
            grid.add(allBlanks[r][c],c,r);
            allBlanks[r][c].setStyle("-fx-background-color: #DEE5F2;-fx-background-radius: 0");
            allBlanks[r][c].setOnAction(new ButtonClickHandler());
         }
      }}}
      
      
class ButtonClickHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
      //status.setText(gg.gameOverStatus());
      if(turn==3){
         gg.setChoice(guess);
         if(gg.isMatch()){
            p1Score.setText("   Player 1 : 1");}
         else{
            allBlanks[guess[0]][ guess[1]] = makeBlank();
            grid.add(allBlanks[guess[0]][ guess[1]],guess[1],guess[0]);
            allBlanks[guess[0]][ guess[1]].setStyle("-fx-background-color: #DEE5F2;-fx-background-radius: 0");
            allBlanks[guess[0]][ guess[1]].setOnAction(new ButtonClickHandler());
            allBlanks[guess[2]][ guess[3]] = makeBlank();
            grid.add(allBlanks[guess[2]][ guess[3]],guess[3],guess[2]);
            allBlanks[guess[2]][ guess[3]].setStyle("-fx-background-color: #DEE5F2;-fx-background-radius: 0");
            allBlanks[guess[2]][ guess[3]].setOnAction(new ButtonClickHandler());}
            turn=0;}
        else{
         for(int r=0;r<4;r++){
            for(int c=0;c<4;c++){
               if(event.getSource().equals(allBlanks[r][c])){
                  allBlanks[r][c]= new Button("",imagesGrid[r][c]);
                  grid.add(allBlanks[r][c],c,r);
               if (turn==1){
                  guess[0]=r;
                  guess[1]=c;}
               if (turn==2){
                  guess[2]=r;
                  guess[3]=c;}}}}}
                  
               turn++;
               turnCnt.setText("Turn Count: "+turn);}
                  
                  
                  }
                  
                  }
                 
