package com.kipruto.guest.ui.add_new_guest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Add_New_GuestViewModel extends ViewModel {

    private MutableLiveData<String> mText = new MutableLiveData<>() ;

    public void setName(String name){
        mText.setValue(name);
    }

    public LiveData<String> getText() {
        return mText;
    }
}