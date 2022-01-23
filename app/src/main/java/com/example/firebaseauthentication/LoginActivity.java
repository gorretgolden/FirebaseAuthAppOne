package com.example.firebaseauthentication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LoginActivity extends Activity {
    private EditText emailTextView, passwordTextView;
    private Button Btn;
    private ProgressBar progressbar;
    private FirebaseAuth mLoginAuth;
    TextView registerHere;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // taking instance of FirebaseAuth
        mLoginAuth = FirebaseAuth.getInstance();
        if (mLoginAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        // initialising all views through id defined above
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.password);
        Btn = findViewById(R.id.login);
        progressbar = findViewById(R.id.progressBar);
        registerHere = findViewById(R.id.register);


        //Get Firebase auth instance
        mLoginAuth = FirebaseAuth.getInstance();

        // Set on Click Listener on Sign-in button
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginUserAccount();
            }
        });


        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegistrationActivty.class);
                startActivity(intent);
            }
        });
    }






    private void loginUserAccount()
    {

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();


        // validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        // signin existing user
        mLoginAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_SHORT).show();
                    progressbar.setVisibility(View.GONE);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Login failed!", Toast.LENGTH_SHORT).show();
                    progressbar.setVisibility(View.GONE);
                }
            }
        });

//                        });
    }
}
