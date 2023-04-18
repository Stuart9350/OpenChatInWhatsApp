package com.example.openchatinwhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class HomeActivity extends AppCompatActivity {


    Button sendText;
    EditText phoneNo,msg;


    CountryCodePicker codePicker;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        getSupportActionBar().hide();


        sendText = findViewById(R.id.send);
        phoneNo = findViewById(R.id.phoneNumber);
        msg = findViewById(R.id.text);
        codePicker=findViewById(R.id.country_code);


        sendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phoneNo.getText().toString();
                String text = msg.getText().toString();
                String country_code=codePicker.getSelectedCountryCode();
                String url = "https://wa.me/+"+country_code+phone+"?text="+text;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });





    }
}