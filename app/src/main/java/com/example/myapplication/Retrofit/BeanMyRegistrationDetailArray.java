package com.example.myapplication.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BeanMyRegistrationDetailArray {

    @SerializedName("MyRegistrationDetailArray")
    @Expose
    private List<MyRegistrationDetailArray> myRegistrationDetailArray = null;

    public List<MyRegistrationDetailArray> getMyRegistrationDetailArray() {
        return myRegistrationDetailArray;
    }

    public void setMyRegistrationDetailArray(List<MyRegistrationDetailArray> myRegistrationDetailArray) {
        this.myRegistrationDetailArray = myRegistrationDetailArray;
    }
}
