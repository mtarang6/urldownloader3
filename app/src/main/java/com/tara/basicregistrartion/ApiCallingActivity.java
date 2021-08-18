package com.tara.basicregistrartion;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ApiCallingActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    AdapterResponse adapterResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicalling);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);

       RetroInterface service = ApiClient.getClient().create(RetroInterface.class);
       Call<List<Response>> listCall = service.getResponseList();
       listCall.enqueue(new Callback<List<Response>>() {
           @Override
           public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
               if(response.isSuccessful()){
                   List<Response> responseList = response.body();
                   LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ApiCallingActivity.this);
                   adapterResponse = new AdapterResponse(ApiCallingActivity.this,responseList);
                   recyclerview.setLayoutManager(linearLayoutManager);
                   recyclerview.setAdapter(adapterResponse);
                   adapterResponse.notifyDataSetChanged();
                   Toast.makeText(ApiCallingActivity.this, "success", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<List<Response>> call, Throwable t) {
               Toast.makeText(ApiCallingActivity.this, "failed", Toast.LENGTH_SHORT).show();
           }
       });

    }
}
