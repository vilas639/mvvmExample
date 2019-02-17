package com.example.hp_pc.mvvmexample.clean.domain;

import android.arch.lifecycle.MutableLiveData;

import com.example.hp_pc.mvvmexample.clean.data.model.User;

public interface UserCallback {
    void sucess(MutableLiveData<User> data);
    void failure(MutableLiveData<User> error);

}
