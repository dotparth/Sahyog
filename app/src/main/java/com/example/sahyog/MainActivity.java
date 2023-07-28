package com.example.sahyog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

private Button button;  //new
    private FirebaseAuth mAuth; //qnew


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


button = (Button) findViewById(R.id.button);  //new
button.setOnClickListener(new View.OnClickListener() {  //new
    @Override   //new
    public void onClick(View v) {  //new
        openLoginActivity();  //new
    }
});


    }

    @Override  //qnew
    protected void onStart() {
        super.onStart();

       FirebaseUser mfirebaseuser =  mAuth.getCurrentUser();
       if(mfirebaseuser!=null)
       {
           //someone logged in
           startActivity(new Intent(this, NavigationDrawer.class));
           finish();
       }
       else
       {
           //none logged in
           startActivity(new Intent(this, OTPActivity.class));
           finish();
       }
    }

    public void openLoginActivity() {
        Intent intent = new Intent(MainActivity.this, OTPActivity.class); //new
    startActivity(intent);
}



}