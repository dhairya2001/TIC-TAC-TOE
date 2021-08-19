package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;

    int activeplayer = 1;
    //    0-O
    //    1-X
    //    2-Null
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winpos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void playertap(View view) {
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(view.getTag().toString());
        if (!gameactive) {
            gamereset(view);
        }
        if (gamestate[tappedimage] == 2 && gameactive) {
            gamestate[tappedimage] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.o);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn Tap to play");
            } else {
                img.setImageResource(R.drawable.xx);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int[] winpos : winpos) {
            if (gamestate[winpos[0]] == gamestate[winpos[1]] && gamestate[winpos[1]] == gamestate[winpos[2]] && gamestate[winpos[0]] != 2) {
                String winner;
                gameactive=false;
                if (gamestate[winpos[0]] == 0) {
                    winner = "O has Won!!";
                } else {
                    winner = "X has Won!!";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }
        }
    }
    public void gamereset(View view){
        gameactive = true;
        activeplayer = 0;
        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn Tap to play");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}