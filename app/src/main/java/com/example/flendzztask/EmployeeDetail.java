package com.example.flendzztask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class EmployeeDetail extends AppCompatActivity {

    TextView id, name, email, suite, street, city, zipcode, phone, companyName, website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        id = findViewById(R.id.viewEmployeeId);
        name = findViewById(R.id.viewEmployeeName);
        email = findViewById(R.id.viewEmployeeEmail);
        suite = findViewById(R.id.viewEmployeeSuite);
        street = findViewById(R.id.viewEmployeeStreet);
        city = findViewById(R.id.viewEmployeeCity);
        zipcode = findViewById(R.id.viewEmployeeZipcode);
        phone = findViewById(R.id.viewEmployeePhone);
        companyName = findViewById(R.id.viewEmployeeCompanyName);
        website = findViewById(R.id.viewEmployeeWebsite);

        Intent intent = getIntent();
        id.setText(intent.getStringExtra("id"));
        name.setText(intent.getStringExtra("name"));
        email.setText(intent.getStringExtra("mailId"));
        email.setAutoLinkMask(Linkify.EMAIL_ADDRESSES);
        suite.setText(intent.getStringExtra("suite"));
        street.setText(intent.getStringExtra("street"));
        city.setText(intent.getStringExtra("city"));
        zipcode.setText(intent.getStringExtra("zipcode"));
        phone.setText(intent.getStringExtra("phoneNumber"));
        phone.setAutoLinkMask(Linkify.PHONE_NUMBERS);
        companyName.setText(intent.getStringExtra("companyName"));
        website.setText(intent.getStringExtra("website"));
    }
}