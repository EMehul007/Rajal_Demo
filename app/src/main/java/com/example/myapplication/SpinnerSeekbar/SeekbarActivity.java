package com.example.myapplication.SpinnerSeekbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.mNavigation.Main2Activity;
import com.example.myapplication.mNavigation.Main3Activity;
import com.example.myapplication.mNavigation.NewNavigation4Activity;

public class SeekbarActivity extends NewNavigation4Activity {
    @Override

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(linearnavagation)) {
            drawerLayout.closeDrawer(linearnavagation);
        } else {
            Intent i = new Intent(SeekbarActivity.this, Main2Activity.class);
            startActivity(i);
            finish();
        }
    }

    private SeekBar sBar;
    private TextView tView;
    private Button btn_Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_seekbar, frameLayout);
//        setContentView(R.layout.activity_seekbar);

        sBar = (SeekBar) findViewById(R.id.seekBar1);
        tView = (TextView) findViewById(R.id.textview1);
        btn_Next = (Button) findViewById(R.id.btn_Next);

        tView.setText(sBar.getProgress() + "/" + sBar.getMax());
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pval = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tView.setText(pval + "/" + seekBar.getMax());
            }
        });
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeekbarActivity.this, Main3Activity.class);
                startActivity(intent);
                //   finish();
            }
        });
    }
    }

