package com.dacasa.streamingapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstslides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderpager = findViewById(R.id.sliderPager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);

        lstslides = new ArrayList<>();
        lstslides.add(new Slide(R.drawable.bat,"Slide Title \nmore text here"));
        lstslides.add(new Slide(R.drawable.omenlogo,"Slide Title \nmore text here"));
        lstslides.add(new Slide(R.drawable.bat,"Slide Title \nmore text here"));
        lstslides.add(new Slide(R.drawable.omenlogo,"Slide Title \nmore text here"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstslides);
        sliderpager.setAdapter(adapter);
        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),4000,6000);
        indicator.setupWithViewPager(sliderpager,true);

        //recyclerview setup
        // ini data
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Mercy",R.drawable.omenlogo,R.drawable.bat));
        lstMovies.add(new Movie("Screenshot",R.drawable.screenshot,R.drawable.bat));
        lstMovies.add(new Movie("Mzee mzima",R.drawable.omenlogo));
        lstMovies.add(new Movie("Mzee mzima",R.drawable.default_indicator));
        lstMovies.add(new Movie("Mzee mzima",R.drawable.omenlogo));
        lstMovies.add(new Movie("Mzee mzima",R.drawable.selected_indicator));


        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies,this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        Intent intent = new Intent(this,MovieDetailActivity.class);
        // send movie info to detailActivity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,movieImageView,"SharedName");
        startActivity(intent,options.toBundle());


        Toast.makeText(this,"item clicked : " + movie.getTitle(),Toast.LENGTH_LONG).show();
    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstslides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });

        }
    }


}
