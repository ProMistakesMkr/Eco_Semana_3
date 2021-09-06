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

public class MainActivity extends AppCompatActivity {

    private Button configBttn;
    private Button contBttn;
    private TextView textMain;
    private EditText textName;
    private ConstraintLayout bgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configBttn = findViewById(R.id.configButton);
        contBttn = findViewById(R.id.continueButton);
        textMain = findViewById(R.id.textMain);
        textName = findViewById(R.id.textEditName);
        bgMain = findViewById(R.id.bgMain);

                configBttn.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this,configActivity.class);
                    startActivity(i);
                });

        //Change color
        SharedPreferences sp1 = getSharedPreferences("colors",MODE_PRIVATE);

                contBttn.setOnClickListener(
                (v) ->{
                    if(!textName.getText().toString().replaceAll(" ","").isEmpty()){
                        sp1.edit().putString("name", textName.getText().toString().trim()).apply();
                        Intent i = new Intent(this,calcNoteActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(this, "Ingresa un nombre", Toast.LENGTH_SHORT).show(); //mensaje para cuando deje en vacio
                    }
                });
    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("colors",MODE_PRIVATE);
        String color = sp.getString("color","#FFFFFF");
        bgMain.setBackgroundColor(Color.parseColor(color));
    }
}