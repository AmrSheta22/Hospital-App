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

public class makePharmacist extends AppCompatActivity {
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_pharmacist);
        mAuth = FirebaseAuth.getInstance();
        EditText email, password;
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Button makepharma = findViewById(R.id.button23);
        makepharma.setOnClickListener(view -> {
            String Email = email.getText().toString();
            String Password = password.getText().toString();
            mAuth.createUserWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                ref.child("pharmacists").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(new Pharmacist(FirebaseAuth.getInstance().getCurrentUser().getUid(), Email, Password));
                            }
                        }
                    });
        });
    }
}