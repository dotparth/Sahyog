package com.example.sahyog;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavigationDrawer extends AppCompatActivity {

    FirebaseUser currentuser;
    FirebaseAuth mAuth;


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //newww

        mAuth = FirebaseAuth.getInstance();
        currentuser = mAuth.getCurrentUser();






        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        //sambhlke

        updateNavHeader();


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.my_requests, R.id.my_donation, R.id.my_confdonation, R.id.my_confrequestd)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //neww
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int i = item.getItemId();
                if(i==R.id.nav_home)
                {
                    openhomeact();
                }
                else if(i==R.id.my_donation)
                {
                    opendonatedact();
                }
                else if(i==R.id.my_confdonation)
                {
                    opnconfirmedonationact();
                }
                else if(i==R.id.my_requests)
                {
                    openrequestact();
                }
                else if (i==R.id.my_confrequestd)
                {
                    openconfreq();
                }
                else if (i==R.id.logout)
                {
                    openlogoutact();
                }
                else if(i==R.id.pending_req)
                {
                    openpendingreq();
                }

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void openhomeact() {
        Intent intent = new Intent (this, MainActivity2.class);
        startActivity(intent);
    }

    public void opendonatedact() {
        Intent intent = new Intent (this, Donateditems.class);
        startActivity(intent);
    }


    public void opnconfirmedonationact() {
        Intent intent = new Intent (this, ConfirmedDonation.class);
        startActivity(intent);
    }

    public void openrequestact() {
        Intent intent = new Intent (this, DisplayRequests.class);
        startActivity(intent);
    }
    public void openconfreq() {
        Intent intent = new Intent (this, Openconfreq.class);
        startActivity(intent);
    }

    public void openlogoutact() {
        Intent intent = new Intent (this, Logout.class);
        startActivity(intent);
    }
    public void openpendingreq() {
        Intent intent = new Intent (this, Pending.class);
        startActivity(intent);
    }




    public void updateNavHeader() {


        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUserMail = headerView.findViewById(R.id.emailview);

        navUserMail.setText(currentuser.getEmail());
        //nowww

    }


}