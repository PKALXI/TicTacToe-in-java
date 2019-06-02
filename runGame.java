import java.util.*;
import java.math.*;
public class runGame {
    Scanner in = new Scanner(System.in);
    String [] [] game = {
            {" ", " "," "},
            {" "," "," "},
            {" "," "," "}
    };

    int screenSize;



    //----------------------------------------play against menu-------------------------------------------
    public runGame(){
        String playAgain;

        //reset board everytime
        //reset();

        printGame();

        do{
            if(flipCoin()){
                //computer goes first
                comMoveFirst();
                printGame();

            }else if(flipCoin() != true){
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
    public boolean flipCoin(){
        double num = (int)Math.random()*2+1;

        System.out.println(num);
        if(num == 1)return true;
        else return false;
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
            for(int j = 0; j < 3; ){
                game [i][j] = " ";
            }
        }
    }
}
