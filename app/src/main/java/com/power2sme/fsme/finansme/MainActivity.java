package com.power2sme.fsme.finansme;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout mCoordinator;
    //Need this to set the title of the app bar
    private FloatingActionButton mFab;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ViewPager mPager;
    //private YourPagerAdapter mAdapter;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mCoordinator = (CoordinatorLayout) findViewById(R.id.root_coordinator);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //mAdapter = new YourPagerAdapter(getSupportFragmentManager());
        //mPager = (ViewPager) findViewById(R.id.view_pager);
        //mPager.setAdapter(mAdapter);
        //Notice how the Tab Layout links with the Pager Adapter
        //mTabLayout.setTabsFromPagerAdapter(mAdapter);

        //Notice how The Tab Layout adn View Pager object are linked
        //mTabLayout.setupWithViewPager(mPager);
        //mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}
