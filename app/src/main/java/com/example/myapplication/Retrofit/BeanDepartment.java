package com.example.myapplication.Retrofit;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeanDepartment {

    @SerializedName("DepartmentArray")
    @Expose
    private List<DepartmentArray> departmentArray = null;

    public List<DepartmentArray> getDepartmentArray() {
        return departmentArray;
    }

    public void setDepartmentArray(List<DepartmentArray> departmentArray) {
        this.departmentArray = departmentArray;
    }

}