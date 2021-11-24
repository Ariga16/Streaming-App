 package com.dacasa.streamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg,MovieCoverImg,floatingBtn;
    private TextView tv_title,tv_descripton;
    private RecyclerView rvCast;
    private CastAdapter castAdapter;

    //////online writing///
    ///toloka.yandex/////
    ////online writing////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        // ini views
        iniViews();
        //set up list cast
        setupRvCast();

        // get the data
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        MovieThumbnailImg.setImageResource(imageResourceId);
        floatingBtn = findViewById(R.id.play_fab);
    }

    private void iniViews() {
        rvCast = findViewById(R.id.rv_cast);
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_descripton = findViewById(R.id.detail_movie_desc);
        floatingBtn = findViewById(R.id.play_fab);

        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MoviePlayerActivity.class);
                startActivity(intent);
            }
        });


    }

    private void setupRvCast() {

        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name",R.drawable.userphoto));
        mdata.add(new Cast("name",R.drawable.omenlogo));
        mdata.add(new Cast("name",R.drawable.userphoto));
        mdata.add(new Cast("name",R.drawable.omenlogo));
        mdata.add(new Cast("name",R.drawable.userphoto));

        castAdapter = new CastAdapter(this,mdata);
        rvCast.setAdapter(castAdapter);
        rvCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }




}
