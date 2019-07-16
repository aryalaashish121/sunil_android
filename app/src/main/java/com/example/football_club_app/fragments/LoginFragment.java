package com.example.football_club_app.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.football_club_app.API.Footballapi;
import com.example.football_club_app.R;
import com.example.football_club_app.activities.Dashboard;
import com.example.football_club_app.model.LoginModel;
import com.example.football_club_app.model.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginFragment extends Fragment {

    EditText username, password;
    Button login,fixture;
    Footballapi footballapi;
    SharedPreferences sharedPreferences;

    public LoginFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login1, container, false);

        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.pass);
        login = view.findViewById(R.id.login);



    if (username.getText().toString()==null){
        Vibrator vv = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);

        vv.vibrate(400);
    }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createInstance();
                LoginModel login = new LoginModel(username.getText().toString(), password.getText().toString());
                Call<LoginResponse> callreq = footballapi.userlogin(login);
                callreq.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getContext(), response.body().getToken(), Toast.LENGTH_SHORT).show();
                            sharedPreferences=getActivity().getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("usertoken",response.body().getToken());
                            editor.commit();
                            Toast.makeText(getContext(), "Login successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getContext(), Dashboard.class);
                            startActivity(intent);

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

            }
        });
        return  view;
    }

    private void createInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:/10.0.2.2:100/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        footballapi = retrofit.create(Footballapi.class);
    }

}
