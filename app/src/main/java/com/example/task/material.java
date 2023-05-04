package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class material extends AppCompatActivity {
int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
       Button button=findViewById(R.id.button6);
        ImageView logout=findViewById(R.id.imageView3);
        database d = new database(this);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(material.this,welcome.class);
                startActivity(intent);
                Toast.makeText(material.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            }
        });
        new MaterialTapTargetPrompt.Builder(material.this)
                .setTarget(logout)
                .setPrimaryText("Logout")
                .setBackgroundColour(Color.parseColor("#008080"))
                .setSecondaryText("Tap the button to logout")
                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener()
                {
                    @Override
                    public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state)
                    {
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED)
                        {
                            // User has pressed the prompt target

                            Toast.makeText(material.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Name=findViewById(R.id.name);
                EditText Email=findViewById(R.id.email);
                EditText Phone=findViewById(R.id.phone);
                EditText Pass=findViewById(R.id.pass);
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String phone = Phone.getText().toString();
                String pass=Pass.getText().toString();
                if (name.equals("") || email.equals("") || phone.equals("")|| pass.equals("")) {
                    Toast.makeText(material.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean i = d.insert_data(name, email, phone);
                    if (i == true) {
                        Toast.makeText(material.this, "Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(material.this, "Not Successful", Toast.LENGTH_SHORT).show();
                    }
                }
                ProgressBar progressBar=findViewById(R.id.prog);
                progressBar.setVisibility (v.VISIBLE);
                Timer timer = new Timer();
                TimerTask timer_Task = new TimerTask() {
                    @Override
                    public void run() {
                        counter++;
                        progressBar.setProgress (counter);
                        if (counter ==20)
                        {

                            timer.cancel();

                        }
                    }                };
                timer.schedule (timer_Task , 50, 50);
            }
        });


    }
}
