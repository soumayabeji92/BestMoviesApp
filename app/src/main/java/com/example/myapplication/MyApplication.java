package com.example.myapplication;

import android.app.Application;
import com.example.myapplication.modules.ApplicationComponent;
import com.example.myapplication.modules.ApplicationModule;
import com.example.myapplication.modules.DaggerApplicationComponent;


public class MyApplication extends Application {



    private static ApplicationComponent applicationComponent;



    public MyApplication(){



    }

    @Override

    public void onCreate() {

        super.onCreate();



        applicationComponent = DaggerApplicationComponent

                .builder()

               // .applicationModule(new ApplicationModule(this))

                .build();



    }



    public ApplicationComponent getApplicationComponent(){

        return applicationComponent;

    }



}