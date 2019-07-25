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
import com.example.myapplication.Retrofit.BeanLogin;
import com.google.gson.Gson;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.EmailId)
    EditText EmailId;
    @BindView(R.id.Password)
    EditText Password;
    @BindView(R.id.Invoke)
    Button Invoke;
    @BindView(R.id.btn_Next)
    Button btnNext;
    String emailId, password;
    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        ButterKnife.bind(this);

        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @OnClick(R.id.Invoke)
    public void onViewClicked() {

        CallApi();
    }

    private void CallApi() {

        emailId = EmailId.getText().toString().trim();
        password = Password.getText().toString().trim();


        final ProgressDialog pd = ProgressDialog.show(LoginActivity.this, "", "Loading...");

        Call<BeanLogin> call = apiService.login(emailId, password);
        call.enqueue(new Callback<BeanLogin>() {
            @Override
            public void onResponse(Call<BeanLogin> call, Response<BeanLogin> response) {

                pd.dismiss();

              Log.e("Responce", new Gson().toJson(response.body()));
//               Log.e("Responce", response.body().getUserLogin());

                if (response.body() != null) {
                    if (response.body().getUserLogin().get(0).getStatus().equals("Success")) {
                        Toast.makeText(LoginActivity.this, "" + response.body().getUserLogin(), Toast.LENGTH_SHORT).show();
                        Log.e("Responce", "" + response.body().getUserLogin());


                        EmailId.setText("");
                        Password.setText("");

                    } else {
                        Toast.makeText(LoginActivity.this, "" + response.body().getUserLogin(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, NewActivity.class);
                        startActivity(intent);
                    }
                } else
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BeanLogin> call, Throwable t) {
                Log.e("Responce", "" + t.getMessage());
                pd.dismiss();
                Toast.makeText(LoginActivity.this, "Failure...", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @OnClick(R.id.btn_Next)
    public void onViewClicked1() {

        Intent intent = new Intent(LoginActivity.this, NewActivity.class);
        startActivity(intent);
//          finish();
    }
}