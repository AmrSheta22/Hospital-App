package com.example.mobiledevproj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class medications extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11);
        String hi_name =getIntent().getStringExtra("name");
        TextView hello=findViewById(R.id.name);
        hello.setText(hi_name);

        Button btn;
        btn = findViewById(R.id.done);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, receiptPatient.class);
            i.putExtra("name",hi_name);

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
//HashMap mbtn = new HashMap();
//HashMap txt = new HashMap();
//final View.OnClickListener mListener = new View.OnClickListener() {
//    public void onClick(View v) {
//        Button b =(Button)v;
//        String s = getResources().getResourceEntryName(b.getId());
//        String id = s.substring(s.length() -1);
//    }
//};

//for (int j = 2; j < 19 ; j = j + 2 ){
//    String id = "button"+Integer.toString(j);
//    int resID = getResources().getIdentifier(id, "id", getPackageName());
//    mbtn.put((j-2),findViewById(resID));
//}
//for (int j = 8; j < 17 ; j++ ){
//    String id = "textView"+Integer.toString(j);
//    int resID = getResources().getIdentifier(id, "id", getPackageName());
//    txt.put((j-8),findViewById(resID));
//}