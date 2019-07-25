package com.example.myapplication.Api;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.ApiClient;
import com.example.myapplication.Retrofit.ApiInterface;
import com.example.myapplication.Retrofit.BeanMyRegistrationDetailArray;
import com.google.gson.Gson;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewActivity extends AppCompatActivity {

    @BindView(R.id.Id)
    EditText Id;
    ApiInterface apiService;
    String id;
    @BindView(R.id.Invoke)
    Button Invoke;
    @BindView(R.id.btn_Next)
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        ButterKnife.bind(this);


        apiService = ApiClient.getClient().create(ApiInterface.class);

    }

   private void CallApi1() {
        final ProgressDialog pd = ProgressDialog.show(NewActivity.this, "", "Loading...");

        id = Id.getText().toString().trim();

        Id.setText("");

        Call<BeanMyRegistrationDetailArray> call1 = apiService.id(id);
        call1.enqueue(new Callback<BeanMyRegistrationDetailArray>() {
            @Override
            public void onResponse(Call<BeanMyRegistrationDetailArray> call, Response<BeanMyRegistrationDetailArray> response) {

                pd.dismiss();

                Log.e("Responce", new Gson().toJson(response.body()));

                Intent i =new Intent(NewActivity.this,DatasetActivity.class);
                i.putExtra("ID",id);
                startActivity(i);

//                response.body().getMyRegistrationDetailArray().get(int).getId();



                Log.e("Responce", "" + response.body());
            }

            @Override
            public void onFailure(Call<BeanMyRegistrationDetailArray> call, Throwable t) {
                Log.e("Rajal", "" + t.getMessage());
                pd.dismiss();
                Toast.makeText(NewActivity.this, "Failure...", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @OnClick(R.id.Invoke)
    public void onInvokeClicked() {

        CallApi1();
    }

    @OnClick(R.id.btn_Next)
    public void onBtnNextClicked() {

        Intent intent = new Intent(NewActivity.this, DatasetActivity.class);
        startActivity(intent);
    }
}
