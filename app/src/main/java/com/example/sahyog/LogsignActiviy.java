package com.example.sahyog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class LogsignActiviy extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    Button btn_login;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logsign_activiy);
        getSupportActionBar().setTitle("Login Form");

        txtEmail = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        txtPassword = (EditText) findViewById(R.id.editTextTextPassword);
        btn_login = (Button) findViewById(R.id.button3);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LogsignActiviy.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LogsignActiviy.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;

                }


                if (password.length() < 6) {
                    Toast.makeText(LogsignActiviy.this, "Password too short!", Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener (LogsignActiviy.this, task -> {
                            if (task.isSuccessful())  {
                                Toast.makeText(LogsignActiviy.this, "Login Successfull",Toast.LENGTH_SHORT).show(); //newww1
                            startActivity(new Intent(getApplicationContext(), NavigationDrawer.class));
                        } else {

                           Toast.makeText(LogsignActiviy.this, "Authentication Failed",Toast.LENGTH_SHORT).show();
                    }




        });

    }
});

    }

}