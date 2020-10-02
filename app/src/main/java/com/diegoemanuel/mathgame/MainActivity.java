package com.diegoemanuel.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView maxscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences("MAX_SCORE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        maxscore =  findViewById(R.id.TextView_high);
        maxscore.setText("Record : " + preferences.getInt("max", 0));

    }

    public void activity2(View v){
        Intent goToSecond = new Intent();
        goToSecond.setClass(this, game.class);
        startActivity(goToSecond);
        finish();
    }

    public void myProfile(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Spicygarn"));
        startActivity(browserIntent);
    }

}
