package com.example.statemanagementextended;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    //private static final String KEY_COUNT = "count";
    private CountViewModel countViewModel;
    private TextView textViewCount;
    //private int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewCount = findViewById(R.id.textViewCount);
        Button increaseBtn = findViewById(R.id.increaseBtn);
        CheckBox checkBox = findViewById(R.id.checkBox);

        /*if(savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_COUNT);
        }*/
        countViewModel = new ViewModelProvider(this).get(CountViewModel.class);
        updateCountText();

        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //count++;
                countViewModel.incrementCount();
                updateCountText();
            }
        });


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if(checkBox.isChecked()){

                } else {

                }
            }
        });

    }

    /*@Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }*/
    private void updateCountText(){
        textViewCount.setText("Licznik: "+ countViewModel.getCount());
    }
}