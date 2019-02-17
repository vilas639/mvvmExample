package com.example.hp_pc.mvvmexample.clean.data.repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.hp_pc.mvvmexample.clean.data.model.User;
import com.example.hp_pc.mvvmexample.clean.domain.UserCallback;

public class UserRepository {

    private MutableLiveData<User>  userMutableLiveData = new MutableLiveData<>();
    private  User user;

    public UserRepository() {
    }


    public MutableLiveData<User> getUserMutableLiveData() {

        //create a model
        user = new User("vilas");
        //set to live data
        userMutableLiveData.setValue(user);
        return userMutableLiveData;
    }


    public void getData(String name, UserCallback userCallback) {


        //create a model
        user = new User("vilas");

        if(name.equals("vilas"))
        {
            //set to live data
            userMutableLiveData.setValue(user);
            userCallback.sucess(userMutableLiveData);
           // return userMutableLiveData;
        }
        else
        {
            user = new User("Ram");
            userMutableLiveData.setValue(user);
            userCallback.failure(userMutableLiveData);

        }

    }


}
