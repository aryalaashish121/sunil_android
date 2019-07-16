package com.example.football_club_app.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.football_club_app.R;
import com.example.football_club_app.model.Fixture;

import java.util.List;

public class Fixture_Adapter extends RecyclerView.Adapter<Fixture_Adapter.FixtureViewHolder>{
    Context context;



    List<Fixture> PlayerList;
    Bitmap bitmap;

    public static final String BASE_URL="http//10.0.2.2:100";

    public Fixture_Adapter(Context context, List<Fixture> playerList) {
        this.context = context;
        PlayerList = playerList;
    }


    @NonNull
    @Override
    public FixtureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_fixture_view,viewGroup,false);
        return new FixtureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FixtureViewHolder fixtureViewHolder, int i) {
        final Fixture fixture = PlayerList.get(i);
        fixtureViewHolder.place.setText(fixture.getPlace());
        fixtureViewHolder.date.setText(fixture.getDate());
        fixtureViewHolder.score.setText(fixture.getScore());
        fixtureViewHolder.match.setText(fixture.getMatch());

        Toast.makeText(context, "Fixture: "+fixture.getPlace(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return PlayerList.size();
    }

    public class FixtureViewHolder extends RecyclerView.ViewHolder{
        TextView place,date,score,match;

        public FixtureViewHolder(@NonNull View itemView) {
            super(itemView);
            place = itemView.findViewById(R.id.place);
            date = itemView.findViewById(R.id.date);
            score = itemView.findViewById(R.id.score);
            match = itemView.findViewById(R.id.match);
        }
    }
}
