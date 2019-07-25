package com.example.myapplication.mNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.myapplication.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends NewNavigation4Activity {

    private Button btn_Next;
    @BindView(R.id.img_profile)
    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_main2, frameLayout);
//        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        btn_Next = (Button) findViewById(R.id.btn_Next);

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("OPEN____", "OPEN___");
                getDrawer("homenew");
            }
        });
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, BottomNavigationActivity.class);
                startActivity(intent);
                //   finish();
            }
        });
    }
}
