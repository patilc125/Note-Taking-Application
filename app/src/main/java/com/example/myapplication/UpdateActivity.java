package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText title;
    EditText description;
    Button cancel;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        setContentView(R.layout.activity_add_note1);
        title=findViewById(R.id.editTextTitleUpdate);
        description=findViewById(R.id.editTextDescriptionUpdate);
        cancel=findViewById(R.id.cancelUpdate);
        save=findViewById(R.id.SaveUpdate);
        getDate();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNote();
            }
        });
    }
    private void updateNote(){

    }
    public void getDate(){
        Intent i=getIntent();
        int id= i.getIntExtra("id",-1);
        String notetitle=i.getStringExtra("title");
        String notedescription=i.getStringExtra("description");
        title.setText(notetitle);
        description.setText(notedescription);

    }
}