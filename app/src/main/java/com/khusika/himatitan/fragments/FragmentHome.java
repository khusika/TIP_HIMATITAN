package com.khusika.himatitan.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khusika.himatitan.MainActivity;
import com.khusika.himatitan.R;
import com.khusika.himatitan.adapters.RecyclerAdapter;
import com.khusika.himatitan.models.CardItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khusika on 12/10/16.
 */

public class FragmentHome extends Fragment {

    private List<CardItemModel> cardItems = new ArrayList<>(30);
    private MainActivity appCompatActivity;
    private Toolbar toolbar;
    private RecyclerView recyclerView;


    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        appCompatActivity = (MainActivity)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.home_toolbar);

        setupToolbar();

        ((CollapsingToolbarLayout)view.findViewById(R.id.fragment_home)).setTitle(
                getString(R.string.home_fragment_title));

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        setupRecyclerView();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appCompatActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle("");
        appCompatActivity.setSupportActionBar(toolbar);
    }

    private void setupRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(appCompatActivity));
        recyclerView.setHasFixedSize(true);
        initializeCardItemList();
        recyclerView.setAdapter(new RecyclerAdapter(cardItems));
    }

    private void initializeCardItemList(){
        CardItemModel cardItemModel;
        String[] cardTitles = getResources().getStringArray(R.array.card_titles);
        String[] cardContents = getResources().getStringArray(R.array.card_contents);
        final int length = cardTitles.length;
        for(int i=0;i<length;i++){
            cardItemModel = new CardItemModel(cardTitles[i],cardContents[i]);
            cardItems.add(cardItemModel);
        }
    }
}
