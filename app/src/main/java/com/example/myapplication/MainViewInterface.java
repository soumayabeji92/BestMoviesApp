package com.example.myapplication;

import com.example.myapplication.models.MovieResponse;

public interface MainViewInterface {



    void showToast(String s);

    void displayMovies(MovieResponse movieResponse);

    void displayError(String s);

}