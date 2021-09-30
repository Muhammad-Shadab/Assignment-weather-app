package com.example.assignment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {

    private static final String url = "https://api.postalpincode.in/";
    private static Retrofit retrofit;
    private static ApiController apiController;

    public ApiController(){
        retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized ApiController getInstance()
    {
        if (apiController == null)
        {
            apiController = new ApiController();
        }
        return apiController;
    }

    ApiSet apiSet(){
        return retrofit.create(ApiSet.class);
    }

}
