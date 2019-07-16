package com.example.football_club_app.API;

import com.example.football_club_app.model.Fixture;
import com.example.football_club_app.model.News;
import com.example.football_club_app.model.LoginModel;
import com.example.football_club_app.model.LoginResponse;
import com.example.football_club_app.model.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Footballapi {
    @FormUrlEncoded
    @POST("user_register")
    Call<String> registerUser(@Field("fname") String full_name,@Field("contact") String contact_number,@Field("address") String address_user,@Field("email")
            String email_user,@Field("username") String name,@Field("password") String password_user);

    @POST("login77")
    Call<LoginResponse> userlogin(@Body LoginModel login);

    @GET("getNewshdata")
    Call<List<News>> getNewsdata();

    @GET("getplayer")
    Call<List<Player>> getplayer();

    @GET("getMatchdata")
    Call<List<Fixture>> getMatchdata();

}



