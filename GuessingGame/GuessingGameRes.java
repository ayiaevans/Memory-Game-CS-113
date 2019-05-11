import java.util.*;


class GuessingGameRes implements Game { //the "back-end" of the program 
   //attributes
   private int turnCnt = 0 ; 
   private boolean isWinner = false;
   private int round = 0; //(for A code)
   private int matches = 0; //(for A code)how many completed games the player(s) have played 
   private int [][] board = new int [4][4]; 
   private boolean [][] faceup = new boolean[4][4];//a seperate list that keeps the correct guesses 
   private int rows; 
   private int col; 
   int [] choice= {4}; 
   int [] cardvalue;
   int player=1;
   int p1=0;
   int p2=0;
   
   
   GuessingGameRes(){
      setUp();  
   } //constructor 
   
   public void setUp(){
      p1=0;
      p2=0;
      turnCnt = 0;
      round = 0;
      isWinner = false; 
     for(int r = 0; r<4; r++){
         for(int c = 0; c<4; c++){
            faceup[r][c] =false; }
         }
       
      makeBoard(); 
   } 
   
   public void makeBoard(){ 
         for(int r = 0; r<
         4; r++){
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
      int i = 0; 
      for(int r = 0; r<4; r++){
         for(int c = 0; c<4; c++){
            int num = cardvalue[i];
            num = num + 1;
            if(cardvalue[i]>7){
               num = num - 8;}
            board[r][c]= num; 
            i++;}
            }
          return(board); 
        }//cards 

        
   public int [] setCard(int [] s){
      cardvalue = s;
      cards(board);
      return(cardvalue);
        }//sets the numbers 
   
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
   int match = 0; 
   for(int r = 0; r<4; r++){
      for(int c = 0; c<4; c++){
         if (faceup[r][c]==true){
            match++;}}
          if(match==14){
            isWinner=true;}     
         else{
            isWinner=false;}
            }
            
      return(isWinner); 
   } 
   
   public int getPlayer(){
      if (round%2!=0){
         player=1;}
      if (round%2==0){
         player=2;}
      return(player);}
   
   public int setRound(int x){
      round=x;
      return (round);}
    
   public int setP1(int x){
      p1=x;
      return(p1);}
      
   public int setP2(int x){
      p2=x;
      return(p2);}
      
   public int getP1(){
      return(p1);}
   public int getP2(){
      return(p2);}
 
   
   public boolean isValidInput(int [] c){
      boolean input = false; 
      for(int i=0; i<4; i++){
         if(c[i]<4){
            input = true; }
         else{
            System.out.println("Invalid input. Try again."); 
            input = false; }
         }
         return(input); 
   }
   
   
   public void takeTurn(int c[]){
      turnCnt++;
      if(isMatch()==true){
         System.out.println("Correct match!");
         }
       else{
       System.out.println("Not a match. Try again."); 
       }
      round++;
      makeBoard(); 
      isWinner();
      System.out.println("Game Status:"+gameOverStatus()+"\n");
      } 
      
   public boolean isMatch(){
      boolean match = false; 
      if(board[choice[0]][choice[1]]==board[choice[2]][choice[3]]){ 
         faceup[choice[0]][choice[1]]=true; 
         faceup[choice[2]][choice[3]]=true; 
         match = true; 
         if (round%2!=0){
            p1++;}
         else{if (round%2==0){
            p2++;}}
         }
       else{ 
       match = false; 
       }
      return(match); 
      } 
      
   public int [] setChoice(int [] c){
       choice = c; 
       return choice; 
       }//set choice 
  
      
  
   public String gameOverStatus(){
      String status = ""; 
      if (isWinner()){
         status = "Winner"; 
         }
      
      else{
         status = "In progress"; }
      return(status); 
   } //prints out the status of the game 
      
}//guessinggameres class
