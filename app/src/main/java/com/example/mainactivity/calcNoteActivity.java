package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calcNoteActivity extends AppCompatActivity {

    private TextView titleTextCalc;
    private EditText textEditNota1, textEditNota2, textEditNota3, textEditNota4, textEditNota5;
    private Button calcButton;
    private ConstraintLayout bgCalcNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_note);

        titleTextCalc = findViewById(R.id.titleTextCalc);
        textEditNota1 = findViewById(R.id.textEditNota1);
        textEditNota2 = findViewById(R.id.textEditNota2);
        textEditNota3 = findViewById(R.id.textEditNota3);
        textEditNota4 = findViewById(R.id.textEditNota4);
        textEditNota5 = findViewById(R.id.textEditNota5);
        calcButton = findViewById(R.id.calcButton);
        bgCalcNote = findViewById(R.id.bgCalcNote);

        //De calcNote a result
        calcButton.setOnClickListener(
                (v) ->{
                    if(!textEditNota1.getText().toString().isEmpty()&&
                            !textEditNota2.getText().toString().isEmpty()&&
                            !textEditNota3.getText().toString().isEmpty()&&
                            !textEditNota4.getText().toString().isEmpty()&&
                            !textEditNota5.getText().toString().isEmpty()) {
                        float finalgrade = (float) calcNote();

                        Intent i = new Intent(this,ResultActivity.class);
                        i.putExtra("nota",finalgrade);
                        startActivity(i);

                    }else{
                        Toast.makeText(this, "Ingresa toda las notas", Toast.LENGTH_SHORT).show();
                    }

                });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Color
        SharedPreferences sp = getSharedPreferences("colors",MODE_PRIVATE);
        String color = sp.getString("color","#FFFFFF");
        bgCalcNote.setBackgroundColor(Color.parseColor(color));
    }

    public double calcNote(){
        float nota1;
        float nota2;
        float nota3;
        float nota4;
        float nota5;
        float finalGrade;


        nota1 = Float.parseFloat(textEditNota1.getText().toString());
        nota2 = Float.parseFloat(textEditNota2.getText().toString());
        nota3 = Float.parseFloat(textEditNota3.getText().toString());
        nota4 = Float.parseFloat(textEditNota4.getText().toString());
        nota5 = Float.parseFloat(textEditNota5.getText().toString());

        finalGrade = (float) ((nota1 * 0.25) + (nota2 * 0.25) + (nota3 * 0.15) + (nota4 * 0.15) + (nota5 * 0.15));

        return finalGrade;
    }
}