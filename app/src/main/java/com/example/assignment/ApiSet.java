package com.example.assignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiSet {


   @GET("pincode/{pincode}")
    Call<List<Response>> getDataByPinCode(@Path("pincode") String pincode);


   @GET("current.json")
   Call<Example> getLocation(@Query("key") String key,
                              @Query("q") String cityName);




}
