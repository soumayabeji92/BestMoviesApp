package com.example.myapplication.network;



import com.example.myapplication.models.MovieResponse;

import io.reactivex.Observable;

import retrofit2.http.GET;

import retrofit2.http.Query;

public interface NetworkInterface {



    @GET("discover/movie")

    Observable<MovieResponse> getMovies(@Query("api_key") String api_key);



    @GET("search/movie")

    Observable<MovieResponse> getMoviesBasedOnQuery(@Query("api_key") String api_key, @Query("query") String q);

}