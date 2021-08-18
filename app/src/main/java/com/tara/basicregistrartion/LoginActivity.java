package com.tara.basicregistrartion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btn_login;
    private EditText et_name,et_age;
    SqliteHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqliteHelper = new SqliteHelper(this);
        btn_login = (Button)findViewById(R.id.btn_login);
        et_name = (EditText)findViewById(R.id.et_name);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nme = et_name.getText().toString();
               Cursor cursor =  sqliteHelper.getName();
               if(cursor.getCount() == 0){
                   Toast.makeText(LoginActivity.this, "data is null", Toast.LENGTH_SHORT).show();
               }else{
                   if(cursor.moveToNext()){
                       String name = cursor.getString(0);
                       if(name.equals(nme) || name == nme){
                           Intent intent = new Intent(LoginActivity.this,ApiCallingActivity.class);
                           startActivity(intent);
                           Toast.makeText(LoginActivity.this, "Login SuccessFully", Toast.LENGTH_SHORT).show();

                       }else{
                           Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                       }
                   }
               }

            }
        });
    }
}