package com.kipruto.guest.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kipruto.guest.model.Home;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

   //private MutableLiveData<String> mText;

   /** public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }**/

   MutableLiveData<ArrayList<Home>> userLiveData;
    ArrayList<Home> userArrayList;

    public HomeViewModel() {
        userLiveData = new MutableLiveData<>();
        // call your Rest API in init method
        init();
    }
    public MutableLiveData<ArrayList<Home>> getUserMutableLiveData() {
        return userLiveData;
    }
    public void init(){
        populateList();
        userLiveData.setValue(userArrayList);
    }
    public void populateList(){

        Home home = new Home();
        home.setFirstName("Darknight");
        home.setLastName("Best rating movie");

        userArrayList = new ArrayList<>();
        userArrayList.add(home);
        userArrayList.add(home);
        userArrayList.add(home);
        userArrayList.add(home);
        userArrayList.add(home);
        userArrayList.add(home);
    }


    //public LiveData<String> getText() {return mText;}
}
