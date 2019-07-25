package com.example.myapplication.mNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.example.myapplication.R;
import com.example.myapplication.SpinnerSeekbar.SeekbarActivity;
import com.example.myapplication.SpinnerSeekbar.SeekbarTextviewActivity;
import com.example.myapplication.SpinnerSeekbar.SeekbardemoActivity;
import com.example.myapplication.SpinnerSeekbar.SpinnerActivity;
import com.example.myapplication.SpinnerSeekbar.SpinnerdemoActivity;
import com.example.myapplication.SpinnerSeekbar.SpinnerspinnerActivity;

public class NewNavigation4Activity extends AppCompatActivity {
    private Button btn_Next;
    public static String actually;
    public static DrawerLayout drawerLayout;
    public static FrameLayout frameLayout;
    public static LinearLayout linearnavagation, Import, Gallery, SlidesShow, Tools, Share, Send;

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
        setContentView(R.layout.activity_new_navigation4);

        btn_Next = findViewById(R.id.btn_Next);
        Import = findViewById(R.id.Import);
        Gallery = findViewById(R.id.Gallery);
        SlidesShow = findViewById(R.id.SlidesShow);
        Share = findViewById(R.id.Share);
        Tools = findViewById(R.id.Tools);
        Send = findViewById(R.id.Send);
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

        Import.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NewNavigation4Activity.this, SpinnerActivity.class);
                startActivity(intent);

            }
        });
        Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NewNavigation4Activity.this, SeekbarActivity.class);
                startActivity(intent);

            }
        });
        SlidesShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NewNavigation4Activity.this, SeekbardemoActivity.class);
                startActivity(intent);

            }
        });
        Tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NewNavigation4Activity.this, SpinnerdemoActivity.class);
                startActivity(intent);

            }
        });
        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NewNavigation4Activity.this, SeekbarTextviewActivity.class);
                startActivity(intent);

            }
        });
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NewNavigation4Activity.this, SpinnerspinnerActivity.class);
                startActivity(intent);

            }
        });
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewNavigation4Activity.this, BottomActivity.class);
                startActivity(intent);
                //   finish();
            }
        });

    }
}
