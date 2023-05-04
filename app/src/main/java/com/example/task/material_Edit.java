package com.example.task;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class material_Edit extends AppCompatActivity {
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_edit);
        db = new database(this);
        Button name=findViewById(R.id.button7);
        Button phone=findViewById(R.id.button8);
        Button email=findViewById(R.id.button9);
        Button pass=findViewById(R.id.button11);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(material_Edit.this);
                builder.setTitle("Change name");
                LinearLayout lay=new LinearLayout(material_Edit.this);
                lay.setOrientation(LinearLayout.VERTICAL);
                EditText oname=new EditText(material_Edit.this);
                oname.setHint("Enter old name");
                EditText nname=new EditText(material_Edit.this);
                nname.setHint("Enter new name");
                lay.addView(oname);
                String oldName = oname.getText().toString().trim();
                String newName = nname.getText().toString().trim();
lay.addView(nname);
                builder.setView(lay);
                       builder .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {

                                   }
                               });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                builder.show();
            }
        });
email.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder=new AlertDialog.Builder(material_Edit.this);
        builder.setTitle("Change Email");
        LinearLayout lay=new LinearLayout(material_Edit.this);
        lay.setOrientation(LinearLayout.VERTICAL);
        EditText oname=new EditText(material_Edit.this);
        oname.setHint("Enter old Email");
        EditText nname=new EditText(material_Edit.this);
        nname.setHint("Enter new Email");
        lay.addView(oname);
        String oldName = oname.getText().toString().trim();
        String newName = nname.getText().toString().trim();
        lay.addView(nname);
        builder.setView(lay);
        builder .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();

    }
});
pass.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder=new AlertDialog.Builder(material_Edit.this);
        builder.setTitle("Change Password");
        LinearLayout lay=new LinearLayout(material_Edit.this);
        lay.setOrientation(LinearLayout.VERTICAL);
        EditText oname=new EditText(material_Edit.this);
        oname.setHint("Enter old Password");
        EditText nname=new EditText(material_Edit.this);
        nname.setHint("Enter new Password");
        lay.addView(oname);
        String oldName = oname.getText().toString().trim();
        String newName = nname.getText().toString().trim();
        lay.addView(nname);
        builder.setView(lay);
        builder .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }

});
phone.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder=new AlertDialog.Builder(material_Edit.this);
        builder.setTitle("Change phone number");
        LinearLayout lay=new LinearLayout(material_Edit.this);
        lay.setOrientation(LinearLayout.VERTICAL);
        EditText oname=new EditText(material_Edit.this);
        oname.setHint("Enter old phone number");
        EditText nname=new EditText(material_Edit.this);
        nname.setHint("Enter phone number");
        lay.addView(oname);
        String oldName = oname.getText().toString().trim();
        String newName = nname.getText().toString().trim();
        lay.addView(nname);
        builder.setView(lay);
        builder .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();

    }
});
    }
}