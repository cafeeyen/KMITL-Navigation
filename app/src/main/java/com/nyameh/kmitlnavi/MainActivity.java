package com.nyameh.kmitlnavi;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view) ;
        mFragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null){
            currentFragment = new TabFragment();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.containerView, currentFragment).commit();
        }

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(MenuItem menuItem) {
                 mDrawerLayout.closeDrawers();
                 mFragmentTransaction = mFragmentManager.beginTransaction();
                 if (menuItem.getItemId() == R.id.nav_item_event_news){currentFragment = new TabFragment();}
                 if (menuItem.getItemId() == R.id.nav_item_map){currentFragment = new MapFragment();}
                 if (menuItem.getItemId() == R.id.nav_item_scan){currentFragment = new ScanFragment();}
                 mFragmentTransaction.add(R.id.containerView, currentFragment).addToBackStack(null).commit();
                 return false;
            }
        });

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.header_toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
            R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }
    @Override
    public void onBackPressed() {
        int count = mFragmentManager.getBackStackEntryCount();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        if(!(currentFragment instanceof MapFragment)){
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) { //this line error when && with kangbon
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
            else{
                if (count == 0) {
                    //some dialog to confirm before getting out
                    super.onBackPressed();
                } else {
                    for (int round = count; round >= 1; --round){ //for loop is work, I don't know why while didn't work
                        mFragmentManager.popBackStack();
                    }
                }
            }
        }
        else {
            if (count == 0) {
                //some dialog to confirm before getting out
                super.onBackPressed();
            } else {
                for (int round = count; round >= 1; --round) { //for loop is work, I don't know why while didn't work
                    mFragmentManager.popBackStack();
                }
            }
        }
    }
}