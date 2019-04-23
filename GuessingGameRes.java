import java.util.*;



class GuessingGameRes implements Game{ 
   //attributes
   private int turnCnt = 0 ; 
   private boolean isWinner = false;
   private int round = 0; 

   GuessingGameRes(){
   setUp();  
   } //constructor 
   
   public void setUp(){
   //put setUp stuff
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
      
   public String gameOverStatis(){
      String status = ""; 
      if (isWinner())
      status = "Winner"; 
      
      else
      status = "In progress"; 
      } //prints out the status of the game 
      
  }//guessinggameres class