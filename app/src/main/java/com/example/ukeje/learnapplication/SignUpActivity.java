package com.example.ukeje.learnapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText phoneNo;
    EditText city;

    Spinner experience;
    EditText details;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
    }

    public void onClickSubmit(View view){
        name = findViewById(R.id.fullName);
        email = findViewById(R.id.userEmailId);
        phoneNo = findViewById(R.id.mobileNumber);
        city = findViewById(R.id.city);
        //experience = findViewById(R.id.experience);
        details = findViewById(R.id.brief_details_text);
        password = findViewById(R.id.password);

        Tutor tutor = new Tutor(name.getText().toString(),city.getText().toString(),"French",
                email.getText().toString(),"Male","4 - 10years","J.S.S,S.S.S",
                password.getText().toString(),details.getText().toString());

        TutorSearchActivity sign = new TutorSearchActivity();
        sign.tutorList.add(tutor);

        Toast.makeText(getApplicationContext(),"Tutor Profile Successfully Updated",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,HireTutorActivity.class);
        startActivity(intent);
    }
}