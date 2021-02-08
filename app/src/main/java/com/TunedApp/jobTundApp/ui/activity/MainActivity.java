package com.TunedApp.jobTundApp.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.TunedApp.jobTundApp.R;
import com.TunedApp.jobTundApp.ui.fragmrnt.FragmentDetails;
import com.TunedApp.jobTundApp.ui.fragmrnt.FragmentJobs;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    Activity activity;
    FragmentTransaction fragmentTransaction;
    Fragment currentFragment;
    @BindView(R.id.txv_title)
    TextView txvTitle;
    @BindView(R.id.nav_icon)
    ImageView navIcon;

    DrawerLayout drawer;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        drawer= (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);


        openFragment(new FragmentJobs(), "FragmentJobs");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void openFragment(Fragment fragment, String tag) {
        try {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (getSupportFragmentManager().findFragmentById(R.id.jobs_detail_containe)
                    != fragment) {
                fragmentTransaction.replace(R.id.jobs_detail_containe, fragment, tag);
                fragmentTransaction.addToBackStack(tag);
                fragmentTransaction.commit();
            }

        } catch (Exception e) {

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                openFragment(new FragmentDetails(), "FragmentDetails");

                break;
            case R.id.nav_jobs:

                break;
            case R.id.nav_fav:

                break;
            case R.id.nav_contact:

                break;


        }
        return false;
    }

    @SuppressLint("WrongConstant")
    @OnClick(R.id.nav_icon)
    public void onViewClicked() {

        if (!drawer.isDrawerOpen(Gravity.END))
            drawer.openDrawer(Gravity.END);
        else drawer.closeDrawer(Gravity.START);
    }
}