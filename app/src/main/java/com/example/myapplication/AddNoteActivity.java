package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    EditText title;
    EditText description;
    Button cancel;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_add_note);
        title=findViewById(R.id.editTextTitle);
        description=findViewById(R.id.editTextDescription);
        cancel=findViewById(R.id.cancel);
        save=findViewById(R.id.Save);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }

    public void saveNote(){
        String noteTitle=title.getText().toString();
        String noteDescription=description.getText().toString();
        Intent i=new Intent();
        i.putExtra("noteTitle",noteTitle);
        i.putExtra("noteDescription",noteDescription);
        setResult(RESULT_OK,i);
        finish();
    }
}