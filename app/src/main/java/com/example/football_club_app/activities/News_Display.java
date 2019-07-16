package com.example.football_club_app.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.football_club_app.API.Footballapi;
import com.example.football_club_app.R;
import com.example.football_club_app.model.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class News_Display extends AppCompatActivity {

    private RecyclerView recyclerView;
    Retrofit retrofit;
    private static final String BASE_URL = "http://10.0.2.2:100";

    Footballapi footballapi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__display);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(News_Display.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        footballapi = retrofit.create(Footballapi.class);

        Call<List<News>> call = footballapi.getNewsdata();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                List<News> newsList = response.body();
                recyclerView.setAdapter(new News_Adapter(getApplicationContext(), newsList));
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

            }
        });

    }
}
