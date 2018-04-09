package com.kinvn.weather.weather.modules.main;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.kinvn.weather.weather.common.C;
import com.kinvn.weather.weather.R;
import com.kinvn.weather.weather.common.utils.ToastUtil;
import com.kinvn.weather.weather.base.BaseActivity;
import com.kinvn.weather.weather.model.HeWeather;
import com.kinvn.weather.weather.view.FoldLineView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {
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
    @BindView(R.id.fold_line_view)
    FoldLineView mFoldLineView;

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        initDrawer();
        imageView.setImageResource(R.mipmap.test);
        mPresenter.checkLocationPermission();
    }

    private void init() {
        setSupportActionBar(mToolBar);
        mPresenter = new MainPresenter(this, this);
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

    @Override
    public void updateGraphView(List<String> xList, List<Integer> yList) {
        mFoldLineView.setXList(xList);
        mFoldLineView.setYList(yList);
        mFoldLineView.invalidate();
    }

    @Override
    public void updateWeather(HeWeather weather) {
        mCollapsingToolbarLayout.setTitle(weather.getBasic().getLocation() + " " + weather.getHourly().get(0).getTmp() + "℃");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case C.MY_FINE_LOCATION_REQUEST_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mPresenter.getCurrentCity();
                } else {
                    ToastUtil.showShort(getString(R.string.get_location_request_denied));
                }
                break;
            default:
                break;
        }
    }
}