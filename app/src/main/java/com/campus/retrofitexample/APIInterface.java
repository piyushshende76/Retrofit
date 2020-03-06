package com.campus.retrofitexample;

import com.campus.retrofitexample.loginresponsegson;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {

    @FormUrlEncoded
    @POST("api/User/login")
    Call<loginresponsegson> LOGINRESPONSEGSON_CALL(@Field("username") String username,@Field("password") String password);

}


