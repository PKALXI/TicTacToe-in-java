package com.company;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Player_Vs_Player {

    Scanner in = new Scanner(System.in);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String winningLetter;

    boolean tracing;

    runGame r;

    Main m;

    int screenSize;

    //Create game board
    String [] [] game = {
            {"1", "2","3"},
            {"4","5","6"},
            {"7","8","9"}
    };

    public Player_Vs_Player(int n)throws Exception{
        screenSize = n;

        Out.centerWrite("Welcome to Player vs. Player", screenSize);
        Out.centerWrite("'X' will go first", screenSize);

        reset();
        do{
            //check if it is a tie
            if(!isGameOver() && areAllSquaresQccupied()){
                Out.centerWrite("It's a tie.",screenSize);
                break;
            }

            printGame();
            askPlayerToMoveX();
            printGame();

            //check if it is a tie
            if(!isGameOver() && areAllSquaresQccupied()){
                Out.centerWrite("It's a tie.",screenSize);
                break;
            }

            if(isGameOver())break;
            askPlayerToMoveO();
            printGame();

            //check if it is a tie
            if(!isGameOver() && areAllSquaresQccupied()){
                Out.centerWrite("It's a tie.",screenSize);
                break;
            }
        }while(!isGameOver());

        if(isGameOver())Out.centerWrite("Game over, " + winningLetter + " wins.", screenSize);
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

    //-----------------------------------ask for player X move--------------------------
    public void askPlayerToMoveX(){
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

        game[row][col] = "X";
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
}
