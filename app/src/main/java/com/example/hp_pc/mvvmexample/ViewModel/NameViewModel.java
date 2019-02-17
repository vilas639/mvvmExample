package com.example.hp_pc.mvvmexample.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.example.hp_pc.mvvmexample.Repository.NameRepository;

public class NameViewModel extends ViewModel{

    //need mutable data
    public MutableLiveData<String> data;
    //decclare field
    public ObservableField<String> name = new ObservableField<>("");
    private NameRepository nameRepository;

    public NameViewModel() {
        //data.setValue("first test vilas");
        nameRepository = new NameRepository();
        name.set("this is");
        data = nameRepository.getResponse() ;
    }


    public MutableLiveData<String> getData() {
        return data;
    }

}
