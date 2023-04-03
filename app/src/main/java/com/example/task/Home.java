package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Button button=findViewById(R.id.login);
       password=findViewById(R.id.password);
        EditText username=findViewById(R.id.username);
        List<MainActivity2> users =new ArrayList<>();
        MainActivity2 ram =new MainActivity2(  "1010", "1010");
        users.add(ram);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() ==R.id.login && username.getText().toString().isEmpty()&&  password.getText().toString().isEmpty()) {
                    Toast.makeText(Home.this, "Please enter Username and Password", Toast.LENGTH_SHORT).show();
                }
                if(view.getId() ==R.id.login &&! username.getText().toString().isEmpty()&& ! password.getText().toString().isEmpty()) {
                String password_Entered, username_Entered;
                Boolean login=false;
                password_Entered=password.getText().toString();
                username_Entered=username.getText().toString();
                for (MainActivity2 user:users) {
                    if (password_Entered.equals(user.getPassword()) && username_Entered.equals(user.getUserName())) {
                        login=true;
                    }
                }
                if (login){
                Toast.makeText(Home.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Home.this,MainActivity.class);
                        startActivity(intent);}
                else{
                    Toast.makeText(Home.this, "Login UnSuccessfull", Toast.LENGTH_SHORT).show();
                    }}
                    }


        });
    }
}