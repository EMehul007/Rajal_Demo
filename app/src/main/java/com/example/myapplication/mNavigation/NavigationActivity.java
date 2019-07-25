package com.example.myapplication.mNavigation;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.myapplication.Adapter.DrawerListAdapter;
import com.example.myapplication.R;
import java.util.ArrayList;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class NavigationActivity extends AppCompatActivity {

    Toolbar toolbar;
    public static int[] drawer_icons = {R.drawable.ic_call_black_24dp,
            R.drawable.ic_favorite_border_black_24dp,
            R.drawable.ic_search_black_24dp};


    TextView tv_selected_navigation;

    ArrayList<String> navigation_items;
    private DrawerListAdapter drawerListAdapter;
    private ListView lv_drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        init();

        SetDrawer();
    }

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        tv_selected_navigation = (TextView) findViewById(R.id.tv_selected_navigation);

        navigation_items = new ArrayList<>();

//adding menu items for naviations
        navigation_items.add("Call");
        navigation_items.add("Favorite");
        navigation_items.add("Search");

        lv_drawer = (ListView) findViewById(R.id.lv_drawer);

    }
    private void SetDrawer() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
       drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawerListAdapter = new DrawerListAdapter(NavigationActivity.this, navigation_items, drawer_icons);
        lv_drawer.setAdapter(drawerListAdapter);

        lv_drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(navigation_items.get(position).equalsIgnoreCase("Call")){

                    tv_selected_navigation.setText("Call Fregment");
                    drawer.closeDrawers();

                }else if(navigation_items.get(position).equalsIgnoreCase("Favorite")){

                    tv_selected_navigation.setText("Favorite Fregment");
                    drawer.closeDrawers();
                }else if(navigation_items.get(position).equalsIgnoreCase("Search")){

                    tv_selected_navigation.setText("Search Fregment");
                    drawer.closeDrawers();
                }

            }
        });

    }
}