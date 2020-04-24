package com.example.webservicenews.Interface;

import com.example.webservicenews.Model.IconBetterIdea;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/* Here, we try to set up a service with retrofit ot get
* the icon of the url from google news by through */
public interface IconBetterIdeaService {
    @GET
    Call<IconBetterIdea> getIconUrl(@Url String url);
}






















