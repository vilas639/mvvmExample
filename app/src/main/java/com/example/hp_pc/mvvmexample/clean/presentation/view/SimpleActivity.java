package com.example.hp_pc.mvvmexample.clean.presentation.view;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hp_pc.mvvmexample.R;
import com.example.hp_pc.mvvmexample.clean.data.model.User;
import com.example.hp_pc.mvvmexample.clean.presentation.presenter.UserPresenter;
import com.example.hp_pc.mvvmexample.clean.presentation.viewmodel.UserViewModel;
import  com.example.hp_pc.mvvmexample.databinding.ActivitySimpleBinding;

public class SimpleActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
   // TextView txtname;
    private  ActivitySimpleBinding activitySimpleBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_simple);

        activitySimpleBinding = DataBindingUtil.setContentView(this,R.layout.activity_simple);
         //txtname = (TextView) findViewById(R.id.txtname);
        userViewModel = new UserViewModel();


        activitySimpleBinding.setUser(new UserPresenter() {
            @Override
            public void calldata() {
                userViewModel.CallData();
                userViewModel.MutableLiveData.observe(SimpleActivity.this, new Observer<User>() {
                    @Override
                    public void onChanged(@Nullable User user) {
                        Log.d("name",""+user.getName());
                        //txtname.setText(user.getName());
                        activitySimpleBinding.txtname.setText(""+user.getName());
                    }
                });
            }
        });

    }
}
