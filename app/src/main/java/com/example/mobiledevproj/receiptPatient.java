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

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class receiptPatient extends AppCompatActivity {
    LinearLayout mChartLayout;
    TableLayout mTableLayout;
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    private FirebaseAuth mAuth;

    long ord=1;
    long number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_15);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String patientId = user.getUid();
        //mChartLayout =(LinearLayout) findViewById(R.id.chart_layout);
        double[] prices = getIntent().getDoubleArrayExtra("prices");
        String[] names = getIntent().getStringArrayExtra("names");
        Log.d("success", Arrays.toString(prices));
        Log.d("success", Arrays.toString(names));
        Log.d("success", names[0]);

        //Set<String> temp = new HashSet<String>(Arrays.asList(names));
        //String[] unique_names = temp.toArray(new String[temp.size()]);
        //Log.d("success", Arrays.toString(unique_names));

        ArrayList<String> ids = new ArrayList<String>();
        List names_list = Arrays.asList(names);
        Query q= ref.child("medication");
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int count = 0;
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    if (names_list.contains(dataSnapshot.child("name").getValue().toString())){
                        ids.add(dataSnapshot.child("id").getValue().toString());
                        count++;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Query q2 = ref.child("bill");
        q2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())  {
                    DataSnapshot fc = snapshot.getChildren().iterator().next();
                    ord = Long.parseLong(fc.getRef().getKey());
                    number= snapshot.getChildrenCount();
                    Log.d("order",String.valueOf(number));
                    //Bill bill=new Bill(String.valueOf(number+ord),  ids_al, patientId, "1");

                }
                Log.d("out of scope",String.valueOf(number));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        mTableLayout  =findViewById(R.id.bill);
        //displayChartTable();
        TableLayout tableLayout = (TableLayout) findViewById(R.id.bill);

        for(int count=0; count<names.length; count++){
            TableRow tr_head = new TableRow(this);
            tr_head.setBackgroundColor(Color.WHITE);
            tr_head.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            TextView label_hello = new TextView(this);
            label_hello.setText(names[count]);
            label_hello.setTextColor(Color.GRAY);


            TextView label_android = new TextView(this);
            label_android.setText(prices[count]+"LE");
            tr_head.addView(label_hello);
            tr_head.addView(label_android);
            tableLayout.addView(tr_head, new TableLayout.LayoutParams(
                    FILL_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));

        }
        TableRow tr_head = new TableRow(this);
        tr_head.setBackgroundColor(Color.WHITE);
        tr_head.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        TextView label_hello = new TextView(this);
        label_hello.setText("Total");
        label_hello.setTextColor(Color.GRAY);
        Double sum = 0.0;
        for (Double value : prices) {
            sum += value;
        }
        TextView label_android = new TextView(this);
        label_android.setText(String.valueOf(sum));
        tr_head.addView(label_hello);
        tr_head.addView(label_android);
        tableLayout.addView(tr_head, new TableLayout.LayoutParams(
                FILL_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        Button btn1, btn2;
        String hi_name =getIntent().getStringExtra("name");
        TextView hello=findViewById(R.id.name);
        hello.setText(hi_name);
        btn1 = findViewById(R.id.button5);
        btn1.setOnClickListener(view -> {
            Intent i = new Intent(this, profile.class);
            startActivity(i);
        });
        btn2 = findViewById(R.id.button6);
        btn2.setOnClickListener(view -> {

            Bill bill=new Bill(String.valueOf((int) number+ord),  ids, patientId, "VR3pih21hWQ29dbniuQ3jtxcOJG2");
            ref.child("bill").child(String.valueOf(number+ord)).setValue(bill);
            Log.d("id",String.valueOf(number+1));
            Intent i = new Intent(receiptPatient.this, profile.class);
            startActivity(i);



        });
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, pharmacyOptions.class);
            i.putExtra("name",hi_name);
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