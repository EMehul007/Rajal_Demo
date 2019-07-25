package com.example.myapplication.Api;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.ApiClient;
import com.example.myapplication.Retrofit.ApiInterface;
import com.example.myapplication.Retrofit.BeanMyRegistrationDetailArray;
import com.google.gson.Gson;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatasetActivity extends AppCompatActivity {

    @BindView(R.id.txt_id)
    TextView txtId;
    @BindView(R.id.txt_fristname)
    TextView txtFristname;
    @BindView(R.id.txt_lastname)
    TextView txtLastname;
    @BindView(R.id.txt_emailid)
    TextView txtEmailid;
    @BindView(R.id.txt_gender)
    TextView txtGender;
    @BindView(R.id.txt_dob)
    TextView txtDob;
    @BindView(R.id.txt_designationid)
    TextView txtDesignationid;
    @BindView(R.id.txt_departmentid)
    TextView txtDepartmentid;
    @BindView(R.id.txt_hobby)
    TextView txtHobby;
    @BindView(R.id.txt_filepath)
    TextView txtFilepath;

    ApiInterface apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataset);

        ButterKnife.bind(this);

        String id=getIntent().getExtras().getString("ID");

        apiService = ApiClient.getClient().create(ApiInterface.class);
        CallApi(id);
    }
    private void CallApi(String id) {

//        Id = txtId.getText().toString().trim();
//        Firstname = txtFristname.getText().toString().trim();
//        Lastname = txtLastname.getText().toString().trim();
//        EmailId = txtEmailid.getText().toString().trim();
//        Gender = txtGender.getText().toString().trim();
//        DateOfBirth = txtDob.getText().toString().trim();
//        DesignationId = txtDesignationid.getText().toString().trim();
//        Department_Id = txtDepartmentid.getText().toString().trim();
//        Hobby = txtHobby.getText().toString().trim();
//        File_Path = txtFilepath.getText().toString().trim();


        final ProgressDialog pd = ProgressDialog.show(DatasetActivity.this, "", "Loading...");

        Call<BeanMyRegistrationDetailArray> call1 = apiService.id(id);
        call1.enqueue(new Callback<BeanMyRegistrationDetailArray>() {
            @Override
            public void onResponse(Call<BeanMyRegistrationDetailArray> call, Response<BeanMyRegistrationDetailArray> response) {

                pd.dismiss();

                Log.e("Responce", new Gson().toJson(response.body()));

                if (response.body() != null) {
                    if (response.body().getMyRegistrationDetailArray().get(0).equals("Success"))
                        Toast.makeText(DatasetActivity.this, "" + response.body().getMyRegistrationDetailArray(), Toast.LENGTH_SHORT).show();
                        Log.e("Responce", "" + response.body().getMyRegistrationDetailArray());

                        txtId.setText("id: " +response.body().getMyRegistrationDetailArray().get(0).getId());
                        txtFristname.setText("Fristname:" +response.body().getMyRegistrationDetailArray().get(0).getFirstName());
                        txtLastname.setText("Lastname:" +response.body().getMyRegistrationDetailArray().get(0).getLastName());
                        txtEmailid.setText("EmailId:" +response.body().getMyRegistrationDetailArray().get(0).getEmailId());
                        txtGender.setText("Gender:" +response.body().getMyRegistrationDetailArray().get(0).getGender());
                        txtDob.setText("DateOfBirth:" +response.body().getMyRegistrationDetailArray().get(0).getDateOfBirth());
                        txtDesignationid.setText("DesignationId:" +response.body().getMyRegistrationDetailArray().get(0).getDesignationId());
                        txtDepartmentid.setText("Department_Id:" +response.body().getMyRegistrationDetailArray().get(0).getDepartmentId());
                        txtHobby.setText("Hobby:" +response.body().getMyRegistrationDetailArray().get(0).getHobby());
                        txtFilepath.setText("File_Path:" +response.body().getMyRegistrationDetailArray().get(0).getFilePath());

                } else
                    Toast.makeText(DatasetActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<BeanMyRegistrationDetailArray> call, Throwable t) {
                Log.e("Responce", "" + t.getMessage());
                pd.dismiss();
                Toast.makeText(DatasetActivity.this, "Failure...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
