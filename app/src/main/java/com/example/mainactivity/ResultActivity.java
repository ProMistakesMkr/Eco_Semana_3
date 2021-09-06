package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView titleResult, textResult, textResultNota;
    private Button AgainButton;
    private ConstraintLayout bgResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        titleResult = findViewById(R.id.titleResult);
        textResult = findViewById(R.id.textResult);
        textResultNota = findViewById(R.id.textResultNota);
        AgainButton = findViewById(R.id.calcAgainButton);
        bgResult = findViewById(R.id.bgResult);

        //De result a main
        AgainButton.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this,MainActivity.class);
                    startActivity(i);
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Color
        SharedPreferences sp = getSharedPreferences("colors",MODE_PRIVATE);
        String color = sp.getString("color","#FFFFFF");
        bgResult.setBackgroundColor(Color.parseColor(color));

        //Text with name

        textResult.setText("Hola "+sp.getString("name","estudiante")+", tu nota final es de:");

        //Recibir y mostrar la nota
        String nota = Float.toString((getIntent().getExtras().getFloat("nota")));
        String finalGrade = nota.substring(0,3);
        textResultNota.setText(finalGrade);
    }
}