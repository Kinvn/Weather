package com.kinvn.weather.weather.module.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.kinvn.weather.weather.R;
import com.kinvn.weather.weather.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.iv)
    ImageView imageView;
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolBar);
        initDrawer();
        mCollapsingToolbarLayout.setTitle("29℃");
        imageView.setImageResource(R.mipmap.test);
    }

    private void initDrawer() {
        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                    (this, mDrawerLayout, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            mDrawerLayout.addDrawerListener(toggle);
            toggle.syncState();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}