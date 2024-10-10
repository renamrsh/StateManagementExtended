package com.example.statemanagementextended;

import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {
    private int count = 0;
    private String textInp = "";
    private boolean switcherT = false;
    private boolean checkBoxT = false;

    //getter
    public int getCount(){
        return count;
    }
    //setter
    public void incrementCount(){
        count++;
    }


    public String getTextInp(){
        return textInp;
    }

    public void setTextInp(String textInp){
        this.textInp = textInp;
    }


    public boolean isSwitcherT() {
        return switcherT;
    }

    public void setSwitcherT(boolean switcherT) {
        this.switcherT = switcherT;
    }


    public boolean isCheckBoxT() {
        return checkBoxT;
    }

    public void setCheckBoxT(boolean checkBoxT) {
        this.checkBoxT = checkBoxT;
    }
}
