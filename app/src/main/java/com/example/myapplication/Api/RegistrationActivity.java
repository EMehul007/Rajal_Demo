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
import com.example.myapplication.Retrofit.BeanRegistration;
import com.google.gson.Gson;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    @BindView(R.id.Fristname)
    EditText Fristname;
    @BindView(R.id.LastName)
    EditText LastName;
    @BindView(R.id.EmailId)
    EditText EmailId;
    @BindView(R.id.Gender)
    EditText Gender;
    @BindView(R.id.DOB)
    EditText DOB;
    @BindView(R.id.DesignationId)
    EditText DesignationId;
    @BindView(R.id.DepartmentId)
    EditText DepartmentId;
    @BindView(R.id.Hobby)
    EditText Hobby;
    @BindView(R.id.Password)
    EditText Password;
    @BindView(R.id.Invoke)
    Button Invoke;

    String fristname, lastName, emailId, gender, dOB, designationId, departmentId, hobby, password;
    ApiInterface apiService;
    @BindView(R.id.btn_Next)
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        apiService = ApiClient.getClient().create(ApiInterface.class);

    }

    @OnClick(R.id.Invoke)
    public void onViewClicked1() {

        CallApi();
    }

    private void CallApi() {

        fristname = Fristname.getText().toString().trim();
        lastName = LastName.getText().toString().trim();
        emailId = EmailId.getText().toString().trim();
        gender = Gender.getText().toString().trim();
        dOB = DOB.getText().toString().trim();
        designationId = DesignationId.getText().toString().trim();
        departmentId = DepartmentId.getText().toString().trim();
        hobby = Hobby.getText().toString().trim();
        password = Password.getText().toString().trim();


        final ProgressDialog pd = ProgressDialog.show(RegistrationActivity.this, "", "Loading...");

        Call<BeanRegistration> call = apiService.register(fristname, lastName, emailId, gender,
                dOB, designationId, departmentId, hobby, password);
        call.enqueue(new Callback<BeanRegistration>() {
            @Override
            public void onResponse(Call<BeanRegistration> call, Response<BeanRegistration> response) {

                pd.dismiss();

                Log.e("Responce", new Gson().toJson(response.body()));

                if (response.body() != null) {
                    if (response.body().getRegistrationInsert().get(0).getStatus().equals("Success")) {
                        Toast.makeText(RegistrationActivity.this, "" + response.body().getRegistrationInsert(), Toast.LENGTH_SHORT).show();
                        Log.e("Responce", "" + response.body().getRegistrationInsert());

                        Fristname.setText("");
                        LastName.setText("");
                        EmailId.setText("");
                        Gender.setText("");
                        DOB.setText("");
                        DesignationId.setText("");
                        DepartmentId.setText("");
                        Hobby.setText("");
                        Password.setText("");


                    } else {
                        Toast.makeText(RegistrationActivity.this, "" + response.body().getRegistrationInsert(), Toast.LENGTH_SHORT).show();

                    }
                } else
                    Toast.makeText(RegistrationActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BeanRegistration> call, Throwable t) {
                Log.e("Responce", "" + t.getMessage());
                pd.dismiss();
                Toast.makeText(RegistrationActivity.this, "Failure...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_Next)
    public void onViewClicked() {

        Intent intent = new Intent(RegistrationActivity.this, DepartmentActivity.class);
        startActivity(intent);
        //   finish();
    }
}
