package com.example.finalevaluacion.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public static Retrofit instance;

    public static ShowsInterface service;


    public RetrofitHelper(){

    }

    public static Retrofit getInstance(){

        if (instance == null){
            Retrofit  retrofit = new Retrofit.Builder()
           //https://run.mocky.io/v3/1023089f-2e34-4f11-84fa-776f26586518
            // https://run.mocky.io/v3/fc3579f7-1e23-4e90-ac6d-0130c5a3af21
            // https://run.mocky.io/v3/e173072d-6535-4e6a-917a-2c0eb69063ae
                    //https://run.mocky.io/v3/da205802-26c4-4707-b6ac-0ed5b7d3fc00
            // https://run.mocky.io/v3/a38d4b0d-d067-47b9-aeb9-2a507bec1411
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getLogginBuilder().build())
                    .build();
            instance = retrofit;

        }  return instance;
    }

    public static OkHttpClient.Builder getLogginBuilder(){
        HttpLoggingInterceptor interceptor  = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder;

    }

    public static ShowsInterface getService(){

        if(service == null){
            service = getInstance().create(ShowsInterface.class);
        }
        return service;
    }

}
