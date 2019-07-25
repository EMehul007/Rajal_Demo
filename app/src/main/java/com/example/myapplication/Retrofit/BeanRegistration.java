package com.example.myapplication.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BeanRegistration {

    @SerializedName("RegistrationInsert")
    @Expose
    private List<BeanRegistrationInsert> registrationInsert = null;

    public List<BeanRegistrationInsert> getRegistrationInsert() {
        return registrationInsert;
    }

    public void setRegistrationInsert(List<BeanRegistrationInsert> registrationInsert) {
        this.registrationInsert = registrationInsert;
    }
}

