package com.example.myapplication.mNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.example.myapplication.R;
import com.example.myapplication.SpinnerSeekbar.SeekbarActivity;
import com.example.myapplication.SpinnerSeekbar.SpinnerActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MNavigationActivity extends AppCompatActivity {

    public static String actually;
    public static DrawerLayout drawerLayout;
    public static FrameLayout frameLayout;
    public static LinearLayout linearnavagation, ll_genesettings, ll_settings;

    public static void getDrawer(String key) {
        actually = key;
        if (drawerLayout.isDrawerOpen(linearnavagation)) {
            drawerLayout.closeDrawer(linearnavagation);
        } else {
            drawerLayout.openDrawer(linearnavagation);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnavigation);

        ll_genesettings = findViewById(R.id.ll_genesettings);
        ll_settings = findViewById(R.id.ll_settings);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        linearnavagation = (LinearLayout) findViewById(R.id.list_navagation);

        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        ActionBarDrawerToggle toggle1 = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle1);
        toggle1.syncState();

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        SetClick();

    }
    private void SetClick() {

      ll_genesettings.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intent = new Intent(MNavigationActivity.this, SpinnerActivity.class);
              startActivity(intent);

          }
      });
        ll_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MNavigationActivity.this, SeekbarActivity.class);
                startActivity(intent);

            }
        });

    }
}
