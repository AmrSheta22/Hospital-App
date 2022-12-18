package com.example.mobiledevproj;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class medications extends AppCompatActivity {
    EditText editTextName;
    Button btn;
    //DatabaseReference ref;
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference("writtenmed");
    ListView listViewWritten;

    List<writtenmeds> writtenList;

    //@SuppressLint("MissingInflatedId")
    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11);
        String hi_name =getIntent().getStringExtra("name");
        TextView hello=findViewById(R.id.name);
        hello.setText(hi_name);


        editTextName = findViewById(R.id.item1);

        listViewWritten =findViewById(R.id.listViewWritten);

        writtenList =new ArrayList<>();

        btn = findViewById(R.id.done);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, receiptPatient.class);
            i.putExtra("name",hi_name);
            addMed();
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

    @Override
    protected void onStart() {
        super.onStart();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                writtenList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    writtenmeds writtenmed = postSnapshot.getValue(writtenmeds.class);
                    writtenList.add(writtenmed);
                }
                writtenmedslist adapter = new writtenmedslist(medications.this, writtenList);
                listViewWritten.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addMed(){
    String name =editTextName.getText().toString().trim();
    if(!TextUtils.isEmpty(name)) {
        String id = ref.push().getKey();
        ref.push().getKey();
        writtenmeds writtenmed = new writtenmeds(id,name);
        ref.child(id).setValue(writtenmed);

        Toast.makeText(this,"added",Toast.LENGTH_LONG).show();
    }else{
        Toast.makeText(this,"you should enter a medicine",Toast.LENGTH_LONG).show();
    }

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