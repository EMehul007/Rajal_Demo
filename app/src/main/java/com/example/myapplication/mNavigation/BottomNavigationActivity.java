package com.example.myapplication.mNavigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.example.myapplication.Fragment.AboutUs_Fragment;
import com.example.myapplication.Fragment.Home_Fragment;
import com.example.myapplication.Fragment.Messages_Fragment;
import com.example.myapplication.Fragment.UserAccount_Fragment;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_songs:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_albums:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_artists:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        loadFragment(new Home_Fragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_songs:
                fragment = new Home_Fragment();
                break;

            case R.id.navigation_albums:
                fragment = new UserAccount_Fragment();
                break;

            case R.id.navigation_artists:
                fragment = new Messages_Fragment();
                break;

            case R.id.navigation_profile:
                fragment = new AboutUs_Fragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

