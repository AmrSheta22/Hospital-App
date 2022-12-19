package com.example.mobiledevproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class makeDoctor extends AppCompatActivity {
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_doctor);
        mAuth = FirebaseAuth.getInstance();
        EditText name, email, password, department, age, rating, yearsOfExp, numberOfPatients;
        //
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        department = findViewById(R.id.department);
        age = findViewById(R.id.age);
        rating = findViewById(R.id.rating);
        yearsOfExp = findViewById(R.id.yearsOfExp);
        numberOfPatients = findViewById(R.id.numberOfPatients);
        Button makedoc = findViewById(R.id.button22);
        //
        makedoc.setOnClickListener(view -> {
            String Name = name.getText().toString();
            String Email = email.getText().toString();
            String Password = password.getText().toString();
            String Department = department.getText().toString();
            String Age = age.getText().toString();
            int ageint = Integer.parseInt(Age);
            String Rating = rating.getText().toString();
            double ratingint = Double.parseDouble(Rating);
            String YearsOfExp = yearsOfExp.getText().toString();
            int yearsofexpint = Integer.parseInt(YearsOfExp);
            String NumberOfPatients = numberOfPatients.getText().toString();
            int numofpatients = Integer.parseInt(NumberOfPatients);
            mAuth.createUserWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                ref.child("doctors").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(new Doctor(FirebaseAuth.getInstance().getCurrentUser().getUid(), "doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png", Name, Password, Department, Email, ageint, ratingint, numofpatients, yearsofexpint));
                            }
                        }
                    });
        });
    }
}