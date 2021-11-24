package com.dacasa.streamingapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.dacasa.streamingapp.cv.CvFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstslides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV,moviesRvWeek,menuRv;
    private List<MenuItem> menuItems;



    // options menu in toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.cv_portfolio_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.cv_portfolio) {

            Intent intent = new Intent(getApplicationContext(),CVMainActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();
    }

    private void iniWeekMovies() {

        MovieAdapter weekMovieAdapter = new MovieAdapter(this,DataSource.getWeekMovies(),this);
        moviesRvWeek.setAdapter(weekMovieAdapter);
        moviesRvWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }

    private void iniPopularMovies() {
        //recyclerview setup
        // ini data
        MovieAdapter movieAdapter = new MovieAdapter(this,DataSource.getPopularMovies(),this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniSlider() {
        lstslides = new ArrayList<>();
        lstslides.add(new Slide(R.drawable.bat,"Battlefield \nseason 1"));
        lstslides.add(new Slide(R.drawable.cover9,"Fright \nNight"));
        lstslides.add(new Slide(R.drawable.cover2,"Orphan"));
        lstslides.add(new Slide(R.drawable.cover4,"Mad max"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstslides);
        sliderpager.setAdapter(adapter);
        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);
        indicator.setupWithViewPager(sliderpager,true);
    }

    private void iniViews() {
        sliderpager = findViewById(R.id.sliderPager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);
        moviesRvWeek = findViewById(R.id.rv_movies_week);
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
       // Toast.makeText(this,"item clicked : " + movie.getTitle(),Toast.LENGTH_LONG).show();
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
