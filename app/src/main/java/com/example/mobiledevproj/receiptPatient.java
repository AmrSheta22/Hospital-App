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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class receiptPatient extends AppCompatActivity {
    LinearLayout mChartLayout;
    TableLayout mTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_15);
        //mChartLayout =(LinearLayout) findViewById(R.id.chart_layout);
        double[] prices = getIntent().getDoubleArrayExtra("prices");
        String[] names = getIntent().getStringArrayExtra("names");
        Log.d("success", Arrays.toString(prices));
        Log.d("success", Arrays.toString(names));
        Log.d("success", names[0]);
        //Set<String> temp = new HashSet<String>(Arrays.asList(names));
        //String[] unique_names = temp.toArray(new String[temp.size()]);
        //Log.d("success", Arrays.toString(unique_names));

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
            Intent i = new Intent(this, profile.class);
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

    //public void displayChartTable(){


    //}
}