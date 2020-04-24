package com.example.webservicenews.Interface;

import com.example.webservicenews.Model.WebSite;
import retrofit2.Call;
import retrofit2.http.GET;
public interface NewService {
    @GET("v1/sources?language=en")
    Call<WebSite> getSources();
}
