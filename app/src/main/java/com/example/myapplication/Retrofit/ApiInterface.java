package com.example.myapplication.Retrofit;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);


    @FormUrlEncoded
    @POST("WebService1.asmx/RegistrationInsert1")
    //@POST("WebService1.asmx?op=RegistrationInsert1")
    Call<BeanRegistration>register(
            @Field("FirstName")  String fristname,
            @Field("LastName")  String lastname,
            @Field("EmailId")  String emailid,
            @Field("Gender")  String gender,
            @Field("DOB")  String dob,
            @Field("DesignationId") String designationId,
            @Field("DepartmentId") String departmentId,
            @Field("Hobby") String hobby,
            @Field("Password") String password
    );
    @POST("WebService1.asmx/DepartmentSelectAll")
        //@POST("WebSer0vice1.asmx?op=RegistrationInsert1")
      Call<BeanDepartment>deparment();

    @FormUrlEncoded
    @POST("WebService1.asmx/DesignationSelectByDepaId")
        //@POST("WebService1.asmx?op=RegistrationInsert1")
    Call<BeanDesignation>designation(
            @Field("DepartmentId")  String departmentId
            );

    @FormUrlEncoded
    @POST("WebService1.asmx/Login")
        //@POST("WebService1.asmx?op=RegistrationInsert1")
    Call<BeanLogin>login(
            @Field("EmailId")  String emailid,
            @Field("Password") String password
    );
    @FormUrlEncoded
    @POST("WebService1.asmx/RegistrationSelectById")
        //@POST("WebService1.asmx?op=RegistrationInsert1")
    Call<BeanMyRegistrationDetailArray>id(
            @Field("Id")  String Id
    );

//    @FormUrlEncoded
//    @POST("WebService1.asmx/RegistrationSelectById")
//        //@POST("WebService1.asmx?op=RegistrationInsert1")
//    Call<BeanMyRegistrationDetailArray>dataset(
//            @Field("Id")  String Id,
//            @Field("Firstname")  String Firstname,
//            @Field("Lastname")  String Lastname,
//            @Field("EmailId")  String EmailId,
//            @Field("Gender")  String Gender,
//            @Field("DateOfBirth") String DateOfBirth,
//            @Field("DesignationId") String DesignationId,
//            @Field("Department_Id") String Department_Id,
//            @Field("Hobby") String Hobby,
//            @Field("File_Path") String File_Path
//    );
}
