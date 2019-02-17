package com.example.hp_pc.mvvmexample.Repository;

import android.arch.lifecycle.MutableLiveData;

public class NameRepository {

    public NameRepository() {
    }

    public MutableLiveData<String> getResponse()
    {
        final  MutableLiveData<String> data = new MutableLiveData<>();
        return  data;
    }
}
