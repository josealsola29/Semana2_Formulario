package com.example.semana2_formulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText tilName;
    private TextInputEditText tilTelephone;
    private TextInputEditText tilEmail;
    private TextInputEditText tilDescription;
    private CalendarView calendarView;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilName = findViewById(R.id.tilName);
        tilTelephone = findViewById(R.id.tilTelephone);
        tilEmail = findViewById(R.id.tilEmail);
        tilDescription = findViewById(R.id.tilDescription);
        calendarView = findViewById(R.id.calendarView);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                intent.putExtra("name", tilName.getText().toString());
                intent.putExtra("tellphone", tilTelephone.getText().toString());
                intent.putExtra("email", tilEmail.getText().toString());
                intent.putExtra("description", tilDescription.getText().toString());
                intent.putExtra("date", calendarView.getDate());
                startActivity(intent);


            }
        });


    }
}