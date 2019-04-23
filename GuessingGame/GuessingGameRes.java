import java.util.*;



class GuessingGameRes implements Game { //the "back-end" of the program 
   //attributes
   private int turnCnt = 0 ; 
   private boolean isWinner = false;
   private int round = 0;
   private int matches = 0; //how many completed games the player(s) have played 
   
   /*
   private int rows = 2
   private int col = 2; 
   private char [][] board = [2][2]; */ 

   GuessingGameRes(){
   setUp();  
   } //constructor 
   
   public void setUp(){
   turnCnt = 0; 
   isWinner = false; 
   
   } 
   
   public int getTurnCnt(){
      return(turnCnt);  //returns what turn the player is on 
      }
      
   public int getRound(){
      return(round); //returns the round 
      } 
      
   public boolean isWinner(){
      return(isWinner); 
      } 
      
   public String toString(){
   String words = ""; 
   return(words); 
   }// a basic toString 
   
   public boolean isValidInput(int [] x){
   return(true);
   }
   
   public void takeTurn(int choice[]){
      turnCnt++; 
      }//stub of take turn 
      
   public String gameOverStatus(){
      String status = ""; 
      if (isWinner())
      status = "Winner"; 
      
      else
      status = "In progress"; 
      return(status); 
      } //prints out the status of the game 
      
  }//guessinggameres class
