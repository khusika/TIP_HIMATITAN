package com.khusika.himatitan;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.khusika.himatitan.fragments.FragmentEvent;
import com.khusika.himatitan.fragments.FragmentHome;
import com.khusika.himatitan.fragments.FragmentNews;
import com.khusika.himatitan.fragments.FragmentProfile;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final static String FRAGMENT_HOME_TAG = "fragment_home";
    private final static String FRAGMENT_PROFILE_TAG = "fragment_profile";
    private final static String FRAGMENT_EVENT_TAG = "fragment_event";
    private final static String FRAGMENT_NEWS_TAG = "fragment_news";
    private final static int HOME = 0;
    private final static int PROFILE = 1;
    private final static int EVENT = 2;
    private final static int NEWS = 4;

    private final static String SELECTED_TAG = "selected_index";

    private static int selectedIndex;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        if(savedInstanceState!=null){
            navigationView.getMenu().getItem(savedInstanceState.getInt(SELECTED_TAG)).setChecked(true);
            return;
        }

        selectedIndex = HOME;

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                new FragmentHome(),FRAGMENT_HOME_TAG).commit();

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_TAG, selectedIndex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    public void setupNavigationDrawer(Toolbar toolbar){
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.Home:
                if(!menuItem.isChecked()){
                    selectedIndex = HOME;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FragmentHome(), FRAGMENT_HOME_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.ProfilePengurus:
                if(!menuItem.isChecked()){
                    selectedIndex = PROFILE;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FragmentProfile(), FRAGMENT_PROFILE_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.Event:
                if(!menuItem.isChecked()){
                    selectedIndex = EVENT;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FragmentEvent(), FRAGMENT_EVENT_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.News:
                if(!menuItem.isChecked()){
                    selectedIndex = NEWS;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FragmentNews(), FRAGMENT_NEWS_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.About:
                if(!menuItem.isChecked()){
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.Contact:
                if(!menuItem.isChecked()){
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.Team:
                if(!menuItem.isChecked()){
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }
        return false;
    }
}
