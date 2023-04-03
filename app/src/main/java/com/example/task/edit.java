package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit extends AppCompatActivity {

    EditText name, newname, email, newemail, phone, newphone, status, newstatus, dob, newdob;

    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        db = new database(this);

        name = findViewById(R.id.name);
        newname = findViewById(R.id.newname);
        email = findViewById(R.id.textView5);
        newemail = findViewById(R.id.textView6);
        phone = findViewById(R.id.textView8);
        newphone = findViewById(R.id.textView9);
        status = findViewById(R.id.textView10);
        newstatus = findViewById(R.id.textView11);
        dob = findViewById(R.id.textView12);
        newdob = findViewById(R.id.textView13);

        Button edit = findViewById(R.id.button);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldName = name.getText().toString().trim();
                String newName = newname.getText().toString().trim();
                String oldEmail = email.getText().toString().trim();
                String newEmail = newemail.getText().toString().trim();
                String oldPhone = phone.getText().toString().trim();
                String newPhone = newphone.getText().toString().trim();
                String oldStatus = status.getText().toString().trim();
                String newStatus = newstatus.getText().toString().trim();
                String oldDob = dob.getText().toString().trim();
                String newDob = newdob.getText().toString().trim();

                boolean result = db.updateData(oldName, newName, oldEmail, newEmail, oldPhone, newPhone, oldStatus, newStatus, oldDob, newDob);

                if (result) {
                    Toast.makeText(edit.this, "Data updated successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(edit.this, "Failed to update data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
