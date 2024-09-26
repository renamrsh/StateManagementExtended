package com.example.statemanagementextended;

import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {
    private int count =0;

    //getter
    public int getCount(){
        return count;
    }

    //setter
    public void incrementCount(){
        count++;
    }
}
