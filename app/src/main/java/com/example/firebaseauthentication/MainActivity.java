package com.example.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView geeksforgeeks;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        geeksforgeeks = findViewById(R.id.gks);
//        geeksforgeeks.setText("GeeksForGeeks(Firebase Authentication)");

        btnNext = findViewById(R.id.btn);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNext = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intentNext);
            }
        });
    }


}
