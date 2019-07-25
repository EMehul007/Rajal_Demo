package com.example.myapplication.SpinnerSeekbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.mNavigation.Main2Activity;
import com.example.myapplication.mNavigation.NewNavigation4Activity;

public class SeekbardemoActivity extends NewNavigation4Activity {

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(linearnavagation)) {
            drawerLayout.closeDrawer(linearnavagation);
        } else {
            Intent i = new Intent(SeekbardemoActivity.this, Main2Activity.class);
            startActivity(i);
            finish();
        }
    }

    Button submitButton,btn_Next;
    SeekBar customSeekBar;
    int pro = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbardemo);

        // initiate  views
        customSeekBar =(SeekBar)findViewById(R.id.customSeekBar);
        final TextView t1=(TextView) findViewById(R.id.textView1);
        customSeekBar.setMax(50);
        btn_Next =(Button)findViewById(R.id.btn_Next);
        // perform seek bar change listener event used for getting the progress value
        customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue=progress;
                t1.setTextSize(progressChangedValue);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(SeekbardemoActivity.this, "Seek bar progress is :" + progressChangedValue,
//                        Toast.LENGTH_SHORT).show();
            }

        });
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeekbardemoActivity.this, SeekbarTextviewActivity.class);
                startActivity(intent);
                //   finish();
            }
        });

    }
    }

