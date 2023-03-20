package com.example.a1181375_raneennaqeeti_todo2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout secondLinearLayout;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("prefs",MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart",true);
        if(firstStart) {
            showStartData();
        }
        secondLinearLayout = new LinearLayout(this);
        LinearLayout firstLinearLayout = new LinearLayout(this);
        LinearLayout thirdLinearLayout = new LinearLayout(this);
        LinearLayout fourthLinearLayout = new LinearLayout(this);
        Button addButton = new Button(this);
        Button addButton2 = new Button(this);
        Button all_B_SButton = new Button(this);
        Button showButton1 = new Button(this);
        Button showButton2 = new Button(this);
        Button showButton3 = new Button(this);
        ScrollView scrollView = new ScrollView(this);
        firstLinearLayout.setOrientation(LinearLayout.VERTICAL);
        secondLinearLayout.setOrientation(LinearLayout.VERTICAL);
        thirdLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        fourthLinearLayout.setOrientation(LinearLayout.VERTICAL);
        addButton.setText("   Add Boat  ");
        addButton2.setText(" Add Sailor ");
        showButton1.setText("#OF SAILORS/NATIONALITY");
        showButton2.setText("NAME OF BOATS/RED COLOR");
        showButton3.setText("NAME OF PALESTINIAN SAILORS WITH RED BOAT ");
        all_B_SButton.setText("Show ALL BOATS & SAILORS");
        thirdLinearLayout.addView(addButton);
        thirdLinearLayout.addView(addButton2);
        thirdLinearLayout.addView(all_B_SButton);
        fourthLinearLayout.addView(showButton1);
        fourthLinearLayout.addView(showButton2);
        fourthLinearLayout.addView(showButton3);
        firstLinearLayout.addView(thirdLinearLayout);
        firstLinearLayout.addView(fourthLinearLayout);
        scrollView.addView(secondLinearLayout);
        firstLinearLayout.addView(scrollView);
        setContentView(firstLinearLayout);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new
                        Intent(MainActivity.this, activity_add_boat.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new
                        Intent(MainActivity.this, activity_add_sailor.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

        all_B_SButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onResume();
            }
        });

        showButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper =new
                        DataBaseHelper(MainActivity.this,"M1181375", null,1);
                Cursor SailorsNumber = dataBaseHelper.getAllSailorsNumbers();
                secondLinearLayout.removeAllViews();
                while (SailorsNumber.moveToNext()) {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(
                            "Palestinian = "+SailorsNumber.getString(0)
                                    +"\n\nJordanian = "+SailorsNumber.getString(1)
                                    +"\n\nQatari = "+SailorsNumber.getString(2)
                                    +"\n\n"
                    );
                    secondLinearLayout.addView(textView);
                }

            }
        });
        showButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper =new
                        DataBaseHelper(MainActivity.this,"M1181375", null,1);
                Cursor allRedBoatsName = dataBaseHelper.getRedBoatsName();
                secondLinearLayout.removeAllViews();
                int i=0;
                while (allRedBoatsName.moveToNext()) {
                    i++;
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(
                            "NAME_"+i+" = " + allRedBoatsName.getString(0)
                                    +"\n\n"
                    );
                    secondLinearLayout.addView(textView);
                }


            }
        });
        showButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper =new
                        DataBaseHelper(MainActivity.this,"M1181375", null,1);
                Cursor PalestinianRed = dataBaseHelper.getPalestiniansRed();
                secondLinearLayout.removeAllViews();
                int i=0;
                while (PalestinianRed.moveToNext()) {
                    i++;
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(
                            "NAME_"+i+" = " + PalestinianRed.getString(0)
                                    +"\n\n"
                    );
                    secondLinearLayout.addView(textView);
                }

            }
        });

    }

    private void showStartData() {
        boat boat1 = new boat(1, "one", "Red");
        boat boat2 = new boat(2, "two", "White");
        boat boat3 = new boat(3, "three", "Red");

        sailor sailor1 = new sailor(1,1,"raneen","Palestinian");
        sailor sailor2 = new sailor(2,2,"nemat","Palestinian");
        sailor sailor3 = new sailor(3,3,"nqaa","Jordanian");

        dataBaseHelper = new DataBaseHelper(MainActivity.this, "M1181375", null, 1);

        dataBaseHelper.insertBoat(boat1);
        dataBaseHelper.insertBoat(boat2);
        dataBaseHelper.insertBoat(boat3);

        dataBaseHelper.insertSailor(sailor1);
        dataBaseHelper.insertSailor(sailor2);
        dataBaseHelper.insertSailor(sailor3);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();

    }

    protected void onResume() {
            super.onResume();
            DataBaseHelper dataBaseHelper =new
                    DataBaseHelper(MainActivity.this,"M1181375", null,1);
            Cursor allBoatsCursor = dataBaseHelper.getAllBoats();

            Cursor allSailorsCursor = dataBaseHelper.getAllSailors();
            secondLinearLayout.removeAllViews();
            while (allBoatsCursor.moveToNext()){
                TextView textView =new TextView(MainActivity.this);
                textView.setText(
                        "BoatId = "+allBoatsCursor.getString(0)
                                +"\nBoatName = "+allBoatsCursor.getString(1)
                                +"\nBoatColor = "+allBoatsCursor.getString(2)
                                +"\n\n"

                );
                secondLinearLayout.addView(textView);
            }

            while (allSailorsCursor.moveToNext()){
                TextView textView =new TextView(MainActivity.this);
                textView.setText(
                        "SailorId = "+allSailorsCursor.getString(0)
                                +"\nBoatId = "+allSailorsCursor.getString(1)
                                +"\nSailorName = "+allSailorsCursor.getString(2)
                                +"\nSailorNationality = "+allSailorsCursor.getString(3)
                                +"\n\n"

                );
                secondLinearLayout.addView(textView);
            }
        }

}













