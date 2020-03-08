package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;

import android.view.Menu;

import android.view.MenuItem;

import android.widget.ProgressBar;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.MoviesAdapter;
import com.example.myapplication.models.MovieResponse;
import com.example.myapplication.search.SearchActivity;

import butterknife.BindView;

import butterknife.ButterKnife;




public class MainActivity extends AppCompatActivity implements MainViewInterface {



    @BindView(R.id.rvMovies)

    RecyclerView rvMovies;



    @BindView(R.id.progressBar)

    ProgressBar progressBar;


    @BindView(R.id.toolbar)

    Toolbar toolbar;

    private String TAG = "MainActivity";

    RecyclerView.Adapter adapter;

    MainPresenter mainPresenter;

    //RecyclerView rvMovies;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        ButterKnife.bind(this);

        rvMovies = (RecyclerView) findViewById(R.id.rvMovies);

       // toolbar = (Toolbar) findViewById(R.id.toolbar);

        setupMVP();

        setupViews();

        getMovieList();

    }


    private void setupMVP() {

        mainPresenter = new MainPresenter(this);

    }



    private void setupViews(){

        setSupportActionBar(toolbar);

        rvMovies.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }



    private void getMovieList() {



        mainPresenter.getMovies();



    }







    @Override

    public void showToast(String str) {

        Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();

    }



    //@Override

    //public void showProgressBar() {

      //  progressBar.setVisibility(View.VISIBLE);

    //}

    //@Override

    //public void hideProgressBar() {

      //  progressBar.setVisibility(View.GONE);

    //}



    @Override

    public void displayMovies(MovieResponse movieResponse) {

        if(movieResponse!=null) {

            Log.d(TAG,movieResponse.getResults().get(1).getTitle());

            adapter = new MoviesAdapter(movieResponse.getResults(), MainActivity.this);

            rvMovies.setAdapter(adapter);

        }else{

            Log.d(TAG,"Movies response null");

        }

    }



    @Override

    public void displayError(String e) {



        showToast(e);



    }



    //Added in Part 2 of the series

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {



        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }



    @Override

    public boolean onOptionsItemSelected(MenuItem item) {



        int id = item.getItemId();

        if(id == R.id.search){

            showToast("Search Clicked");

            Intent i = new Intent(MainActivity.this, SearchActivity.class);

            startActivity(i);

        }



        return super.onOptionsItemSelected(item);

    }

}