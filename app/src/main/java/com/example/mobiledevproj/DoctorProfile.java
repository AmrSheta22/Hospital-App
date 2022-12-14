package com.example.mobiledevproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class DoctorProfile extends AppCompatActivity {
    DatabaseReference ref;
    Button btn;
    ImageView doctorImage;
    long ord;
    long number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);


        TextView docName = findViewById(R.id.drName);
        TextView depart = findViewById(R.id.dep_name);
        TextView NoOfPatient = findViewById(R.id.Num_patient);
        TextView rates = findViewById(R.id.rate);
        TextView Experience = findViewById(R.id.year);

        String hi_name =getIntent().getStringExtra("name");
        TextView hello=findViewById(R.id.name);
        hello.setText(hi_name);
        doctorImage = findViewById(R.id.imageView2);
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) doctorImage.getLayoutParams();
        params.height = 650;
        params.width = 650;
        doctorImage.setLayoutParams(params);

        FirebaseStorage storageRef = FirebaseStorage.getInstance("gs://hospital-app-be6c3.appspot.com");

        // change image of the image view of doctor image to the one in the reference
        StorageReference image = storageRef.getReference("/doctor-bulk-billing-doctors-chapel-hill-health-care-medical-3.png");
        File localfile;
        {
            try {
                localfile = File.createTempFile("doctor", ".png");
                image.getFile(localfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                        doctorImage.setImageBitmap(bitmap);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DoctorProfile.this, "failed to fetch", Toast.LENGTH_SHORT);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // end of code

        Intent mIntent = getIntent();
        String x = mIntent.getStringExtra("key");
        //////////
        ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("appointment");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())  {
                    DataSnapshot fc = snapshot.getChildren().iterator().next();
                    ord = Long.parseLong(fc.getRef().getKey());
                    number= snapshot.getChildrenCount();

                }}

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
        });
        //////////
        Log.d("high",String.valueOf(number));
        btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            //////////
            String wd=FirebaseAuth.getInstance().getCurrentUser().getUid();
            Appointment appo = new Appointment((int) (number+ord), wd, "8oXXtLd3PCYICocHrIonh3Nos612");
            ref.child(String.valueOf(number+ord)).setValue(appo);
            Toast.makeText(getApplicationContext(), "Successfully Booked", Toast.LENGTH_SHORT).show();
            //////////
            Intent i = new Intent(DoctorProfile.this, Departments.class);
            i.putExtra("name", hi_name);
            startActivity(i);
        });

        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, doctors.class);
            i.putExtra("name",hi_name);
            i.putExtra("btnText",x);
            startActivity(i);
        });
        ImageButton prof;
        prof=findViewById(R.id.imageButton5);
        prof.setOnClickListener(view -> {
            Intent i = new Intent(this, p_p_p.class);
            startActivity(i);
        });
        DatabaseReference ref1 = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        String id = getIntent().getStringExtra("Id");
        ref1.child("doctors").child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Doctor d = task.getResult().getValue(Doctor.class);

                    docName.setText(d.name);
                    depart.setText(d.department);
                    NoOfPatient.setText(d.numberOfPatients+"");
                    rates.setText((int) d.rating+"");
                    Experience.setText(d.yearsOfExp+"");

                }
            }
        });


    }
}