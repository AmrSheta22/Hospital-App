package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class signupPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        Button btn;
        EditText email;
        email = findViewById(R.id.user_email_p);
        EditText password;
        password = findViewById(R.id.password_p);
        EditText username;
        username =findViewById(R.id.username_p);
        EditText confirmpassword;
        confirmpassword = findViewById(R.id.confirm_password_p);
        String regexPassword = ".{7,}";
        AwesomeValidation V= new AwesomeValidation(ValidationStyle.BASIC);
        V.addValidation(this,R.id.user_email_p,Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        V.addValidation(this, R.id.username_p, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        V.addValidation(this,R.id.user_email_p,RegexTemplate.NOT_EMPTY,R.string.Empty_Email);
        V.addValidation(this,R.id.password_p,regexPassword,R.string.invalid_password);
        V.addValidation(this,R.id.password_p,RegexTemplate.NOT_EMPTY,R.string.Empty_Password);
        V.addValidation(this,R.id.confirm_password_p,RegexTemplate.NOT_EMPTY,R.string.Empty_Confirm_Password);
        V.addValidation(this, R.id.confirm_password_p, R.id.password_p, R.string.invalid_confirm_password);
        btn = findViewById(R.id.log_in_p);
        btn.setOnClickListener(view -> {
            if (V.validate()){
                Intent i = new Intent(this, Singup2.class);
                String getemail = email.getText().toString();
                String getusername = username.getText().toString();
                String getpassword = password.getText().toString();
                i.putExtra("email",getemail);
                i.putExtra("password",getpassword);
                i.putExtra("username",getusername);
                startActivity(i);

            }else{
                Toast.makeText(this, "Form Is not complete dear", Toast.LENGTH_LONG).show();
            }

        });
    }
}