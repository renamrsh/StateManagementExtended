package com.example.statemanagementextended;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    /*
    private static final String KEY_COUNT = "count";
    private static final String KEY_TEXT = "text";
    private static final String KEY_CheckBox = "checkState";
    private static final String KEY_Switcher = "switchState";
    */

    private CountViewModel countViewModel;

    private LinearLayout main;

    private TextView textViewCount;
    private Button increaseBtn;

    private EditText inputText;
    private TextView testmsg;

    private CheckBox checkBox;
    private TextView hideMsg;

    private Switch switcher;

    /*
    private int count = 0;
    private String text = "";
    private boolean switcherT = false;
    private boolean checkBoxT = false;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);

        textViewCount = findViewById(R.id.textViewCount);
        increaseBtn = findViewById(R.id.increaseBtn);

        inputText = findViewById(R.id.inputText);
        testmsg = findViewById(R.id.testmsg);

        switcher = findViewById(R.id.switcher);
        checkBox = findViewById(R.id.checkBox);
        hideMsg = findViewById(R.id.hideMsg);


        /*
        if(savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_COUNT);
            text = savedInstanceState.getString(KEY_TEXT);
            checkBoxT = savedInstanceState.getBoolean(KEY_CheckBox);
            switcherT = savedInstanceState.getBoolean(KEY_Switcher);
            if(checkBoxT){
                hideMsg.setVisibility(View.VISIBLE);
            } else {
                hideMsg.setVisibility(View.INVISIBLE);
            }
            if(switcherT){
                main.setBackgroundColor(Color.BLACK);
            } else {
                main.setBackgroundColor(Color.WHITE);
            }
        }
        */

        //
        countViewModel = new ViewModelProvider(this).get(CountViewModel.class);
        countViewModel.setTextInp(inputText.getText().toString());
        //

        updateText();
        updateCountText();
        updateCheckBox();
        updateSwitcher();

        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //count++;
                //
                countViewModel.incrementCount();
                updateCountText();
            }
        });

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if(switcher.isChecked()){
                    main.setBackgroundColor(Color.BLACK);
                    //
                    countViewModel.setSwitcherT(true);
                    //switcherT = true;
                } else {
                    main.setBackgroundColor(Color.WHITE);
                    //
                    countViewModel.setSwitcherT(false);
                    //switcherT = false;
                }
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if(checkBox.isChecked()){
                    hideMsg.setVisibility(View.VISIBLE);
                    //
                    countViewModel.setCheckBoxT(true);
                    //checkBoxT = true;
                } else {
                    hideMsg.setVisibility(View.INVISIBLE);
                    //
                    countViewModel.setCheckBoxT(false);
                    //checkBoxT = false;
                }
            }
        });
    }

    /*
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
        outState.putString(KEY_TEXT, inputText.getText().toString());
        outState.putBoolean(KEY_Switcher, switcherT);
        outState.putBoolean(KEY_CheckBox, checkBoxT);
    }
    */

    private void updateCountText(){
        //textViewCount.setText("Licznik: "+ count);
        textViewCount.setText("Licznik: "+ countViewModel.getCount());
    }
    private void updateText(){
        //inputText.setText(text);
        //testmsg.setText(text);

        inputText.setText(countViewModel.getTextInp());
        testmsg.setText(countViewModel.getTextInp());
    }
    private void updateSwitcher(){
        /*switcher.setChecked(switcherT);
        if(switcherT){
                main.setBackgroundColor(Color.BLACK);
        } else {
            main.setBackgroundColor(Color.WHITE);
        }*/

        switcher.setChecked(countViewModel.isSwitcherT());
        if(countViewModel.isSwitcherT()){
            main.setBackgroundColor(Color.BLACK);
        } else {
            main.setBackgroundColor(Color.WHITE);
        }
    }
    private void updateCheckBox(){
        /*checkBox.setChecked(checkBoxT);
        if(checkBoxT){
            hideMsg.setVisibility(View.VISIBLE);
        } else {
            hideMsg.setVisibility(View.INVISIBLE);
        }*/

        checkBox.setChecked(countViewModel.isCheckBoxT());
        if(countViewModel.isCheckBoxT()){
            hideMsg.setVisibility(View.VISIBLE);
        } else {
            hideMsg.setVisibility(View.INVISIBLE);
        }
    }
}