package com.example.mobiledevproj;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class Invoice extends AppCompatActivity {
    Button done;
    ImageView myImage ;
    private StorageReference mstorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_12);
        mstorageRef= FirebaseStorage.getInstance().getReference();
        done = (Button) findViewById(R.id.done);
        myImage=findViewById(R.id.imageView);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent done = new Intent(Invoice.this, receiptPatient.class);
                startActivity(done);
            }
        });
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, pharmacyOptions.class);
            startActivity(i);
        });
        ImageButton prof;
        prof=findViewById(R.id.imageButton5);
        prof.setOnClickListener(view -> {
            Intent i = new Intent(this, p_p_p.class);
            startActivity(i);
        });

    }
    public void UploadImage(View v){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,101);
    }
    @Override
    public void onActivityResult(int requestcode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestcode, resultCode, data);
        if (resultCode== Activity.RESULT_OK){
            if (requestcode==101){
                oncaptureImageResult(data);
            }
        }
    }

    private void oncaptureImageResult(Intent data) {
        Bitmap thumbnail=(Bitmap)data.getExtras().get("data");
        ByteArrayOutputStream bytes=new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        byte[] bb=bytes.toByteArray();

        // Log.d("hi",bb.toString());
        myImage.setImageBitmap(thumbnail);
        uploadToFirebase(bb);
    }

    private void uploadToFirebase(byte[] bb) {
        StorageReference sr=mstorageRef.child("myimages/"+UUID.randomUUID().toString()+".jpeg");
        sr.putBytes(bb).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(Invoice.this, "success fully upload", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Invoice.this,""+"failed to upload",Toast.LENGTH_SHORT ).show();
            }
        });


    }
}
