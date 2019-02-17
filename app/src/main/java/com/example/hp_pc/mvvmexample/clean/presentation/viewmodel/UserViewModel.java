package com.example.hp_pc.mvvmexample.clean.presentation.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.hp_pc.mvvmexample.clean.data.model.User;
import com.example.hp_pc.mvvmexample.clean.data.repository.UserRepository;
import com.example.hp_pc.mvvmexample.clean.domain.UserCallback;

public class UserViewModel extends ViewModel {

    //call  repository
    private UserRepository userRepository;
    public MutableLiveData<User> MutableLiveData;


    public UserViewModel() {
        userRepository = new UserRepository();
        MutableLiveData= userRepository.getUserMutableLiveData();
    }

    public  void CallData()
    {
        userRepository  = new UserRepository();
       // MutableLiveData= userRepository.getUserMutableLiveData();
        userRepository.getData("vilas", new UserCallback() {
            @Override
            public void sucess(MutableLiveData<User> data) {
                MutableLiveData = data;
            }

            @Override
            public void failure(MutableLiveData<User> error) {
               MutableLiveData = error;
            }
        });
    }
}
