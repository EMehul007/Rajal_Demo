package com.example.myapplication.Api;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.myapplication.Adapter.CustomAdapter;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.ApiClient;
import com.example.myapplication.Retrofit.ApiInterface;
import com.example.myapplication.Retrofit.RetroPhoto;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApicallActivity extends AppCompatActivity {
   private CustomAdapter adapter;
   private RecyclerView recyclerView;
   ApiInterface apiService;
//    private static final String TAG = MainActivity.class.getSimpleName();
//
//    // TODO - insert your themoviedb.org API KEY here
//    private final static String API_KEY = "";


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_apicall);

//        if (API_KEY.isEmpty()) {
//            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
//            return;
//        }

//        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
      apiService = ApiClient.getClient().create(ApiInterface.class);
       CallApi();
   }
   private void CallApi() {

       final ProgressDialog pd = ProgressDialog.show(ApicallActivity.this, "", "Loading...");

       Call<List<RetroPhoto>> call = apiService.getAllPhotos();
       call.enqueue(new Callback<List<RetroPhoto>>() {
           @Override
           public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {

               pd.dismiss();
               generateDataList(response.body());
               //  Toast.mkeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
               Log.e("Responce", "" + response.body());
           }

           @Override
           public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
               Log.e("Rajal", "" + t.getMessage());
               pd.dismiss();
               Toast.makeText(ApicallActivity.this, "Failure...", Toast.LENGTH_SHORT).show();
           }
       });

//    Call<MovieResponse> call1 = apiService.getTopRatedMovies(API_KEY);
//        call1.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse>call, Response<MovieResponse> response) {
//                List<Movie> movies = response.body().getResults();
//                Log.d(TAG, "Number of movies received: " + movies.size());
//            }
//
//            @Override
//            public void onFailure(Call<MovieResponse>call, Throwable t) {
//                // Log error here since request failed
//                Log.e(TAG, t.toString());
//            }
//        });
   }
   /*Method to generate List of data using RecyclerView with custom adapter*/
   private void generateDataList(List<RetroPhoto> photoList) {
       recyclerView = findViewById(R.id.customRecyclerView);
       adapter = new CustomAdapter(this, photoList);
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ApicallActivity.this);
       recyclerView.setLayoutManager(layoutManager);
       recyclerView.setAdapter(adapter);
   }
}
