package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button button2,logout;
    Spinner spinner;
    String[] choose = {"working", "student", "unemployed"};
    Button edit,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database d = new database(this);
        DatePicker datep = findViewById(R.id.datePicker);
        Calendar calendar = Calendar.getInstance();
        SQLiteDatabase db = d.getReadableDatabase();
        Button button2 = findViewById(R.id.button2);
        EditText et1 = findViewById(R.id.name);
        EditText et2 = findViewById(R.id.email);
        EditText et3 = findViewById(R.id.phone);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, choose);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        edit = findViewById(R.id.edit);
        delete = findViewById(R.id.delete);
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Home.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, edit.class);
                startActivity(intent);
            }
            });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,delete.class);
                startActivity(intent);
            }
        });


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(calendar.getTime());
        String selectedItem = spinner.getSelectedItem().toString();


        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = et1.getText().toString();
                String email = et2.getText().toString();
                String phone = et3.getText().toString();
                int year = datep.getYear();
                int month = datep.getMonth();
                int day = datep.getDayOfMonth();
                calendar.set(year, month, day);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = format.format(calendar.getTime());

                if (name.equals("") || email.equals("") || phone.equals("")) {
                    Toast.makeText(MainActivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean i = d.insert_data(name, email, phone, dateString, selectedItem);
                    if (i == true) {
                        Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Not Successful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button bt = findViewById(R.id.button4);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor t = d.getinfo();
                StringBuffer buffer = new StringBuffer();
                while (t.moveToNext()) {
                    buffer.append("name :" + t.getString(1) + "\n");
                    buffer.append("email :" + t.getString(2) + "\n");
                    buffer.append("phone :" + t.getString(3) + "\n");
                    buffer.append("dob :" + t.getString(5) + "\n");
                    buffer.append(t.getString(4) + "\n\n\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("SignUp Users Data");
                builder
                        .setMessage(buffer.toString())
                        .setPositiveButton("OK", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}