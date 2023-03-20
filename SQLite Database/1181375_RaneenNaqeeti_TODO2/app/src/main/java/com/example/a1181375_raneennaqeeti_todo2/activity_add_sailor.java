package com.example.a1181375_raneennaqeeti_todo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class activity_add_sailor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sailor);
        String[] options = { "Palestinian", "Jordanian","Qatari"};
        final Spinner nationalitySpinner =(Spinner)
                findViewById(R.id.spinner_Nationality);
        ArrayAdapter<String> objNationalityArr = new
                ArrayAdapter<>(this,android.R.layout.simple_spinner_item, options);
        nationalitySpinner.setAdapter(objNationalityArr);

        final EditText boatIdEditText =
                (EditText)findViewById(R.id.edit_boatId_s);

        final EditText sailorNameEditText =
                (EditText)findViewById(R.id.edit_sailorName);

        Button addSailorButton = (Button) findViewById(R.id.add_sailor);
        addSailorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sailor newSailor =new sailor();

                if(boatIdEditText.getText().toString().isEmpty()) newSailor.setmBoatId(0);
                else newSailor.setmBoatId(Integer.parseInt(boatIdEditText.getText().toString()));

                if(sailorNameEditText.getText().toString().isEmpty()) newSailor.setmName("No Name");
                else newSailor.setmName(sailorNameEditText.getText().toString());

                newSailor.setmNationality(nationalitySpinner.getSelectedItem().toString());


                DataBaseHelper dataBaseHelper =new DataBaseHelper(activity_add_sailor.this,"M1181375",null,1);
                dataBaseHelper.insertSailor(newSailor);

                Intent intent=new Intent(activity_add_sailor.this,MainActivity.class);
                activity_add_sailor.this.startActivity(intent);
                finish();
            }
        });

        Button BackButton = (Button) findViewById(R.id.button_back2);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity_add_sailor.this,MainActivity.class);
                activity_add_sailor.this.startActivity(intent);
                finish();
            }
        });
    }
}






















