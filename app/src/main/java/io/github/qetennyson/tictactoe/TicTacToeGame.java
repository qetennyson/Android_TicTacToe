package io.github.qetennyson.tictactoe;

import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Quincy Tennyson on 9/24/16.
 */
public class TicTacToeGame {


    private String toeBoard[];
    private static int BOARD_SIZE = 9;

    public static String PLAYER_1 = "X";
    public static String PLAYER_2 = "O";
    public static String EMPTY = " ";


    public TicTacToeGame(){

        toeBoard = new String[BOARD_SIZE];

        for (int i=0; i<BOARD_SIZE; i++){
            toeBoard[i] = EMPTY;
        }


    }


    public void clearState(){
        for (int i = 0; i < BOARD_SIZE; i++){
            toeBoard[i] = EMPTY;
        }
    }

    //allows us to pull board size
    public static int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    //this is hitting a win every time.  it seems checkWinner is still not working correctly...thought I had
    //this fixed last night, but apparently not.
    public void gameState(){


        if (checkWinner() == 2) {
            System.out.println("Player 1 has Won!");
        } else if (checkWinner() == 3) {
            System.out.println("Player 2 has Won!");
        } else if (checkWinner() == 1) {
            System.out.println("Game is Tied");
        }
    }

    //originally was going to setPlayer here, but got too confusing.

    /*public void setPlayer(){
        while (checkWinner() .equals(){
     )       if (player .equals(LAYER_1)){
                player = PLAYER_2;
            } else {
                player = PLAYER_1;
            }
        }
    }*/

    //this parses whatever is set on the TextView because I"m a horrible programmer and this is what we're doing today
    public void textParser(View v){

        TextView view = (TextView)v;

        for (int i = 0; i <= 8; i++){
            toeBoard[i] = view.getText().toString();
        }
    }
    //this method checks the board for all possible win conditions
    //while the logic seems sound, for whatever reason designating a space as either X or O will simply
    //state that whatever player clicked has won.  I have not yet figured that out.
    public int checkWinner(){
        //this loop checks all rows
        for (int i = 0; i <= 6; i +=3)
        {
            if (toeBoard[i].equals(PLAYER_1) &&
                    toeBoard[i+1].equals(PLAYER_1) &&
                    toeBoard[i+2].equals(PLAYER_1))
                return 2;
            if (toeBoard[i].equals(PLAYER_2) &&
                    toeBoard[i+1].equals(PLAYER_2) &&
                    toeBoard[i+2].equals(PLAYER_2))
                return 3;
        }

        //this loop checks all columns
        for (int i = 0; i <= 2; i++)
        {3
            if (toeBoard[i] .equals(PLAYER_1) &&
                    toeBoard[i+3] .equals(PLAYER_1) &&
                    toeBoard[i+6] .equals(PLAYER_1))
                return 2;
            if (toeBoard[i].equals(PLAYER_2) &&
                    toeBoard[i+3].equals(PLAYER_2) &&
                    toeBoard[i+6].equals(PLAYER_2))
                return 3;
        }

        //this checks the diagonals
        if((toeBoard[0] .equals(PLAYER_1) &&
                toeBoard[4] .equals(PLAYER_1) &&
                toeBoard[8] .equals(PLAYER_1)) ||
                    toeBoard[2] .equals(PLAYER_1) &&
                    toeBoard[4] .equals(PLAYER_1) &&
                    toeBoard[6] .equals(PLAYER_1))
            return 2;
        if((toeBoard[0].equals(PLAYER_2) &&
                toeBoard[4].equals(PLAYER_2) &&
                toeBoard[8].equals(PLAYER_2)) ||
                    toeBoard[2].equals(PLAYER_2) &&
                    toeBoard[4].equals(PLAYER_2) &&
                    toeBoard[6].equals(PLAYER_2))
            return 3;

        //checks for open spaces on the board
        for (int i = 0; i < getBOARD_SIZE(); i++){
            if (toeBoard[i] != PLAYER_1 && toeBoard[i] != PLAYER_2)
                return 0;
        }

        //after all other possibilities have been ruled out, render a TIE state
        return 1;
    }


}
