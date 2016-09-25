package io.github.qetennyson.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    private TicTacToeGame newGame = new TicTacToeGame();

    private TextView toeBoard[];

    private static int player;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toeBoard = new TextView[newGame.getBOARD_SIZE()];

        TextView btn0 = (TextView)findViewById(R.id.textView0);
        btn0.setOnClickListener(btnListener);
        TextView btn1 = (TextView)findViewById(R.id.textView1);
        btn1.setOnClickListener(btnListener);
        TextView btn2 = (TextView)findViewById(R.id.textView2);
        btn2.setOnClickListener(btnListener);
        TextView btn3 = (TextView)findViewById(R.id.textView3);
        btn3.setOnClickListener(btnListener);
        TextView btn4 = (TextView)findViewById(R.id.textView4);
        btn4.setOnClickListener(btnListener);
        TextView btn5 = (TextView)findViewById(R.id.textView5);
        btn5.setOnClickListener(btnListener);
        TextView btn6 = (TextView)findViewById(R.id.textView6);
        btn6.setOnClickListener(btnListener);
        TextView btn7 = (TextView)findViewById(R.id.textView7);
        btn7.setOnClickListener(btnListener);
        TextView btn8 = (TextView)findViewById(R.id.textView8);
        btn8.setOnClickListener(btnListener);

        toeBoard[0] = btn0;
        toeBoard[1] = btn1;
        toeBoard[2] = btn2;
        toeBoard[3] = btn3;
        toeBoard[4] = btn4;
        toeBoard[5] = btn5;
        toeBoard[6] = btn6;
        toeBoard[7] = btn7;
        toeBoard[8] = btn8;





        newGame = new TicTacToeGame();

    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            TextView button = (TextView)v;

            if (player == 1) {
                button.setText("O");
            } else if (player == 2) {
                button.setText("X");
            }

            newGame.crazyShit(v);
            newGame.gameState();

            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }



        }
    };




}
