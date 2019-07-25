package com.example.myapplication.SpinnerSeekbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.example.myapplication.R;
import com.example.myapplication.mNavigation.Main2Activity;
import com.example.myapplication.mNavigation.NewNavigation4Activity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpinnerActivity extends NewNavigation4Activity {
    Button  btn_Next;

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(linearnavagation)) {
            drawerLayout.closeDrawer(linearnavagation);
        } else {
            Intent i = new Intent(SpinnerActivity.this, Main2Activity.class);
            startActivity(i);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_spinner);
        getLayoutInflater().inflate(R.layout.activity_spinner, frameLayout);
        // Get reference of widgets from XML layout
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button btn = (Button) findViewById(R.id.btn);
         btn_Next = (Button) findViewById(R.id.btn_Next);

        // Initializing a String Array
        String[] plants = new String[]{
                "Laceflower",
                "Sugar maple",
                "Mountain mahogany",
                "Butterfly weed"
        };

        final List<String> plantsList = new ArrayList<>(Arrays.asList(plants));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,plantsList);

       // spinnerArrayAdapter.setDropDownViewResource(R.layout.activity_spinner);
        spinner.setAdapter(spinnerArrayAdapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Select the Spinner element at index position 2
                // It will select third element/item from Spinner
                spinner.setSelection(2);
            }
        });
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpinnerActivity.this, Main2Activity.class);
                startActivity(intent);
                //   finish();
            }
        });
    }
}
