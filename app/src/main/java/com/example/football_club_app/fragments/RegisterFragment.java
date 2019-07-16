package com.example.football_club_app.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.football_club_app.API.Footballapi;
import com.example.football_club_app.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterFragment extends Fragment {
EditText fname,contact,address,email,username,password;
Button register;
String fullname,user_contact,user_address,user_email,user_username,user_password;
Footballapi footballapi;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_register1, container, false);
      fname = view.findViewById(R.id.fname);
      contact = view.findViewById(R.id.contact);
      address = view.findViewById(R.id.address);
      email = view.findViewById(R.id.email);
      username = view.findViewById(R.id.username);
      password = view.findViewById(R.id.password);
      register = view.findViewById(R.id.register);

      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


              if (TextUtils.isEmpty(fname.getText().toString())){
                  fname.setError("Please Enter fullname");
                  fname.requestFocus();
              }

              else  if (TextUtils.isEmpty(contact.getText().toString())){
                  contact.setError("Please Enter Your contact");
                  contact.requestFocus();
              }
              else  if (TextUtils.isEmpty(address.getText().toString())){
                  address.setError("Please Enter your Address");
                  address.requestFocus();
              }


              else  if (TextUtils.isEmpty(email.getText().toString())){
                  email.setError("Please Enter your Email");
                  email.requestFocus();
              }


              else  if (TextUtils.isEmpty(username.getText().toString())){
                  username.setError("Please Enter your Username");
                  username.requestFocus();
              }

              else  if (TextUtils.isEmpty(password.getText().toString())){
                  password.setError("Please Enter your password");
                  password.requestFocus();
              }

              else {
                  fullname=fname.getText().toString();
                  user_contact =contact.getText().toString();
                  user_address =address.getText().toString();
                  user_email = email.getText().toString();
                  user_username =username.getText().toString();
                  user_password = password.getText().toString();

                  registerUser();


                  fname.setText("");
                  contact.setText("");
                  address.setText("");
                  email.setText("");
                  username.setText("");
                  password.setText("");
              }

          }
      });

      return view;

    }

    private void createInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:/10.0.2.2:100/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        footballapi = retrofit.create(Footballapi.class);
    }

    private void registerUser() {
        createInstance();

        Call<String> usersCall = footballapi.registerUser(
                fullname,
                user_contact,
                user_address,
                user_email,
                user_username,
                user_password);



        System.out.println("User details \tUsername:" + username + "\fname:" + fname);

        usersCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getActivity(),response.body(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
    System.out.println("Error "+t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Error "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
