package com.example.semana2_formulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText tilName;
    private TextInputEditText tilTelephone;
    private TextInputEditText tilEmail;
    private TextInputEditText tilDescription;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilName = findViewById(R.id.tilName);
        tilTelephone = findViewById(R.id.tilTelephone);
        tilEmail = findViewById(R.id.tilEmail);
        tilDescription = findViewById(R.id.tilDescription);
        datePicker = findViewById(R.id.datePicker);
        Button btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                intent.putExtra("name", Objects.requireNonNull(tilName.getText()).toString());
                intent.putExtra("tellphone", Objects.requireNonNull(tilTelephone.getText()).toString());
                intent.putExtra("email", Objects.requireNonNull(tilEmail.getText()).toString());
                intent.putExtra("description", Objects.requireNonNull(tilDescription.getText()).toString());
                String dateFormat = datePicker.getDayOfMonth() + "/"
                        + datePicker.getMonth() + "/"
                        + datePicker.getYear();
                intent.putExtra("date", dateFormat);
                startActivity(intent);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String name = Objects.requireNonNull(extras).getString("name");
            String tellphone = extras.getString("tellphone");
            String email = extras.getString("email");
            String description = extras.getString("description");
//        String date = extras.getString("date");
            tilName.setText(name);
            tilTelephone.setText(tellphone);
            tilEmail.setText(email);
            tilDescription.setText(description);
        }
    }
}