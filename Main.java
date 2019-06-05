/*
 *File name: Main.java
 *Number of classes: 4
 *Name of other three class: Out.java, runGameEasy.java
 *Name: Pranav's Elite Tic Tac Toe
 *Brief Description: This game allows you to play tic tac toe against a friend or the eas mode on the computer
 *Author of this program: Pranav Kalsi
 *Start Date: May 5th 2019
 *End Date: June 4th 2019
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.math.*;

public class Main{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int screenSize;

    runGame r;

    boolean tracing = false;

    public static void main(String[] args)throws Exception{
        new Main();
    }
    public Main()throws Exception{

        setScreenSize();

        clear();

        if(tracing) System.out.println("Menu has been run");

        while(true){
            menu();
        }
    }

    //-------------------------------------menu------------------------------------------
    public void menu() throws Exception {
        //variable to hold user input on the menu
        int choice;

        //Insert ASCII art
        Out.center("     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", screenSize);
        Out.center("    d'                                                                    8", screenSize);
        Out.center("  P'                                                                     8", screenSize);
        Out.center("dbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa        8", screenSize);
        Out.center("8                                                              d 8        8", screenSize);
        Out.center("8                                                             d' 8        8", screenSize);
        Out.center("8        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaad'  8        8", screenSize);
        Out.center("8        8   8                                               8   8        8", screenSize);
        Out.center("8        8   8                                               8   8        8", screenSize);
        Out.center("8        8  8aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa8aaa8        8", screenSize);
        Out.center("8        8 P                                                             8", screenSize);
        Out.center("8        8P                                                              8", screenSize);
        Out.center("8        8baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaad'", screenSize);
        Out.center("8                                                                       d'", screenSize);
        Out.center("8                                                                      d'", screenSize);
        Out.center("8aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaP'", screenSize);

        //Insert figlet text
        Out.center("##::::'##:'########:'##::: ##:'##::::'##:", screenSize);
        Out.center("###::'###: ##.....:: ###:: ##: ##:::: ##:", screenSize);
        Out.center("####'####: ##::::::: ####: ##: ##:::: ##:", screenSize);
        Out.center("## ### ##: ######::: ## ## ##: ##:::: ##:", screenSize);
        Out.center("##. #: ##: ##...:::: ##. ####: ##:::: ##:", screenSize);
        Out.center("##:.:: ##: ##::::::: ##:. ###: ##:::: ##:", screenSize);
        Out.center("##:::: ##: ########: ##::. ##:. #######::", screenSize);
        Out.center("..:::::..::........::..::::..:::.......:::", screenSize);

        space();//add a linespace

        //give options
        Out.print("", (screenSize-40)/2);
        Out.printlnLeft("Enter '1' for Instructions", 40);

        space();//add a linespace

        Out.print("", (screenSize-40)/2);
        Out.printlnLeft("Enter '2' to Run The Easy Tic Tac Toe vs. the computer", 60);

        space();//add a linespace

        Out.print("", (screenSize-40)/2);
        Out.printlnLeft("Enter '3' to Run The Player vs. Player", 40);

        space();//add a linespace

        Out.print("", (screenSize-40)/2);
        Out.printlnLeft("Enter '4' Exit the program", 40);

        space();//add a linespace

        //ask for input (which option from the menu)
        Out.print("", (screenSize-40)/2);
        Out.printLeft("Enter your choice: ", 19);
        choice = Integer.parseInt(br.readLine());// where to go in the program

        //This section decides where to go after input
        switch (choice) {
            case 1:
                //clear screen then go to instructions
                clear();

                //Go to the instructions
                instructions();
                break;
            case 2:
                //clear the screen
                clear();

                //display loading screen
                load();
                pause();
                clear();


                //go to the easy tic tac toe
                new runGameEasy(screenSize);

                break;

            case 3:
                //clear the screen
                clear();

                //Enter player vs. Player Mode
                new Player_Vs_Player(screenSize);

                break;
            case 4:
                //clear the screen
                clear();

                //farewell screen
                exit();
            default:
                //The default if a option not there is entered
                clear();
                Out.center("Please enter one of the options please try again in 3 seconds.", screenSize);
                Thread.sleep(3000);
                clear();
                break;
        }//end of switch
    }


    //-----------------------------------Entering Screen (for setting the screen size)--------------------------------
    public void setScreenSize() throws Exception {

        //add space
        space();
        space();
        space();

        //indent 25 spaces and ask for screen size for centering
        Out.print("", 25);
        Out.writeln("Hello, welcome To The Tic Tac Toe");

        time(1000);

        space();

        Out.print("", 25);
        Out.writeln("You will have a more formal welcome later...");
        time(1000);
        space();
        Out.print("", 25);
        Out.writeln("I  recommend you set your screen size to 146 x 37, for optimal performance...");
        space();
        Out.print("", 25);

        //ask for screen size
        Out.write("Enter your current screen width: ");
        screenSize = Integer.parseInt(br.readLine());

        //Add a vertical space
        space();

        //Add figlet text
        Out.center(" ### ### ###   #    ###   ###     ##  # ## #####    ####  ####  ##  ### ##### ### ##  ### ### ### ##### ", screenSize);
        Out.center("#  #  #   #    ##    #     #       # ##  #  #  #   ##  # ##  ##  ##  #    #    #   ##  #   #   #   #  # ", screenSize);
        Out.center("###   #####   # #    #     #       # ## #   ###    #     #    #  ### #    #    #   ### #   #   #   ###  ", screenSize);
        Out.center("  ##  #   #   ####   #     #       # ## #   #      #     #    #  # ###    #    #   # ###   #   #   #    ", screenSize);
        Out.center("#  #  #   #  #   #   #  #  #  #     #  ##   #  #   ##    ##  ##  #  ##    #    #   #  ##   #   #   #  # ", screenSize);
        Out.center("###  ### ### #   ## ##### #####     #  #   #####    ####  ####  ###  #   ###  ### ###  #   #####  ##### ", screenSize);
    }

    //--------------------------------------------exit--------------------------------------
    public void exit() throws Exception {
        //clear the screen
        clear();

        //Insert figlet text
        Out.center("'########:'##::::'##::::'###::::'##::: ##:'##:::'##::'######::", screenSize);
        Out.center("... ##..:: ##:::: ##:::'## ##::: ###:: ##: ##::'##::'##... ##:", screenSize);
        Out.center("::: ##:::: ##:::: ##::'##:. ##:: ####: ##: ##:'##::: ##:::..::", screenSize);
        Out.center("::: ##:::: #########:'##:::. ##: ## ## ##: #####::::. ######::", screenSize);
        Out.center("::: ##:::: ##.... ##: #########: ##. ####: ##. ##::::..... ##:", screenSize);
        Out.center("::: ##:::: ##:::: ##: ##.... ##: ##:. ###: ##:. ##::'##::: ##:", screenSize);
        Out.center("::: ##:::: ##:::: ##: ##:::: ##: ##::. ##: ##::. ##:. ######::", screenSize);
        Out.center(":::..:::::..:::::..::..:::::..::..::::..::..::::..:::......:::", screenSize);

        Out.center("for coming by... This program was created by Pranav Kalsi", screenSize);

        Out.center("I hope you enjoyed this game as much as I did making it!!!", screenSize);

        space();//add a linespace

        time(1000);//add delay

        //start countdown
        Out.center("5", screenSize);

        space();//insert line space

        time(1000);//add delay

        Out.center("4", screenSize);

        space();

        time(1000);

        Out.center("3", screenSize);

        space();

        time(1000);

        Out.center("2", screenSize);

        space();

        time(1000);

        Out.center("1", screenSize);

        space();

        time(1000);

        //Stop the program and exit
        Out.center("Bye", screenSize);
        time(1000);
        System.exit(0);

    }

    //-----------------------------------instructions------------------------------------
    public void instructions() throws Exception {
        //display figlet text
        Out.center("#### ##    ##  ######  ######## ########  ##     ##  ######  ######## ####  #######  ##    ##  ###### ", screenSize);
        Out.center(" ##  ###   ## ##    ##    ##    ##     ## ##     ## ##    ##    ##     ##  ##     ## ###   ## ##    ## ", screenSize);
        Out.center(" ##  ####  ## ##          ##    ##     ## ##     ## ##          ##     ##  ##     ## ####  ## ##       ", screenSize);
        Out.center(" ##  ## ## ##  ######     ##    ########  ##     ## ##          ##     ##  ##     ## ## ## ##  ######  ", screenSize);
        Out.center(" ##  ##  ####       ##    ##    ##   ##   ##     ## ##          ##     ##  ##     ## ##  ####       ## ", screenSize);
        Out.center(" ##  ##   ### ##    ##    ##    ##    ##  ##     ## ##    ##    ##     ##  ##     ## ##   ### ##    ## ", screenSize);
        Out.center("#### ##    ##  ######     ##    ##     ##  #######   ######     ##    ####  #######  ##    ##  ######  ", screenSize);

        //SHOW INSTRUCTIONS
        //400ms delay
        time(400);

        //add 3 line spaces
        space();
        space();
        space();

        Out.centerWrite("This is a very easy process...Easier than the Frog Riddle if you ask me!", screenSize);

        space();

        Out.centerWrite("This is a the ultimate tic tac toe machine! Plaver vs. Player, easy and hard mode.", screenSize);

        //add 500ms delay
        time(500);

        space();

        Out.centerWrite("Follow the prompts and you will be good", screenSize);

        space();

        Out.centerWrite("You will now be returned to the menu", screenSize);

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
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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

/*
* MY TEST CASES
*
* MY TEST CASES WORKED PERFECTLY AND EACH EXPECTED OUTCOME WAS AN EXACT MATCH
* The only problem is I couldn't develop the full algorithm due to a logic error
*
* */
