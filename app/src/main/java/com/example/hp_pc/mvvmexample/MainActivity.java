package com.example.hp_pc.mvvmexample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hp_pc.mvvmexample.Presenter.NamePresenter;
import com.example.hp_pc.mvvmexample.ViewModel.NameViewModel;
import com.example.hp_pc.mvvmexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private NameViewModel nameViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

       nameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);

        activityMainBinding.setNameViewModel(nameViewModel);
     //   activityMainBinding.setLifecycleOwner(this);

        //observe data

        nameViewModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                activityMainBinding.mydata.setText(s);
            }
        });

        activityMainBinding.setNamePresenter(new NamePresenter() {
            @Override
            public void getdata() {

               nameViewModel.name.set("updated post");
               // nameViewModel.data.setValue("this is first approch");
            }
        });

    }
}
