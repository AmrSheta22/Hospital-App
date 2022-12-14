package com.example.mobiledevproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.provider.FirebaseInitProvider;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class loginPage extends AppCompatActivity {
    // Write a message to the database
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        TextView btn = (TextView) findViewById(R.id.textView7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginPage.this, signupPage.class));
            }
        });
        String regexPassword = ".{7,}";
        EditText txt = findViewById(R.id.username_p);
        EditText lol = findViewById(R.id.password_p);
        AwesomeValidation V2 = new AwesomeValidation(ValidationStyle.BASIC);
        V2.addValidation(this, R.id.username_p, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        V2.addValidation(this,R.id.password_p,regexPassword,R.string.invalid_password);
        V2.addValidation(this,R.id.password_p,RegexTemplate.NOT_EMPTY,R.string.Empty_Password);

        Button btn2;
        btn2 = findViewById(R.id.log_in_p);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){


                String the_text = txt.getText().toString();
                if (the_text.equals("0")) {

                    DoctorView();
                }
                else if (the_text.equals("1")) {
                    PharmaView();
                }
                else {

                    Doctor d1 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Ahmed", "ah1234567", "general", "DrAhmed@gmail.com", 40, 4.6, 500, 13);
                    ref.child("doctors").child("1").setValue(d1);

                    Doctor d2 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Mohamed", "mh1234567", "general", "DrMohamed@gmail.com", 45, 4.3, 500, 18);
                    ref.child("doctors").child("2").setValue(d2);

                    Doctor d3 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Hagar","ha1234567","general", "DrHagar@gmail.com",43,4,450,15);
                    ref.child("doctors").child("3").setValue(d3);

                    Doctor d4 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Sama", "sa1234567", "general", "DrSama@gmail.com", 27, 3.8, 200, 3);
                    ref.child("doctors").child("4").setValue(d4);

                    Doctor d5 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Ali","al1234567","general", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("5").setValue(d5);

                    Doctor d6 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Mahmoud", "ma1234567", "neurology", "DrMahmoud@gmail.com", 40, 4.6, 500, 13);
                    ref.child("doctors").child("6").setValue(d6);

                    Doctor d7 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr,Yasmin","ya1234567","neurology", "DrYasmin@gmail.com",30,4,320,5);
                    ref.child("doctors").child("7").setValue(d7);

                    Doctor d8 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Yassin", "ys1234567", "neurology", "DrYassin@gmail.com", 37, 3.3, 290, 11);
                    ref.child("doctors").child("8").setValue(d8);

                    Doctor d9 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Lana","la1234567","neurology", "DrLana@gmail.com",26,2.7,100,2);
                    ref.child("doctors").child("9").setValue(d9);

                    Doctor d10 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Loai", "lo1234567", "neurology", "DrLoai@gmail.com", 27, 3.8, 200, 3);
                    ref.child("doctors").child("10").setValue(d10);

                    Doctor d11 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Mona","mo1234567","cardiology", "DrMona@gmail.com",55,4,550,25);
                    ref.child("doctors").child("11").setValue(d11);

                    Doctor d12 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Aziza","az1234567","cardiology", "DrAziza@gmail.com",39,4.2,320,12);
                    ref.child("doctors").child("12").setValue(d12);

                    Doctor d13 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Hussein","hu1234567","cardiology", "DrAli@gmail.com",41,3.6,290,17);
                    ref.child("doctors").child("13").setValue(d13);

                    Doctor d14 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Aliaa","aa1234567","cardiology", "DrAliaa@gmail.com",29,3.1,300,5);
                    ref.child("doctors").child("14").setValue(d14);

                    Doctor d15 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Marwan","ma1234567","cardiology", "DrMarwan@gmail.com",46,3.4,150,20);
                    ref.child("doctors").child("15").setValue(d15);

                    Doctor d16 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Amr","am1234567","cancer care", "DrAmr@gmail.com",30,4,240,5);
                    ref.child("doctors").child("16").setValue(d16);

                    Doctor d17 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Ola","ol1234567","cancer care", "DrOla@gmail.com",37,2.9,280,9);
                    ref.child("doctors").child("17").setValue(d17);

                    Doctor d18 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Gehan","ge1234567","cancer care", "DrGehan@gmail.com",40,4.3,330,14);
                    ref.child("doctors").child("18").setValue(d18);

                    Doctor d19 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Rehab","re1234567","cancer care", "DrRehab@gmail.com",32,3.6,240,6);
                    ref.child("doctors").child("19").setValue(d19);

                    Doctor d20 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Youssef","yo1234567","cancer care", "DrYoussef@gmail.com",49,4,370,23);
                    ref.child("doctors").child("20").setValue(d20);

                    Doctor d21 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Abeer","ab1234567","orthopedic", "DrAbeer@gmail.com",30,3.1,229,3);
                    ref.child("doctors").child("21").setValue(d21);

                    Doctor d22 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Yara","yr1234567","orthopedic", "DrYara@gmail.com",42,3.5,380,18);
                    ref.child("doctors").child("22").setValue(d22);

                    Doctor d23 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Gamal","ga1234567","orthopedic", "DrGamal@gmail.com",48,4.6,300,15);
                    ref.child("doctors").child("23").setValue(d23);

                    Doctor d24 = new Doctor("doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png","Dr.Asser","as1234567","orthopedic", "DrAsser@gmail.com",35,3.2,230,7);
                    ref.child("doctors").child("24").setValue(d24);

                    Doctor d25 = new Doctor("woman-doctor-png-transparent-woman-doctor-images-7.png","Dr.Tasnim","ta1234567","orthopedic", "DrTasnim@gmail.com",26,4,120,5);
                    ref.child("doctors").child("25").setValue(d25);



                    PatientView();

                }
            }
        });
    }
    public void DoctorView(){
        Intent intent = new Intent(this,doctor_page.class);
        startActivity(intent);
    }
    public void PharmaView(){
        Intent intent = new Intent(this,pharmacy_page.class);
        startActivity(intent);
    }
    public void PatientView(){
        Intent intent = new Intent(this,profile.class);
        startActivity(intent);
    }

}
