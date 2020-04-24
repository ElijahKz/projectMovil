package com.example.webservicenews.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/*Cliente para obtener el json proveniente de la url */
public class RetrofitClient {
    private static Retrofit retrofit=null;
    public static Retrofit getClient(String baseUrl){
        if(retrofit== null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
