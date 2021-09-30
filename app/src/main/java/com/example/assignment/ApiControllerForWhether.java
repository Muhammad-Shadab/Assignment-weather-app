package com.example.assignment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiControllerForWhether {

    private static final String base = "https://api.weatherapi.com/v1/";
    private static ApiControllerForWhether apiControllerForWhether;
    private static Retrofit retrofit;

    public ApiControllerForWhether()
    {
        retrofit = new Retrofit.Builder().baseUrl(base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiControllerForWhether getInstance()
    {
        if (apiControllerForWhether == null)
        {
            apiControllerForWhether = new ApiControllerForWhether();
        }
        return apiControllerForWhether;
    }

    ApiSet apiSetWhether()
    {
        return retrofit.create(ApiSet.class);
    }

}
