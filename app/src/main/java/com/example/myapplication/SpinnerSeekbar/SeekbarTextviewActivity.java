package com.example.myapplication.SpinnerSeekbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.mNavigation.Main2Activity;
import com.example.myapplication.mNavigation.NewNavigation4Activity;

public class SeekbarTextviewActivity extends NewNavigation4Activity {

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(linearnavagation)) {
            drawerLayout.closeDrawer(linearnavagation);
        } else {
            Intent i = new Intent(SeekbarTextviewActivity.this, Main2Activity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_textview);
        final TextView t1=(TextView) findViewById(R.id.textView1);
        final SeekBar sk=(SeekBar) findViewById(R.id.seekBar1);

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p=0;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                if(p<30)
                {
                    p=30;
                    sk.setProgress(p);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                p=progress;
                t1.setTextSize(p);
            }
        });
    }
}



