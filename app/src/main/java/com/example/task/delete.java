package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {
    Button delete;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        delete = findViewById(R.id.delete);
        name = findViewById(R.id.name);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameToDelete = name.getText().toString();
                if (nameToDelete.isEmpty()) {
                    Toast.makeText(delete.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                    return;
                }
                database db = new database(delete.this);
                boolean result = db.deleteData(nameToDelete);
                if (result) {
                    Toast.makeText(delete.this, "User deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(delete.this, "Failed to delete user", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    }

