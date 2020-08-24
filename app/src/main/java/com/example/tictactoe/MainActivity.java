package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int Active = 0;
    boolean gameActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPosition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void playerTab(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!gameActive) {
            gameReset(view);
        }
        if (gameState[tappedImage] == 2 && gameActive) {
            gameState[tappedImage] = Active;
            img.setTranslationY(-1000f);
            if (Active == 0) {
                img.setImageResource(R.drawable.zeropng);
                Active = 1;
                TextView status = findViewById(R.id.textView);
                status.setText("X's turn");
            } else {
                img.setImageResource(R.drawable.xpng);
                Active = 0;
                TextView status = findViewById(R.id.textView);
                status.setText("O's turn");
            }
            for (int[] winPosition : winPosition) {
                if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                    String win;
                    gameActive=false;
                    if (gameState[winPosition[0]] == 0) {
                        win = "O has Won";
                    } else {
                        win = "X has won";
                    }
                    TextView status = findViewById(R.id.textView);
                    status.setText(win);
                }
            }
        }
        img.animate().translationYBy(1000f).setDuration(300);
    }

    public void gameReset(View view) {
        gameActive = true;
        Active = 0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView) findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView12)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView14)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView15)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView17)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView18)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView19)).setImageResource(0);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}