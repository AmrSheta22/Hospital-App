package com.example.mobiledevproj;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.collect.Range;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class Singup2 extends AppCompatActivity {
    private Boolean selected;
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup2);
        mAuth = FirebaseAuth.getInstance();
        RadioGroup Gender = (RadioGroup) findViewById(R.id.Gender);
        RadioButton male,female;
        male = (RadioButton) findViewById(R.id.Male);
        female =(RadioButton) findViewById(R.id.Female);

        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup Gender, int i) {

                if (i == R.id.Male) {
                    selected = true;
                } else if (i == R.id.Female) {
                    selected = false;
                }


            }});
        EditText Chronic_Diseases = findViewById(R.id.Chronic_Diseases);
        EditText Address = findViewById(R.id.Address);
        EditText Age = findViewById(R.id.Age);
        AwesomeValidation V1= new AwesomeValidation(ValidationStyle.BASIC);
        V1.addValidation(this, R.id.Address, RegexTemplate.NOT_EMPTY, R.string.invalid_Address);
        V1.addValidation(this, R.id.Age, RegexTemplate.NOT_EMPTY, R.string.invalid_Age);
        V1.addValidation(this, R.id.Age, Range.closed(0, 130), R.string.invalid_age);
        Intent from = getIntent();
        String email = from.getStringExtra("email");
        String username = from.getStringExtra("username");
        String password = from.getStringExtra("password");




        Button resg;
        resg = findViewById(R.id.Register);
        resg.setOnClickListener(view -> {
            if(V1.validate()){
                String address = Address.getText().toString();
                String disease = Chronic_Diseases.getText().toString();
                ArrayList<String> chronic_diseases  = new ArrayList<>(Arrays.asList(disease.split(",")));
                int death =chronic_diseases.size();
                int age = Integer.parseInt(Age.getText().toString());
                if (death >5){
                    Toast.makeText(this, "you do not need hospital u need morgue", Toast.LENGTH_SHORT).show();
                }
                if(male.isChecked() || female.isChecked()){
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        // hi hi
                                        ref.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(new Patient(FirebaseAuth.getInstance().getCurrentUser().getUid(),username, password, address, selected, chronic_diseases, email, age));

                                    }
                                }
                            });
                    Intent i = new Intent(this, profile.class);

                    startActivity(i);
                }else {
                    Toast.makeText(this, "either u have it or u do not Choose gender dear", Toast.LENGTH_SHORT).show();

                }

            }else{
                Toast.makeText(this, "Form Is not complete dear", Toast.LENGTH_LONG).show();
            }


        });
    }
}