package com.tara.basicregistrartion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface RetroInterface {
    @GET("comments")
    Call<List<Response>> getResponseList();
}
