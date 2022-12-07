package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class doctors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);

        String x = mIntent.getStringExtra("btnText");
        ImageButton btn;
        btn = findViewById(R.id.imb1);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, DoctorProfile.class);
            startActivity(i);
        });
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, Departments.class);
            startActivity(i);
        });
        //if(intValue == 0){
        //    System.out.println("not working");
        //}

        // error handling (Will come in this if when button id is invalid)
        //else
        //{
//            if(x.equals("Apple")){
//                TextView tv1 = (TextView)findViewById(R.id.textView4);
//                tv1.setText("General");
//            }
//            else if (intValue == R.id.button1){
//                TextView tv1 = (TextView)findViewById(R.id.textView4);
//                tv1.setText("Neurology");
//            }
//            else if (intValue == R.id.button2){
//                TextView tv1 = (TextView)findViewById(R.id.textView4);
//                tv1.setText("Cardiology");
//            }
//            else if (intValue == R.id.button3){
//                TextView tv1 = (TextView)findViewById(R.id.textView4);
//                tv1.setText("Cancer Care");
//            }
//            else if (intValue == R.id.button4){
//                TextView tv1 = (TextView)findViewById(R.id.textView4);
//                tv1.setText("Orthopedic");
//            }
//            else {
//                TextView tv1 = (TextView)findViewById(R.id.textView4);
//                tv1.setText("Not working");
//            }
//
//            ImageButton imgbt = findViewById(R.id.imb1);
//            imgbt.setOnClickListener(view -> {
//                Intent i = new Intent(this, DoctorProfile.class);
//                startActivity(i);
//            });
        //}
    }
}