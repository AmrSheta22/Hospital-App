package com.example.mobiledevproj;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class receiptPharma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_16);
        Button btn;
        final DatabaseReference[] reff = new DatabaseReference[1];
        final DatabaseReference[] ref = new DatabaseReference[1];
        final TextView[] label_hello = {new TextView(receiptPharma.this)};

        final TableRow[] tr_head = {new TableRow(receiptPharma.this)};
        TableLayout tableLayout = (TableLayout) findViewById(R.id.bill2);
        btn = findViewById(R.id.button5);
        final Medication[] m1 = {new Medication()};

        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, pharmacy_page.class);
            startActivity(i);
        });
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, pharmacy_page.class);
            startActivity(i);
        });
        ImageButton prof;
        prof=findViewById(R.id.imageButton5);
        prof.setOnClickListener(view -> {
            Intent i = new Intent(this, p_p_p.class);
            startActivity(i);
        });
    }
}