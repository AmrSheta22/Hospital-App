package com.example.mobiledevproj;
// if child.getValue.contains(symptom)

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class medications2 extends AppCompatActivity {
    Button btn;
    //DatabaseReference ref;
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medications2);
        String symptom = getIntent().getStringExtra("symptom");

        String hi_name =getIntent().getStringExtra("name");
        TextView hello=findViewById(R.id.name);
        hello.setText(hi_name);


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

        ArrayList<String> all_names = new ArrayList<String>();
        ArrayList<Double> all_prices = new ArrayList<Double>();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> prices = new ArrayList<Double>();


        View.OnClickListener plus_listener = new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("hi", "I am here");
                Button l = (Button) v;
                int s = l.getId();
                TextView txt = findViewById(s+100);
                String new_number = Integer.toString(Integer.parseInt(txt.getText().toString())+1);
                txt.setText(new_number);
                names.add(all_names.get(s-100-1));
                prices.add(all_prices.get(s-100-1));
                Log.d("array string", names.toString());
            }
        };
        View.OnClickListener minus_listener = new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("hi", "I am here");
                Button l = (Button) v;
                int s = l.getId();
                TextView txt = findViewById(s+200);
                int value = Integer.parseInt(txt.getText().toString());
                if (value != 0) {
                    String new_number = Integer.toString(value-1);
                    txt.setText(new_number);
                    String name = all_names.get(s-1);
                    int index = names.indexOf(name);
                    names.remove(index);
                    Double price = all_prices.get(s-1);
                    int index2 = all_prices.indexOf(price);
                    prices.remove(index2);
                    //prices.remove(prices.indexOf(all_prices.get(s-1)));
                    Log.d("array string", names.toString());

                }
            }
        };
        Query query1=ref.child("medication");
        Log.d("hi","ahmed");
        query1.addValueEventListener(new ValueEventListener() {
            @SuppressLint("ResourceType")
            @Override

            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int children = (int) snapshot.getChildrenCount();
                int[] plus_buttons = new int[children];
                int[] minus_buttons = new int[children];
                if (snapshot.exists()) {
                    Log.d("hi","mona");
                    LinearLayout myLayout = findViewById(R.id.linear);

                        int count = 0;
                        for (DataSnapshot i:snapshot.getChildren()){
                            Medication med=i.getValue(Medication.class);
                            if(med.diseases.contains(symptom)){
                            // commit not working
                                LinearLayout parent = new LinearLayout(medications2.this);
                                parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                                parent.setOrientation(LinearLayout.HORIZONTAL);
                                //setContentView(parent);
                                TextView textView = new TextView(medications2.this);
                                textView.setLayoutParams(new LinearLayout.LayoutParams(300, LinearLayout.LayoutParams.WRAP_CONTENT));
                                textView.setText(i.child("name").getValue().toString());
                                textView.setId(Integer.parseInt(i.child("id").getValue().toString())+300);
                                textView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
                                textView.setTextColor(Color.parseColor("#019874"));
                                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                                textView.setTypeface(null, Typeface.BOLD);

                                Button button = new Button(medications2.this);
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.WRAP_CONTENT, 100);
                                button.setLayoutParams(params);
                                button.setBackgroundTintList(ColorStateList.valueOf(button.getContext().getResources().getColor(R.color.my_color)));
                                button.setId(Integer.parseInt(i.child("id").getValue().toString()));
                                button.setText("-");
                                TextView textView2 = new TextView(medications2.this);
                                textView2.setLayoutParams(new LinearLayout.LayoutParams(100,
                                        LinearLayout.LayoutParams.WRAP_CONTENT));
                                textView2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
                                textView2.setTextColor(Color.parseColor("#019874"));
                                textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                                textView2.setTypeface(null, Typeface.BOLD);
                                textView2.setText("0");
                                textView2.setId(Integer.parseInt(i.child("id").getValue().toString())+200);
                                textView2.setGravity(Gravity.CENTER);

                                Button button2 = new Button(medications2.this);

                                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT);
                                params2.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                                params2.width = 2;
                                params2.weight = 1;
                                button2.setLayoutParams(params);
                                button2.setBackgroundTintList(ColorStateList.valueOf(button2.getContext().getResources().getColor(R.color.my_color)));
                                button2.setText("+");
                                button2.setId(Integer.parseInt(i.child("id").getValue().toString())+100);
                                parent.addView(textView);
                                parent.addView(button);
                                parent.addView(textView2);
                                parent.addView(button2);
                                myLayout.addView(parent);
                                minus_buttons[count] = Integer.parseInt(i.child("id").getValue().toString());
                                plus_buttons[count] = Integer.parseInt(i.child("id").getValue().toString())+100;
                                count+=1;
                                all_names.add(i.child("name").getValue().toString());
                                all_prices.add(Double.parseDouble(i.child("price").getValue().toString()));}

                    }
                    Log.d("hi", Arrays.toString(plus_buttons));
                    for (int i= 0; i < children; i++){
                        findViewById(plus_buttons[i]).setOnClickListener(plus_listener);
                    }
                    for (int i= 0; i < children; i++){
                        findViewById(minus_buttons[i]).setOnClickListener(minus_listener);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn = findViewById(R.id.done);
        btn.setOnClickListener(view -> {
            String[] names_arr = (String[]) names.toArray(new String[names.size()]);
            double[] target = new double[prices.size()];
            for (int i = 0; i < target.length; i++) {
                target[i] = prices.get(i);                // java 1.5+ style (outboxing)
            }
            Intent i = new Intent(this, receiptPatient.class);
            i.putExtra("name",hi_name);
            i.putExtra("prices", target);
            i.putExtra("names", names_arr);
            startActivity(i);

        });

    }
}