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

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

public class OTPActivity extends AppCompatActivity {

    EditText txtemail, txtpass, txtconpass;
    Button btn_register;
    private FirebaseAuth firebaseAuth;
    private Button buttonm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);
        buttonm = (Button) findViewById(R.id.button8);  //newww1
        buttonm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //neww1
                openMainActivityz(); //newww1
            }
        }); //neww1
        getSupportActionBar().setTitle("Signup Form");

        txtemail = (EditText) findViewById(R.id.editTextTextPersonName);
        txtpass = (EditText) findViewById(R.id.editTextTextPassword2);
        txtconpass = (EditText) findViewById(R.id.editTextTextPassword3);
        btn_register = (Button) findViewById(R.id.button7);

        firebaseAuth = FirebaseAuth.getInstance();


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtemail.getText().toString().trim();
                String password = txtpass.getText().toString().trim();
                String Confirmpassword = txtconpass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(OTPActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(OTPActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(Confirmpassword)) {
                    Toast.makeText(OTPActivity.this, "Please Enter Password Again", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(OTPActivity.this, "Password too short!", Toast.LENGTH_SHORT).show();
                }

                if (password.equals(Confirmpassword)) {

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(OTPActivity.this, task -> {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                                    Toast.makeText(OTPActivity.this, "Registration Complete", Toast.LENGTH_SHORT).show();

                                } else {


                                    Toast.makeText(OTPActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();


                                }
                            });
                }
            }

        });



    }


    public void openMainActivityz() {
        Intent intent = new Intent(OTPActivity.this, LogsignActiviy.class);
        startActivity(intent);
    }
}


