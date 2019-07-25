package com.example.myapplication.SpinnerSeekbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.myapplication.R;
import com.example.myapplication.mNavigation.Main2Activity;
import com.example.myapplication.mNavigation.NewNavigation4Activity;

public class SpinnerdemoActivity extends NewNavigation4Activity {


    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(linearnavagation)) {
            drawerLayout.closeDrawer(linearnavagation);
        } else {
            Intent i = new Intent(SpinnerdemoActivity.this, Main2Activity.class);
            startActivity(i);
            finish();
        }
    }

    Spinner spinnerDropDown;
    Button  btn_Next;

    String[] cities = {
            "Mumbai",
            "Delhi",
            "Bangalore",
            "Hyderabad",
            "Ahmedabad",
            "Chennai",
            "Kolkata",
            "Pune",
            "Jabalpur"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinnerdemo);

        // Get reference of SpinnerView from layout/main_activity.xml
        spinnerDropDown =(Spinner)findViewById(R.id.spinner1);
        btn_Next =(Button)findViewById(R.id.btn_Next);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.
                R.layout.simple_spinner_dropdown_item ,cities);

        spinnerDropDown.setAdapter(adapter);

        spinnerDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid=spinnerDropDown.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You have selected City : " + cities[sid],
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpinnerdemoActivity.this, SpinnerActivity.class);
                startActivity(intent);
                //   finish();
            }
        });

    }
}
