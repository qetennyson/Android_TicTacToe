package io.github.qetennyson.tictactoe;

import java.util.Random;

/**
 * Created by Quincy Tennyson on 9/24/16.
 */
public class TicTacToeGame {


    private char toeBoard[];
    private static int BOARD_SIZE = 9;

    public static char PLAYER_1 = 'X';
    public static char PLAYER_2 = 'O';
    public static char EMPTY = ' ';

    private Random toeRand;

    public TicTacToeGame(){

        toeBoard = new char[BOARD_SIZE];

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

    public void gameState(){
        if (checkWinner() == 2){
            System.out.println("Player 1 has Won!");
        } else if (checkWinner() == 3) {
            System.out.println("Player 2 has Won!");
        } else if (checkWinner() == 0) {
            // need to figure out how to alternate players
        } else if (checkWinner() == 1) {
            System.out.println("The Game has Tied");
        }
    }


    //this method checks the board for all possible win conditions
    public int checkWinner(){
        //this loop checks all rows
        for (int i = 0; i <= 6; i +=3)
        {
            if (toeBoard[i] == PLAYER_1 &&
                    toeBoard[i+1] == PLAYER_1 &&
                    toeBoard[i+2] == PLAYER_1)
                return 2;
            if (toeBoard[i] == PLAYER_2 &&
                    toeBoard[i+1] == PLAYER_2 &&
                    toeBoard[i+2] == PLAYER_2)
                return 3;
        }

        //this loop checks all columns
        for (int i = 0; i <= 2; i++)
        {
            if (toeBoard[i] == PLAYER_1 &&
                    toeBoard[i+3] == PLAYER_1 &&
                    toeBoard[i+6] == PLAYER_1)
                return 2;
            if (toeBoard[i] == PLAYER_2 &&
                    toeBoard[i+3] == PLAYER_2 &&
                    toeBoard[i+6] == PLAYER_2)
                return 3;
        }

        //this loop checks the diagonals
        if((toeBoard[0] == PLAYER_1 &&
                toeBoard[4] == PLAYER_1 &&
                toeBoard[8] == PLAYER_1) ||
                toeBoard[2] == PLAYER_1 &&
                        toeBoard[4] == PLAYER_1 &&
                        toeBoard[6] == PLAYER_1)
            return 2;
        if((toeBoard[0] == PLAYER_2 &&
                toeBoard[4] == PLAYER_2 &&
                toeBoard[8] == PLAYER_2) ||
                toeBoard[2] == PLAYER_2 &&
                        toeBoard[4] == PLAYER_2 &&
                        toeBoard[6] == PLAYER_2)
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
