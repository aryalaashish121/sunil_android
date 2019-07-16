package com.example.football_club_app.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.football_club_app.R;
import com.example.football_club_app.Adapterclass.ViewPagerAdapter;

public class UserFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        tabLayout = v.findViewById(R.id.tablayout_id);
        viewPager = v.findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.AddFragment(new LoginFragment(), "Login");
        adapter.AddFragment(new RegisterFragment(), "Register");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return v;

    }

}
