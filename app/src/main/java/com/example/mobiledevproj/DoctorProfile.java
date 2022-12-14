package com.example.mobiledevproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class DoctorProfile extends AppCompatActivity {
    ImageView doctorImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        doctorImage = findViewById(R.id.imageView2);
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
        Button btn;
        btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, Departments.class);
            startActivity(i);
        });

        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, doctors.class);
            i.putExtra("btnText",x);
            startActivity(i);
        });
    }
}