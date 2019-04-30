import java.util.*;


class GuessingGameRes implements Game { //the "back-end" of the program 
   //attributes
   private int turnCnt = 0 ; 
   private boolean isWinner = false;
   private int round = 0; //(for A code)
   private int matches = 0; //(for A code)how many completed games the player(s) have played 
   private int [][] board = new int [4][4]; 
   private boolean [][] faceup = new boolean[4][4];//a seperate list that keeps the correct guesses 
   private int rows = 4; 
   private int col = 4; 
   
   
   GuessingGameRes(){
      setUp();  
   } //constructor 
   
   public void setUp(){
      turnCnt = 0; 
      isWinner = false; 
     for(int r = 0; r<4; r++){
         for(int c = 0; c<4; c++){
            faceup[r][c] = false; }
         }
      cards(board); 
      showBoard(faceup,board); 
   } 
   
   public void showBoard(boolean [][]faceup, int [][] board){
         for(int r = 0; r<4; r++){
         for(int c = 0; c<4; c++){ 
            if(faceup[r][c]== true){
                System.out.print(board[r][c]+" ");}
            else if(faceup[r][c]==false){
               System.out.print("* ");}
            
         } //puts a character star in each slot
         System.out.println();
      }//for loop 
   }//makeBoard 
   
   public int[][] cards(int [][]board){
      int [] cardvalue = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9}; 
      int t = 0; 
      for(int r = 0; r<4; r++){
         for(int c = 0; c<4; c++){
            board[r][c]= cardvalue[t]; 
            t++;}
            }
          return(board); 
        }//cards 
   
  /* public int getSize(String size){
      int s = 2;
      if (size.equals("Small"))
         s = 2; 
      if (size.equals("Medium"))
         s = 4; 
      if (size.equals("Large"))
         s = 6; 
      return (s); 
     }//gets the size of the board */ 
   
   public int getTurnCnt(){
      return(turnCnt);  //returns what turn the player is on 
   }
      
   public int getRound(){
      return(round); //returns the round 
   } 
      
   public boolean isWinner(){
      return(isWinner); 
   } 
      
  /* public String toString(){
   String words = ""; 
   return(words); 
   }// a basic toString */
   
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
