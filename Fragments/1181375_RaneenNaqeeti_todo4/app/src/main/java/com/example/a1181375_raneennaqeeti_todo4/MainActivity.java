package com.example.a1181375_raneennaqeeti_todo4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.communicator,SecondFragment.communicator,ThirdFragment.communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void respond(String data) {
        FirstFragment ff1 =
                (FirstFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        assert ff1 != null;
        ff1.changeData(data);
    }

    @Override
    public void respond1(String data) {
        SecondFragment ff2 =
                (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
        assert ff2 != null;
        ff2.changeData(data);
    }

    @Override
    public void respond2(String data) {
        ThirdFragment ff3 =
                (ThirdFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView3);
        assert ff3 != null;
        ff3.changeData(data);
    }
}