package com.campus.retrofitexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class loginresponsegson {
    @SerializedName("response")
    String response;

    @SerializedName("data")
    List<data> object;

    public List<data> getObject() {
        return object;
    }

    public void setObject(List<data> object) {
        this.object = object;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
