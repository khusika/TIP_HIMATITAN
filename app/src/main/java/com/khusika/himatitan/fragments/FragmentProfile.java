package com.khusika.himatitan.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khusika.himatitan.MainActivity;
import com.khusika.himatitan.R;

/**
 * Created by khusika on 14/10/16.
 */

public class FragmentProfile extends Fragment {



    private MainActivity mainActivity;
    private Toolbar toolbar;


    public FragmentProfile() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.about_toolbar);

        setupToolbar();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.profile_fragment_title));
        mainActivity.setSupportActionBar(toolbar);
    }


}
