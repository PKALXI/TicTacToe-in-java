/*
 *File name: Out.java
 *Number of classes: 3
 *Name of other two classes: MyReceipt.java, CreateReceipt.java
 *Name: Receipt Generator 5000
 *Brief Description: Create a receipt faster than Usain Bolt can run a race
 *Author of this program: Pranav Kalsi
 *Start Date: Deceber 10th 2018
 *End Date: December 21th 2018
 */

import java.text.*;
import java.lang.*;

public class Out
{
    public static void println ()
    {
        System.out.println();
    }

    public static void print (double n, int fieldWidth, int decimalPlaces)
    {
        String format = "0.";
        for (int i = 0; i < decimalPlaces; i++)
            format = format + "0";
        NumberFormat form = new DecimalFormat(format);
        String s = form.format(n);
        int stop = fieldWidth - s.length();
        for (int i = 0; i < stop; i++)
            s = " " + s;
        System.out.print(s);
    }

    public static void println (double n, int fieldWidth, int decimalPlaces)
    {
        print(n, fieldWidth, decimalPlaces);
        System.out.println();
    }

    public static void printCurrency (double n, int fieldWidth, int decimalPlaces)
    {
        String format = "$0.";
        for (int i = 0; i < decimalPlaces; i++)
            format = format + "0";
        NumberFormat form = new DecimalFormat(format);
        String s = form.format(n);
        int stop = fieldWidth - s.length();
        for (int i = 0; i < stop; i++)
            s = " " + s;
        System.out.print(s);
    }

    public static void printlnCurrency (double n, int fieldWidth, int decimalPlaces)
    {
        printCurrency(n, fieldWidth, decimalPlaces);
        System.out.println();
    }

    public static void print (double n)
    {
        System.out.print(n);
    }

    public static void println (double n)
    {
        print(n);
        System.out.println();
    }

    public static void print (long n, int fieldWidth)
    {
        String s = String.valueOf(n);
        int stop = fieldWidth - s.length();
        for (int i = 0; i < stop; i++)
            s = " " + s;
        System.out.print(s);
    }

    public static void println (long n, int fieldWidth)
    {
        print(n, fieldWidth);
        System.out.println();
    }

    public static void print (long n)
    {
        System.out.print(n);
    }

    public static void println (long n)
    {
        print(n);
        System.out.println();
    }

    public static void print (String s, int fieldWidth)
    {
        int stop = fieldWidth - s.length();
        if (s.length() > fieldWidth)
            s = s.substring(0, fieldWidth);
        else
            for (int i = 0; i < stop; i++)
                s = " " + s;
        System.out.print(s);
    }

    public static void println (String s, int fieldWidth)
    {
        print(s, fieldWidth);
        System.out.println();
    }

    public static void printLeft (String s, int fieldWidth)
    {
        int stop = fieldWidth - s.length();
        if (s.length() > fieldWidth)
            s = s.substring(0, fieldWidth);
        else
            for (int i = 0; i < stop; i++)
                s = s + " ";
        System.out.print(s);
    }

    public static void printlnLeft (String s, int fieldWidth)
    {
        printLeft(s, fieldWidth);
        System.out.println();
    }

    public static void print (String s)
    {
        System.out.print(s);
    }

    public static void println (String s)
    {
        System.out.println(s);
    }

    public static void print (char c, int fieldWidth)
    {
        String s = String.valueOf(c);
        int stop = fieldWidth - 1;
        for (int i = 0; i < stop; i++)
            s = " " + s;
        System.out.print(s);
    }

    public static void println (char c, int fieldWidth)
    {
        print(c, fieldWidth);
        System.out.println();
    }

    public static void print (char c)
    {
        System.out.print(c);
    }

    public static void println (char c)
    {
        System.out.println(c);
    }

    public static void center (String s, int n)
    {
        for(int x=0; x<(n-s.length())/2; x++){
            System.out.print(" ");
        }
        System.out.println(s);
    }

    public static void write(String str) throws Exception{
        char [] theArray = str.toCharArray();

        for(int i = 0; i < theArray.length; i++){
            if(theArray[i] == ' '){
                System.out.print(theArray[i]);
                Thread.sleep(50);
            }else{
                System.out.print(theArray[i]);
                Thread.sleep(100);
            }

        }
    }

    public static void writeln(String str)throws Exception{
        write(str);
        System.out.println();
    }

    public static void centerWrite(String str, int n)throws Exception{
        char [] theArray = str.toCharArray();

        for(int i = 0; i < (n-str.length())/2; i++){
            System.out.print(" ");
        }

        for(int i = 0; i < theArray.length; i++){
            if(theArray[i] == ' '){
                System.out.print(theArray[i]);
                Thread.sleep(50);
            }else{
                System.out.print(theArray[i]);
                Thread.sleep(100);
            }
        }
        System.out.println("");
    }
}
