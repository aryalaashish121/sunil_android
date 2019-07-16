package com.example.football_club_app.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.football_club_app.R;
import com.example.football_club_app.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class News_Adapter extends RecyclerView.Adapter<News_Adapter.NewsViewHolder>{
    Context mContext;
    List<News> NewsList;
    Bitmap bitmap;
    public static final String BASE_URL= "http://10.0.2.2:100";

    public News_Adapter(Context mContext, List<News> newsList) {
        this.mContext = mContext;
        NewsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_news_view,viewGroup,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        final News news = NewsList.get(i);
        newsViewHolder.tvtitle.setText(news.getTitle());

        Picasso.with(mContext).load(BASE_URL+"/img/"+news.getImageName()).into(newsViewHolder.imgProfile);

        Toast.makeText(mContext, "Image Name: "+news.getImageName(), Toast.LENGTH_SHORT).show();


        newsViewHolder.tvtitle.setText(news.getTitle());
        newsViewHolder.tvdate.setText(news.getDate());
    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        ImageView imgProfile;
        TextView tvtitle,tvdate;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvdate = itemView.findViewById(R.id.tvdate);
            tvtitle = itemView.findViewById(R.id.tvtitle);
        }


    }
}
