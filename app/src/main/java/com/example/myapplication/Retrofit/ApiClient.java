package com.example.myapplication.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
   public static final String BASE_URL = "http://androidtest.excelsiortechnologies.net/";
//   public static final String BASE_URL = "http://androidtest.excelsiortechnologies.net/";
  // public static final String BASE_URL = "http://androidtest.excelsiortechnologies.net/";
//   public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
//    public static final String BASE_URL = "http://192.168.0.110:8080/api/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}