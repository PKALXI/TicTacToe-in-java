/*
 *File name: JEOPARDY_REAL.java
 *Number of classes: 2
 *Name of other two class: SPLASH_SCREEN.java
 *Name: Pranav's Elite Jeopardy
 *Brief Description: This game has a UI that helps you play the most elite version of Jeopardy that you have ever played
 *Author of this program: Pranav Kalsi
 *Start Date: February 15th 2018
 *End Date: March 1th 2019
 */

import java.util.*;
import java.io.*;

public class runGame {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //Declare Scanner for input
    Scanner in = new Scanner(System.in);

    //Create game board
    String [] [] game = {
            {"1", "2","3"},
            {"4","5","6"},
            {"7","8","9"}
    };

    //x,y position if need to block
    int rowBlock,colBlock;

    //x,y position to see if computer can win
    int rowWin, colWin;

    //create boolean controling tracing statments
    boolean tracing = false;

    int screenSize;

    //Variable to store the letter that won
    String winningLetter;

    //----------------------------------------play against menu-------------------------------------------
    public runGame(int n) throws Exception {
        screenSize = n;

        //String to record if the user wants to play again
        String playAgain;

        //tracing statment to test if constructor is being entered
        if(tracing)System.out.println("Constructor Has been entered");

        do{
            //reset board everytime
            reset();
            if(tracing)System.out.println("Board has been reset");

            //flip the coin to decide who goes first
            System.out.println("A coin is being flipped to see who goes first.");
            int num = flipCoin();

            num = 0;

            if(num == 0){
                clear();
                System.out.println("The computer moves first");

                printGame();

                //pause the program
                pause();
                //computer goes first
                comMoveFirst();
                do {
                    //clear the screen
                    clear();

                    printGame();
                    askPlayerToMoveO();

                    //check if it is a tie
                    if (!isGameOver() && areAllSquaresQccupied()) {
                        Out.print("", (screenSize-60)/2);
                        Out.printLeft("It's a tie", 57);
                        break;
                    }

                    clear();

                    printGame();

                    Out.center("Computer Moves...", screenSize);

                    pause();

                    algorithmFirst();

                    //check if it is a tie
                    if (!isGameOver() && areAllSquaresQccupied()) {
                        Out.print("", (screenSize-60)/2);
                        Out.printLeft("It's a tie...", 57);
                        break;
                    }

                    clear();


                }while(!isGameOver());

                if (isGameOver()) {

                    //delay so user can take in the final result
                    time(1000);

                    clear();//clear the screen

                    //display game over screen
                    gameOver();

                    space();//add a linespace
                    space();//add a linespace

                    if(winningLetter.equals("X")){
                        congratsX();
                    }else if(winningLetter.equals("Y")){
                        congratsY();
                    }
                }

            }else if(num == 1){
                do {
                    System.out.print("Player goes first");
                    //check if it is a tie
                    if (!isGameOver() && areAllSquaresQccupied()) {
                        Out.centerWrite("It's a tie.", screenSize);
                        break;
                    }

                    printGame();

                    space();//add linespace

                    //player goes first
                    askPlayerToMoveO();
                }while(!isGameOver());
            }

            in.nextLine();

            //Asks user to play again
            System.out.print("Would you like to play again (y/n): ");
            playAgain = String.valueOf(in.nextLine().charAt(0));
            playAgain = playAgain.toLowerCase();
        }while(playAgain.equals("y"));
    }

    //--------------------------------game over--------------------------------------------
    public void gameOver(){
        Out.center(":'######::::::'###::::'##::::'##:'########:::::'#######::'##::::'##:'########:'########:::::::::::::::::", screenSize);
        Out.center("'##... ##::::'## ##::: ###::'###: ##.....:::::'##.... ##: ##:::: ##: ##.....:: ##.... ##::::::::::::::::", screenSize);
        Out.center(" ##:::..::::'##:. ##:: ####'####: ##:::::::::: ##:::: ##: ##:::: ##: ##::::::: ##:::: ##::::::::::::::::", screenSize);
        Out.center(" ##::'####:'##:::. ##: ## ### ##: ######:::::: ##:::: ##: ##:::: ##: ######::: ########:::::::::::::::::", screenSize);
        Out.center(" ##::: ##:: #########: ##. #: ##: ##...::::::: ##:::: ##:. ##:: ##:: ##...:::: ##.. ##::::::::::::::::::", screenSize);
        Out.center(" ##::: ##:: ##.... ##: ##:.:: ##: ##:::::::::: ##:::: ##::. ## ##::: ##::::::: ##::. ##::'###:'###:'###: ", screenSize);
        Out.center(". ######::: ##:::: ##: ##:::: ##: ########::::. #######::::. ###:::: ########: ##:::. ##: ###: ###: ###:", screenSize);
        Out.center(":......::::..:::::..::..:::::..::........::::::.......::::::...:::::........::..:::::..::...::...::...::", screenSize);
    }


    //--------------------------------congratulations screens----------------------------
    public void congratsX(){
        Out.center("'##::::'##::::'##:::::'##:'####:'##::: ##:'####::'######::'####:'####:'####:'####:'####:'####:", screenSize);
        Out.center(". ##::'##::::: ##:'##: ##:. ##:: ###:: ##: ####:'##... ##: ####: ####: ####: ####: ####: ####:", screenSize);
        Out.center(":. ##'##:::::: ##: ##: ##:: ##:: ####: ##:. ##:: ##:::..:: ####: ####: ####: ####: ####: ####:", screenSize);
        Out.center("::. ###::::::: ##: ##: ##:: ##:: ## ## ##:'##:::. ######::: ##::: ##::: ##::: ##::: ##::: ##::", screenSize);
        Out.center(":: ## ##:::::: ##: ##: ##:: ##:: ##. ####:..:::::..... ##::..::::..::::..::::..::::..::::..:::", screenSize);
        Out.center(": ##:. ##::::: ##: ##: ##:: ##:: ##:. ###:::::::'##::: ##:'####:'####:'####:'####:'####:'####:", screenSize);
        Out.center(" ##:::. ##::::. ###. ###::'####: ##::. ##:::::::. ######:: ####: ####: ####: ####: ####: ####:", screenSize);
        Out.center("..:::::..::::::...::...:::....::..::::..:::::::::......:::....::....::....::....::....::....::", screenSize);

        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
    }


    public void congratsY(){
        Out.center("'##:::'##::::'##:::::'##:'####:'##::: ##:'####::'######::'####:'####:'####:'####:'####:'####:", screenSize);
        Out.center(". ##:'##::::: ##:'##: ##:. ##:: ###:: ##: ####:'##... ##: ####: ####: ####: ####: ####: ####:", screenSize);
        Out.center(":. ####:::::: ##: ##: ##:: ##:: ####: ##:. ##:: ##:::..:: ####: ####: ####: ####: ####: ####:", screenSize);
        Out.center("::. ##::::::: ##: ##: ##:: ##:: ## ## ##:'##:::. ######::: ##::: ##::: ##::: ##::: ##::: ##::", screenSize);
        Out.center("::: ##::::::: ##: ##: ##:: ##:: ##. ####:..:::::..... ##::..::::..::::..::::..::::..::::..:::", screenSize);
        Out.center("::: ##::::::: ##: ##: ##:: ##:: ##:. ###:::::::'##::: ##:'####:'####:'####:'####:'####:'####:", screenSize);
        Out.center("::: ##:::::::. ###. ###::'####: ##::. ##:::::::. ######:: ####: ####: ####: ####: ####: ####:", screenSize);
        Out.center(":::..:::::::::...::...:::....::..::::..:::::::::......:::....::....::....::....::....::....::", screenSize);
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
        space();//add a linespace
    }

    //-------------------------------------coin flip -------------------------------------------------
    public int flipCoin(){
        int num = (int) Math.abs(Math.random()*2);
        return num;

    }

    //-------------------------------------computer moves first---------------------------------------
    public void comMoveFirst(){
        game [0][0] = "X";
    }

    //---------------------------------check if it is a tie-----------------------------
    public boolean areAllSquaresQccupied(){
        for(int i = 1; i < 10; i++){
            if(!isOccupied(i)){
                return false;
            }
        }
        return true;
    }

    //-----------------------------------ask for player O move--------------------------
    public void askPlayerToMoveO(){
        int n;
        do {
            Out.print("", (screenSize-60)/2);
            Out.printLeft("Player 'O', type the number where you would like to move: ", 57);
            n = in.nextInt();

            if(isOccupied(n)){
                space(); //add a linespace

                Out.print("", (screenSize-60)/2);
                Out.printlnLeft("This square is occupied please pick another square.", 57);

                space(); //add a linespace
            }
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



    //-----------------------------------print game------------------------------------------------
    public void printGame(){
        for(int i = 0; i < 3; i++){

            Out.center(" " + game[i][0] + " | " + game[i][1] + " | " + game[i][2], screenSize);
            if(i < 2)Out.center("---------------" , screenSize);
        }
    }

    //---------------------------------reset game board--------------------------------------------
    public void reset(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                game [i][j] = String.valueOf((i*3)+(j+1));
            }
        }
    }

    //-------------------------------check if game is over-----------------------------------------
    public boolean isGameOver(){
        if(checkRows()){
            if(tracing) System.out.println(true);
            return true;
        }else if(checkCols()){
            if(tracing) System.out.println(true);
            return true;
        } else if(checkDiags()){
            if(tracing) System.out.println(true);
            return true;
        }else{
            if(tracing) System.out.println(false);
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

    //----------------------loading-----------------------------------
    public void load() throws Exception{
        //Start of the loading screen
        Out.center("'########::'##:::::::'########::::'###:::::'######::'########::::'##:::::'##::::'###::::'####:'########:", screenSize);
        Out.center(" ##.... ##: ##::::::: ##.....::::'## ##:::'##... ##: ##.....::::: ##:'##: ##:::'## ##:::. ##::... ##..::", screenSize);
        Out.center(" ##:::: ##: ##::::::: ##::::::::'##:. ##:: ##:::..:: ##:::::::::: ##: ##: ##::'##:. ##::: ##::::: ##::::", screenSize);
        Out.center(" ########:: ##::::::: ######:::'##:::. ##:. ######:: ######:::::: ##: ##: ##:'##:::. ##:: ##::::: ##::::", screenSize);
        Out.center(" ##.....::: ##::::::: ##...:::: #########::..... ##: ##...::::::: ##: ##: ##: #########:: ##::::: ##::::", screenSize);
        Out.center(" ##:::::::: ##::::::: ##::::::: ##.... ##:'##::: ##: ##:::::::::: ##: ##: ##: ##.... ##:: ##::::: ##::::", screenSize);
        Out.center(" ##:::::::: ########: ########: ##:::: ##:. ######:: ########::::. ###. ###:: ##:::: ##:'####:::: ##::::", screenSize);
        Out.center("..:::::::::........::........::..:::::..:::......:::........::::::...::...:::..:::::..::....:::::..:::::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(1000);
        clear();

        //first half-second
        Out.center("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("'#######:'#######:'#######:'#######:'#######:'#######:'#######:'#######:'#######:'#######:", screenSize);
        Out.center(".......::.......::.......::.......::.......::.......::.......::.......::.......::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(500);
        clear();

        //second half-second
        Out.center("'##::::'##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(". ##::'##:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":. ##'##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::. ###:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":: ## ##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(": ##:. ##:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(" ##:::. ##:'#######:'#######:'#######:'#######:'#######:'#######:'#######:'#######:'#######:", screenSize);
        Out.center("..:::::..::.......::.......::.......::.......::.......::.......::.......::.......::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(500);
        clear();

        //third half-second
        Out.center("'##::::'##:'##::::'##:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(". ##::'##::. ##::'##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":. ##'##::::. ##'##:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::. ###::::::. ###::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":: ## ##::::: ## ##:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(": ##:. ##::: ##:. ##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(" ##:::. ##: ##:::. ##:'#######:'#######:'#######:'#######:'#######:'#######:'#######:'#######:", screenSize);
        Out.center("..:::::..::..:::::..::.......::.......::.......::.......::.......::.......::.......::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(500);
        clear();

        //fourth half-second
        Out.center("'##::::'##:'##::::'##:'##::::'##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(". ##::'##::. ##::'##::. ##::'##:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":. ##'##::::. ##'##::::. ##'##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::. ###::::::. ###::::::. ###:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":: ## ##::::: ## ##::::: ## ##::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(": ##:. ##::: ##:. ##::: ##:. ##:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(" ##:::. ##: ##:::. ##: ##:::. ##:'#######:'#######:'#######:'#######:'#######:'#######:'#######:", screenSize);
        Out.center("..:::::..::..:::::..::..:::::..::.......::.......::.......::.......::.......::.......::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(500);
        clear();

        //fifth half-second
        Out.center("'##::::'##:'##::::'##:'##::::'##:'##::::'##:::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(". ##::'##::. ##::'##::. ##::'##::. ##::'##::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":. ##'##::::. ##'##::::. ##'##::::. ##'##:::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::. ###::::::. ###::::::. ###::::::. ###::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":: ## ##::::: ## ##::::: ## ##::::: ## ##:::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(": ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::::::::::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(" ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##:'#######:'#######:'#######:'#######:'#######:'#######:", screenSize);
        Out.center("..:::::..::..:::::..::..:::::..::..:::::..::.......::.......::.......::.......::.......::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(500);
        clear();

        //sixth half-second
        Out.center("'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(". ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##:::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::. ###::::::. ###::::::. ###::::::. ###::::::. ###:::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(": ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##:::::::::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(" ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##:'#######:'#######:'#######:'#######:'#######:", screenSize);
        Out.center("..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::.......::.......::.......::.......::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(500);
        clear();

        //seventh half-second
        Out.center("'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(". ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##:::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center("::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(":: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##:::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(": ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::::::::::::::::::::::::::::::::::::::", screenSize);
        Out.center(" ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##:'#######:'#######:'#######:'#######:", screenSize);
        Out.center("..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::.......::.......::.......::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(500);
        clear();

        //eighth half-second
        Out.center("'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##::::::::::::::::::::::::::::", screenSize);
        Out.center(". ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##:::::::::::::::::::::::::::::", screenSize);
        Out.center(":. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::::::::::::::::::::::::::::", screenSize);
        Out.center("::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###:::::::::::::::::::::::::::::::", screenSize);
        Out.center(":: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::::::::::::::::::::::::::::", screenSize);
        Out.center(": ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##:::::::::::::::::::::::::::::", screenSize);
        Out.center(" ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##:'#######:'#######:'#######:", screenSize);
        Out.center("..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::.......::.......::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(500);
        clear();

        //nineth half-second
        Out.center("'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:::::::::::::::::::", screenSize);
        Out.center(". ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::::::::::::::::::::", screenSize);
        Out.center(":. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##:::::::::::::::::::::", screenSize);
        Out.center("::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::::::::::::::::::", screenSize);
        Out.center(":: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##:::::::::::::::::::::", screenSize);
        Out.center(": ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::::::::::::::::::::", screenSize);
        Out.center(" ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##:'#######:'#######:", screenSize);
        Out.center("..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::.......::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        time(500);
        clear();

        //tenth half-second
        Out.center("'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##:'##::::'##::::::::::", screenSize);
        Out.center(". ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##::. ##::'##:::::::::::", screenSize);
        Out.center(":. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::. ##'##::::::::::::", screenSize);
        Out.center("::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###::::::. ###:::::::::::::", screenSize);
        Out.center(":: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::: ## ##::::::::::::", screenSize);
        Out.center(": ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##::: ##:. ##:::::::::::", screenSize);
        Out.center(" ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##: ##:::. ##:'#######:", screenSize);
        Out.center("..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::..:::::..::.......::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();

        time(500);

        clear();

        //loaded
        Out.center("'##::::::::'#######:::::'###::::'########::'########:'########:::::::::::::::::", screenSize);
        Out.center(" ##:::::::'##.... ##:::'## ##::: ##.... ##: ##.....:: ##.... ##::::::::::::::::", screenSize);
        Out.center(" ##::::::: ##:::: ##::'##:. ##:: ##:::: ##: ##::::::: ##:::: ##::::::::::::::::", screenSize);
        Out.center(" ##::::::: ##:::: ##:'##:::. ##: ##:::: ##: ######::: ##:::: ##::::::::::::::::", screenSize);
        Out.center(" ##::::::: ##:::: ##: #########: ##:::: ##: ##...:::: ##:::: ##::::::::::::::::", screenSize);
        Out.center(" ##::::::: ##:::: ##: ##.... ##: ##:::: ##: ##::::::: ##:::: ##:'###:'###:'###:", screenSize);
        Out.center(" ########:. #######:: ##:::: ##: ########:: ########: ########:: ###: ###: ###:", screenSize);
        Out.center("........:::.......:::..:::::..::........:::........::........:::...::...::...::", screenSize);

        //add vertical spaces
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();
        space();

        //add a delay
        time(500);
    }

    //-------------------------------pause-----------------------------------
    public void pause() throws Exception{
        Out.center("Press the ENTER key to continue", screenSize);
        br.readLine();
    }

    //-------------------------------clear-----------------------------------
    public void clear(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    //-----------------------------vertical space----------------------------
    public void space(){
        System.out.println("");
    }

    //----------------------add delay----------------------------
    public void time(int n) throws InterruptedException {
        Thread.sleep(n);
    }

    //----------------------------------------random move--------------------------------
    public void moveRandom(){
        int num;
        do {
            num = (int) Math.abs(Math.random() * 9 + 1);
        }while(isOccupied(num));
        int col = 0, row = 0;
        if(num < 4){
            row = 0;
            col = num-1;
        }else if (num < 7){
            row = 1;
            col = num-4;
        }else if (num < 10 ){
            row = 2;
            col = num-7;
        }
        game[row][col] = "X";
    }

    //----------------------------------algorithm------------------------------------
    public void algorithmFirst(){
        if(isThereTwo()){
            game[rowBlock][colBlock] = "X";
            rowBlock = -1;
            colBlock = -1;

        }else if(isThereTwoO()){
            game[rowWin][colWin] = "X";
            rowWin = -1;
            colWin = -1;
        }else if(!isOccupied(5)){
            game[1][1] = "X";
        }else if(!isOccupied(8)){
            game[2][1] = "X";
        }else if(game[1][1].equals("X") && game[2][1].equals("X")){
            if(!isOccupied(2)){
                game[0][1] = "X";
            }else if(!isOccupied(3)){
                game[0][2] = "X";
            } else if(!isOccupied(4)){
                game[1][0] = "X";
            } else if(!isOccupied(7)){
                game[2][0] = "X";
            }
        } else if(!isOccupied(8)) {
            game[2][1] = "X";
        }else if(!isOccupied(7)){
            game[2][0] = "X";
        }else{
            moveRandom();
        }
    }

    //-----------------------------check for offense------------------------------
    public boolean isThereTwoO(){
        if(!isTwoRowO() && !isTwoColO() && !isTwoDiagO()){
            return true;
        }else{
            return false;
        }
    }

    //------------------------------subsets to check for two in a row-------------
    public boolean isTwoRowO(){
        for(int row = 0; row<3; row++){
            if(game[row][0].equals(game[row][1]) && game[row][0].equals("X")){
                rowWin = row;
                colWin = 2;
                return true;
            } else if(game[row][0].equals(game[row][2]) && game[row][0].equals("X")){
                rowWin = row;
                colWin = 1;
                return true;
            } else if(game[row][1].equals(game[row][2]) && game[row][1].equals("X")){
                rowWin = row;
                colWin = 0;
                return true;
            }
        }
        return false;
    }

    public boolean isTwoColO() {
        for (int col = 0; col < 3; col++) {
            if (game[0][col].equals(game[1][col]) && game[0][col].equals("X")) {
                rowWin = 2;
                colWin = col;
                return true;
            } else if (game[0][col].equals(game[2][col]) && game[0][col].equals("X")) {
                rowWin = 1;
                colWin = col;
                return true;
            } else if (game[1][col].equals(game[2][col]) && game[1][col].equals("X")) {
                rowWin = 0;
                colWin = col;
                return true;
            }
        }
        return false;
    }

    public boolean isTwoDiagO(){
        //Check first diagonal
        if(game[0][0].equals(game[1][1]) && game[0][0].equals("X")){
            rowWin = 2;
            colWin = 2;
            return true;
        }else if(game[1][1].equals(game[2][2]) && game[1][1].equals("X")){
            rowWin = 0;
            colWin = 0;
            return true;
        }else if(game[0][0].equals(game[2][2]) && game[0][0].equals("X")){
            rowWin = 1;
            colWin = 1;
            return true;
        }

        //check second diagonal
        if(game[0][2].equals(game[1][1]) && game[0][2].equals("X")){
            rowWin = 2;
            colWin = 0;
            return true;
        }else if(game[1][1].equals(game[2][0]) && game[1][1].equals("X")){
            rowWin = 0;
            colWin = 2;
            return true;
        }else if(game[0][2].equals(game[2][0]) && game[0][2].equals("X")){
            rowWin = 1;
            colWin = 1;
            return true;
        }
        return false;
    }

    //---------------------------------check for two in a row---------------------
    public boolean isThereTwo(){
        if(!isTwoRow() && !isTwoRow() && !isTwoDiag()){
            return true;
        }else{
            return false;
        }
    }

    //------------------------------subsets to check for two in a row-------------
    public boolean isTwoRow(){
        for(int row = 0; row<3; row++){
            if(game[row][0].equals(game[row][1]) && game[row][0].equals("O")){
                rowBlock = row;
                colBlock = 2;
                return true;
            } else if(game[row][0].equals(game[row][2]) && game[row][0].equals("O")){
                rowBlock = row;
                colBlock = 1;
                return true;
            } else if(game[row][1].equals(game[row][2]) && game[row][1].equals("O")){
                rowBlock = row;
                colBlock = 0;
                return true;
            }
        }
        return false;
    }

    public boolean isTwoCol() {
        for (int col = 0; col < 3; col++) {
            if (game[0][col].equals(game[1][col]) && game[0][col].equals("O")) {
                rowBlock = 2;
                colBlock = col;
                return true;
            } else if (game[0][col].equals(game[2][col]) && game[0][col].equals("O")) {
                rowBlock = 1;
                colBlock = col;
                return true;
            } else if (game[1][col].equals(game[2][col]) && game[1][col].equals("O")) {
                rowBlock = 0;
                colBlock = col;
                return true;
            }
        }
        return false;
    }

    public boolean isTwoDiag(){
        //Check first diagonal
        if(game[0][0].equals(game[1][1]) && game[0][0].equals("O")){
            rowBlock = 2;
            colBlock = 2;
            return true;
        }else if(game[1][1].equals(game[2][2]) && game[1][1].equals("O")){
            rowBlock = 0;
            colBlock = 0;
            return true;
        }else if(game[0][0].equals(game[2][2]) && game[0][0].equals("O")){
            rowBlock = 1;
            colBlock = 1;
            return true;
        }

        //check second diagonal
        if(game[0][2].equals(game[1][1]) && game[0][2].equals("O")){
            rowBlock = 2;
            colBlock = 0;
            return true;
        }else if(game[1][1].equals(game[2][0]) && game[1][1].equals("O")){
            rowBlock = 0;
            colBlock = 2;
            return true;
        }else if(game[0][2].equals(game[2][0]) && game[0][2].equals("O")){
            rowBlock = 1;
            colBlock = 1;
            return true;
        }
        return false;
    }
}
