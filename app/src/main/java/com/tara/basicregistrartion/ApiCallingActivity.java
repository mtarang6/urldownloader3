package com.tara.basicregistrartion;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ApiCallingActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    AdapterResponse adapterResponse;
    AppCompatEditText et_id;
    private Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicalling);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
        et_id = (AppCompatEditText)findViewById(R.id.et_id);
        btn_submit = (Button)findViewById(R.id.btn_submit);
        RetroInterface service = ApiClient.getClient().create(RetroInterface.class);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = et_id.getText().toString();
                int num = Integer.parseInt(number);
                Log.d("Tarang", "onClick: "+num);
                if(num != 0){
                    Call<List<Response>> listCalls = service.getResponseListWithId(num);
                    listCalls.enqueue(new Callback<List<Response>>() {
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
                }else{
                    Toast.makeText(ApiCallingActivity.this, "Enter Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
