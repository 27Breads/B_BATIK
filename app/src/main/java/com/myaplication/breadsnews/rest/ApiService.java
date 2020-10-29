package com.myaplication.breadsnews.rest;

import com.myaplication.breadsnews.model.BatikModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("batik/all")  //end point
    Call<BatikModel> getData();
}
