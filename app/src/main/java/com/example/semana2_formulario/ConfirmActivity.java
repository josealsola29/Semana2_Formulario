package com.example.semana2_formulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ConfirmActivity extends AppCompatActivity {
    private TextView tvNameInfo;
    private TextView tvBirthDate;
    private TextView tvTelephoneInfo;
    private TextView tvEmailInfo;
    private TextView tvDescriptionInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Bundle extras = getIntent().getExtras();
        String name = Objects.requireNonNull(extras).getString("name");
        String tellphone = extras.getString("tellphone");
        String email = extras.getString("email");
        String description = extras.getString("description");
        String date = extras.getString("date");

        tvNameInfo = findViewById(R.id.tvNameInfo);
        tvBirthDate = findViewById(R.id.tvBirthDate);
        tvTelephoneInfo = findViewById(R.id.tvTelephoneInfo);
        tvEmailInfo = findViewById(R.id.tvEmailInfo);
        tvDescriptionInfo = findViewById(R.id.tvDescriptionInfo);
        Button btnEditInfo = findViewById(R.id.btnEditInfo);

        tvNameInfo.setText(name);
        tvBirthDate.setText(date);
        tvTelephoneInfo.setText(tellphone);
        tvEmailInfo.setText(email);
        tvDescriptionInfo.setText(description);

        btnEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmActivity.this, MainActivity.class);
                intent.putExtra("name", tvNameInfo.getText().toString());
                intent.putExtra("birthday", tvBirthDate.getText().toString());
                intent.putExtra("tellphone", tvTelephoneInfo.getText().toString());
                intent.putExtra("email", tvEmailInfo.getText().toString());
                intent.putExtra("description", tvDescriptionInfo.getText().toString());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ConfirmActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}