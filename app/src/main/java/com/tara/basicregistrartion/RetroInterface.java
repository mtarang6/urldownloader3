package com.tara.basicregistrartion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetroInterface {
    @GET("comments")
    Call<List<Response>> getResponseList();

    @GET("comments")
    Call<List<Response>> getResponseListWithId(@Query("postId") Integer postId);
}
