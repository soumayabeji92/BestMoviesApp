package com.example.myapplication.modules;

import android.app.Application;

import android.content.Context;



import javax.inject.Singleton;



import dagger.Module;

import dagger.Provides;



@Module

public class ApplicationModule {



    private Application app;



    public ApplicationModule(Application app){

        this.app = app;

    }





    @Provides

    @Singleton

    Context provideContext(){

        return app;

    }



}