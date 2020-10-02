package com.diegoemanuel.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class game extends AppCompatActivity {
    int totalPoints = 0;
    int Sum;
    private EditText enteredText;
    private Button verify;
    private TextView points;
    private TextView sum;
    String incorrect = "incorrect";
    String correct = "correct";
    String fill = "fill the field";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        random();
        enteredText = findViewById(R.id.editText);

        verify = findViewById(R.id.button_Ver);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int enText = Integer.parseInt(enteredText.getText().toString());
                    if (enText != Sum)
                        incorrect();
                    else
                        correct();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),fill,Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void random(){
        sum =  findViewById(R.id.textView_sum);
        int Numb1;
        int Numb2;
        int NumMax = 100;
        Numb1 = (int) (Math.random() * NumMax) + 1;
        Numb2 = (int) (Math.random() * NumMax) + 1;
        Sum = Numb1 + Numb2;
        sum.setText(Numb1 + " + " + Numb2 + " :");
    }

    public void correct(){
        SharedPreferences preferences = getSharedPreferences("MAX_SCORE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        points = findViewById(R.id.textView_points);
        Toast.makeText(getApplicationContext(),correct,Toast.LENGTH_SHORT).show();
        totalPoints = totalPoints + 1;
        points.setText("Score : " + totalPoints);
        enteredText.setText("");
        if (totalPoints > preferences.getInt("max", 0))
            editor.putInt("max", totalPoints);
            editor.commit();
        random();
    }

    public void incorrect(){
        Toast.makeText(getApplicationContext(),incorrect,Toast.LENGTH_SHORT).show();
        enteredText.setText("");
        random();
    }

}
