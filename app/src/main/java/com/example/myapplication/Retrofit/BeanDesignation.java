package com.example.myapplication.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BeanDesignation {

    @SerializedName("DesignationArray")
        @Expose
        private List<DesignationArray> designationArray = null;

        public List<DesignationArray> getDesignationArray() {
            return designationArray;
        }

        public void setDesignationArray(List<DesignationArray> designationArray) {
            this.designationArray = designationArray;
        }

    }

