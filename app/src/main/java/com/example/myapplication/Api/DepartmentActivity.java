package com.example.myapplication.Api;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.ApiClient;
import com.example.myapplication.Retrofit.ApiInterface;
import com.example.myapplication.Retrofit.BeanDepartment;
import com.example.myapplication.Retrofit.BeanDesignation;
import com.google.gson.Gson;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentActivity extends AppCompatActivity {

    @BindView(R.id.btn_Next)
    Button btnNext;
    Spinner spinner1,spinner2;
    ApiInterface apiService;
//    @BindView(R.id.DepartmentId)
//    EditText DepartmentId;
    ArrayList<String> department;
    ArrayList<String> departmentid;

    ArrayList<String> department1;
    ArrayList<String>  departmentid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        ButterKnife.bind(this);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        CallApi1();


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CallApi2(departmentid.get(position));

                Log.e("ID",departmentid.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void CallApi2(String s) {

        final ProgressDialog pd = ProgressDialog.show(DepartmentActivity.this, "", "Loading...");

        Call<BeanDesignation> call2 = apiService.designation(s);
        call2.enqueue(new Callback<BeanDesignation>() {
            @Override
            public void onResponse(Call<BeanDesignation> call, Response<BeanDesignation> response) {

                pd.dismiss();

                Log.e("Responce", new Gson().toJson(response.body()));

                department1 = new ArrayList<>();
                departmentid1 = new ArrayList<>();

                //ArrayList<String> department1 = new ArrayList<>();
//                ArrayList<String>  departmentid1 = new ArrayList<>();
                for (int i = 0; i < response.body().getDesignationArray().size(); i++) {
                    department1.add(response.body().getDesignationArray().get(i).getTitle());
                    departmentid1.add(response.body().getDesignationArray().get(i).getId());
                }

                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, department1);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner2.setAdapter(adapter);

                //  Toast.mkeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Responce", "" + response.body());
            }
            @Override
            public void onFailure(Call<BeanDesignation> call, Throwable t) {
                Log.e("Rajal", "" + t.getMessage());
                pd.dismiss();
                Toast.makeText(DepartmentActivity.this, "Failure...", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @OnClick(R.id.btn_Next)
    public void onViewClicked() {

        Intent intent = new Intent(DepartmentActivity.this, LoginActivity.class);
        startActivity(intent);
        //   finish();
    }
    private void CallApi1() {

        final ProgressDialog pd = ProgressDialog.show(DepartmentActivity.this, "", "Loading...");

        Call<BeanDepartment> call1 = apiService.deparment();
        call1.enqueue(new Callback<BeanDepartment>() {
            @Override
            public void onResponse(Call<BeanDepartment> call, Response<BeanDepartment> response) {

                pd.dismiss();

                Log.e("Responce", new Gson().toJson(response.body()));

//                response.body().getDepartmentArray().get(0).getTitle();
                 department = new ArrayList<>();
                 departmentid = new ArrayList<>();

                for (int i = 0; i < response.body().getDepartmentArray().size(); i++) {
                    department.add(response.body().getDepartmentArray().get(i).getTitle());
                    departmentid.add(response.body().getDepartmentArray().get(i).getId());
                }
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, department);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner1.setAdapter(adapter);

                //  Toast.mkeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Responce", "" + response.body());
            }

            @Override
            public void onFailure(Call<BeanDepartment> call, Throwable t) {
                Log.e("Rajal", "" + t.getMessage());
                pd.dismiss();
                Toast.makeText(DepartmentActivity.this, "Failure...", Toast.LENGTH_SHORT).show();
            }
        });

//         // EditText

//        departmentId = DepartmentId.getText().toString().trim();
//
//        DepartmentId.setText("");
//
//        Call<BeanDesignation> call1 = apiService.designation(departmentId);
//        call1.enqueue(new Callback<BeanDesignation>() {
//            @Override
//            public void onResponse(Call<BeanDesignation> call, Response<BeanDesignation> response) {
//
//                pd.dismiss();
//
//                Log.e("Responce", new Gson().toJson(response.body()));
//
//                response.body().getDepartmentArray().get(0).getTitle();
//
//
//                //  Toast.mkeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("Responce", "" + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<BeanDesignation> call, Throwable t) {
//                Log.e("Rajal", "" + t.getMessage());
//                pd.dismiss();
//                Toast.makeText(DepartmentActivity.this, "Failure...", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}