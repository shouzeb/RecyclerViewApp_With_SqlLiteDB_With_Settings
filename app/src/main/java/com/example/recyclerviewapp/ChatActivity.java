package com.example.recyclerviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener{
    EditText name,age,class_,id;
    Button b1,b2;
    dp_helper_class db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        class_=findViewById(R.id.class_);
        id=findViewById(R.id.id);
        b1=findViewById(R.id.savebtn);
        b2=findViewById(R.id.retrieveBtn);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        db=new dp_helper_class(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.savebtn:{
                db.insertData(id.getText().toString(),name.getText().toString(),Integer.parseInt(age.getText().toString()),class_.getText().toString());
                Toast.makeText(this,"Data Saved.",Toast.LENGTH_LONG).show();
                break;


            }
            case R.id.retrieveBtn:{
                ArrayList<Students_data_model> st= db.getAllData(" where id= "+id.getText().toString());
                id.setText(st.get(0).getId());
                name.setText(st.get(0).getName());
                age.setText(String.valueOf(st.get(0).getAge()));
                class_.setText(st.get(0).getClass_());
                Toast.makeText(this,"Data retrived Hurry!",Toast.LENGTH_LONG).show();
                break;
            }

    }


        }
    }

