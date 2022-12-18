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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
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
    private FirebaseAuth mAuth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        mAuth = FirebaseAuth.getInstance();
        TextView btn = (TextView) findViewById(R.id.textView7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginPage.this, signupPage.class));
            }
        });
        String regexPassword = ".{7,}";
        EditText email = findViewById(R.id.username_p);
        EditText password = findViewById(R.id.password_p);
        AwesomeValidation V2 = new AwesomeValidation(ValidationStyle.BASIC);
        V2.addValidation(this, R.id.username_p, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        V2.addValidation(this,R.id.password_p,regexPassword,R.string.invalid_password);
        V2.addValidation(this,R.id.password_p,RegexTemplate.NOT_EMPTY,R.string.Empty_Password);


        Button btn2;
        btn2 = findViewById(R.id.log_in_p);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                Log.d("hi", "we got email and pass");
                mAuth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("hi", "wtf");
                                if (task.isSuccessful()) {
                                    Log.d("hi", "i can't");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    String id = user.getUid();
                                    Query query = ref.child("users")
                                            .orderByChild("id")
                                            .equalTo(id);
                                    query.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if(snapshot.exists()) {
                                                Log.d("hi", id);
                                                for (DataSnapshot userSnapshot: snapshot.getChildren()) {
                                                    Log.d("id", userSnapshot.child("id").getValue().toString());
                                                }
                                                if (id.equals("udj4LouVUSPOSwYCYBjmiftyqxf1")){
                                                    Intent intent = new Intent(loginPage.this, doctorOrPharmacist.class);
                                                    startActivity(intent);
                                                }
                                                else {
                                                    String[] diseases1 = {"headache"} ;
                                                    List nameList1 = new ArrayList<String>(Arrays.asList(diseases1));
                                                    Medication m1 = new Medication("1", " Aspirin ", 20.0, nameList1);
                                                    ref.child("medication").child("1").setValue(m1);
                                                    String[] diseases2 = {"stomach cramps"};
                                                    List nameList2 = new ArrayList<String>(Arrays.asList(diseases2));
                                                    Medication m2 = new Medication("2", " Buscopan ", 17.0, nameList2);
                                                    ref.child("medication").child("2").setValue(m2);
                                                    String[] diseases3 = {"fever"};
                                                    List nameList3 = new ArrayList<String>(Arrays.asList(diseases3));
                                                    Medication m3 = new Medication("3", " pandol extra ", 25.0, nameList3);
                                                    ref.child("medication").child("3").setValue(m3);
                                                    String[] diseases4 = {"arthritis"};
                                                    List nameList4 = new ArrayList<String>(Arrays.asList(diseases4));
                                                    Medication m4= new Medication("4", " arythrex ",19.0, nameList4);
                                                    ref.child("medication").child("4").setValue(m4);


                                                    String[] diseases5 = {"allergie","intense itching"};
                                                    List nameList5 = new ArrayList<String>(Arrays.asList(diseases5));
                                                    Medication m5= new Medication("5", " claritine ",22.0, nameList5);
                                                    ref.child("medication").child("5").setValue(m5);

                                                    String[] diseases6 = {"diarrhea"};
                                                    List nameList6 = new ArrayList<String>(Arrays.asList(diseases6));
                                                    Medication m6= new Medication("6", " antinal ",14.0, nameList6);
                                                    ref.child("medication").child("6").setValue(m6);

                                                    String[] diseases7 = {"flu"};
                                                    List nameList7 = new ArrayList<String>(Arrays.asList(diseases7));
                                                    Medication m7= new Medication("7", " panadol ",23.0, nameList7);
                                                    ref.child("medication").child("7").setValue(m7);

                                                    String[] diseases8= {"congestion or a sore throat"};
                                                    List nameList8 = new ArrayList<String>(Arrays.asList(diseases8));
                                                    Medication m8= new Medication("8", " sinus Relief ",28.0, nameList8);
                                                    ref.child("medication").child("8").setValue(m8);

                                                    String[] diseases9= {"cough"};
                                                    List nameList9 = new ArrayList<String>(Arrays.asList(diseases9));
                                                    Medication m9= new Medication("9", " oplex ",33.0, nameList9);
                                                    ref.child("medication").child("9").setValue(m9);

                                                    String[] diseases10= {"dry skin"};
                                                    List nameList10 = new ArrayList<String>(Arrays.asList(diseases10));

                                                    Medication m10= new Medication("9", " cerave ",45.0, nameList10);
                                                    ref.child("medication").child("10").setValue(m10);









                                                    Intent intent = new Intent(loginPage.this, profile.class);
                                                    startActivity(intent);
                                                }
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                    Query query2 = ref.child("doctors")
                                            .orderByChild("id")
                                            .equalTo(id);
                                    query2.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if(snapshot.exists()) {
                                                Intent intent = new Intent(loginPage.this, doctor_page.class);
                                                startActivity(intent);
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                    Query query3 = ref.child("pharmacists")
                                            .orderByChild("id")
                                            .equalTo(id);
                                    query3.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if(snapshot.exists()) {
                                                Intent intent = new Intent(loginPage.this, pharmacy_page.class);
                                                startActivity(intent);
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                }

                            }
                        });
            }
        });
    }


}
