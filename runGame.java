import java.util.*;
import java.math.*;
public class runGame {
    //Declare Scanner for input
    Scanner in = new Scanner(System.in);

    //Create game board
    String [] [] game = {
            {"1", "2","3"},
            {"4","5","6"},
            {"7","8","9"}
    };

    //create boolean controling tracing statments
    boolean tracing = true;

    int screenSize;

    //Variable to store the letter that won
    String winningLetter;

    //----------------------------------------play against menu-------------------------------------------
    public runGame(){
        String playAgain;
        if(tracing)System.out.println("Constructor Has been entered");
        do{
            //reset board everytime
            reset();
            if(tracing)System.out.println("Board has been reset");

            //flip the coin to decide who goes first
            int num = flipCoin();

            if(num == 0){
                System.out.println("The computer moves first");

                //computer goes first
                comMoveFirst();
                do {
                    printGame();
                    askPlayerToMove();
                    printGame();
                    break;
                }while(!isGameOver());

            }else if(num == 1){
                //player goes first
                System.out.println("p v. p");
            }


            //Asks user to play again
            System.out.print("Would you like to play again (y/n): ");
            playAgain = String.valueOf(in.nextLine().charAt(0));
            playAgain = playAgain.toLowerCase();
        }while(playAgain.equals("y"));
    }

    //-------------------------------------coin flip -------------------------------------------------
    public int flipCoin(){
        int num = (int) Math.abs(Math.random()*2);
        return num;

    }

    //-------------------------------------computer moves first---------------------------------------
    public void comMoveFirst(){
        int corner = (int) Math.random()*4 + 1;

        if(corner == 1){
            game [0] [0] = "X";
        } else if(corner == 2){
            game [0] [2] = "X";
        }else if(corner == 3){
            game [2] [0] = "X";
        }else if(corner == 4) {
            game[2][2] = "X";
        }
    }

    //-----------------------------------print game------------------------------------------------
    public void printGame(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(" " + game[i][j] + " ");
                if(j < 2) System.out.print(" | ");
            }
            System.out.println("");
            if(i < 2)System.out.println("-------------");
        }
    }

    //---------------------------------reset game board--------------------------------------------
    public void reset(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                game [i][j] = " ";
            }
        }
    }

    //-------------------------------check if game is over-----------------------------------------
    public boolean isGameOver(){
        if(checkRows()){
            return true;
        }else if(checkCols()){
            return true;
        } else if(checkDiags()){
            return true;
        }else{
            return false;
        }
    }

    //-----------------------------Subset of game over checkers------------------------------------
    public boolean checkRows(){
        if(game[0][0].equals(game[0][1])&&game[0][1].equals(game[0][2])){
            winningLetter = game[0][0];
            return true;
        }else if (game[1][0].equals(game[1][1])&&game[1][1].equals(game[1][2])){
            winningLetter = game[1][0];
            return true;
        } else if (game[2][0].equals(game[2][1])&&game[2][1].equals(game[2][2])){
            winningLetter = game[2][0];
            return true;
        }else {
            return false;
        }
    }

    public boolean checkCols(){
        if(game[0][0].equals(game[1][0])&&game[1][0].equals(game[2][0])){
            winningLetter = game[0][0];
            return true;
        }else if (game[0][1].equals(game[1][1])&&game[1][1].equals(game[2][1])){
            winningLetter = game[0][1];
            return true;
        } else if (game[0][2].equals(game[1][2])&&game[1][2].equals(game[2][2])){
            winningLetter = game[0][2];
            return true;
        }else {
            return false;
        }
    }

    public boolean checkDiags(){
        if(game[0][0].equals(game[1][1])&&game[1][1].equals(game[2][2])){
            winningLetter = game[0][0];
            return true;
        }else if (game[0][2].equals(game[1][1])&&game[1][1].equals(game[2][0])){
            winningLetter = game[0][2];
            return true;
        } else {
            return false;
        }
    }

    //-----------------------------------ask for player move--------------------------
    public void askPlayerToMove(){
        int n;
        do {
            System.out.print("type the number where you would like to move");
            n = in.nextInt();

        }while(isOccupied(n));

        int col = 0, row = 0;
        if(n < 4){
            row = 0;
            col = n-1;
        }else if (n > 3 && n < 7){
            row = 1;
            col = n-4;
        }else if (n > 6 && n < 10 ){
            row = 2;
            col = n-7;
        }

        game[row][col] = "O";
    }

    //---------------------------------check if spot is occupied----------------------
    public boolean isOccupied(int n){
        int col = 0, row = 0;
        if(n < 4){
            row = 0;
            col = n-1;
        }else if (n < 7){
            row = 1;
            col = n-4;
        }else if (n < 10 ){
            row = 2;
            col = n-7;
        }
        if(game[row][col].equals("X") || game[row][col].equals("O")){
            return true;
        }else {
            return false;
        }
    }
}
