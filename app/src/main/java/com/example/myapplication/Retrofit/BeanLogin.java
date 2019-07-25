package com.example.myapplication.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BeanLogin {

        @SerializedName("User_Login")
        @Expose
        private List<UserLogin> userLogin = null;

        public List<UserLogin> getUserLogin() {
            return userLogin;
        }

        public void setUserLogin(List<UserLogin> userLogin) {
            this.userLogin = userLogin;
        }

    }

