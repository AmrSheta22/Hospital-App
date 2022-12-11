package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(4*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(), loginPage.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                    System.out.println("didn't run");
                }
            }
        };
        // start thread
        background.start();
        //hide the bar on top of the page
        getSupportActionBar().hide();


    }
}