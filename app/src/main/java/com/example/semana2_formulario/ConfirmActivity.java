package com.example.semana2_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String tellphone = extras.getString("tellphone");
        String email = extras.getString("email");
        String description = extras.getString("description");
        String date = String.valueOf(extras.getLong("date"));

        TextView tvNameInfo = findViewById(R.id.tvNameInfo);
        TextView tvBirthDate = findViewById(R.id.tvBirthDate);
        TextView tvTelephoneInfo = findViewById(R.id.tvTelephoneInfo);
        TextView tvDescriptionInfo = findViewById(R.id.tvDescriptionInfo);

        tvNameInfo.setText(name);
        tvBirthDate.setText(date);
        tvTelephoneInfo.setText(tellphone);
        tvDescriptionInfo.setText(description);

    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return super.onKeyDown(keyCode, event);
//        if (keyCode == KeyEvent.KEYCODE_BACK){
//            Intent intent = new Intent(ConfirmActivity.this, MainActivity.class);
//            startActivity(intent);}
//    }

}