package com.company;
import java.util.*;
import java.io.*;

public class runGame {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //Declare Scanner for input
    Scanner in = new Scanner(System.in);

    //Create Main object
    Main m;

    //Create game board
    String [] [] game = {
            {"1", "2","3"},
            {"4","5","6"},
            {"7","8","9"}
    };

    //create boolean controling tracing statments
    boolean tracing = false;

    int screenSize = m.screenSize;

    //Variable to store the letter that won
    String winningLetter;

    //----------------------------------------play against menu-------------------------------------------
    public runGame() throws Exception {
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
                System.out.println("The computer moves first");

                //computer goes first
                comMoveFirst();
                do {
                    printGame();
                    askPlayerToMove();
                    printGame();
                }while(!isGameOver());

            }else if(num == 1){
                //player goes first
                System.out.println("p v. p");
            }

            in.nextLine();

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
                game [i][j] = String.valueOf(j+1+i);
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
            System.out.print("type the number where you would like to move: ");
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

    //---------------------algorithm,

}

