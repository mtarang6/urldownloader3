package com.tara.basicregistrartion;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResgistrationActivity extends AppCompatActivity {
    private EditText et_name,et_age;
    private Button btn_signin;
    SqliteHelper sqliteHelper;
    private SQLiteDatabase database;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        sqliteHelper = new SqliteHelper(this);
        et_age = (EditText)findViewById(R.id.et_age);
        et_name = (EditText)findViewById(R.id.et_name);
        btn_signin = (Button) findViewById(R.id.btn_signin);


        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = et_age.getText().toString();
                int aa = Integer.parseInt(age);
                String name = et_name.getText().toString();

                if(!name.isEmpty() && !age.isEmpty()){
                   // try {
                        boolean inserted = sqliteHelper.insertData(name,age);
                        if (inserted == true) {
                            Toast.makeText(ResgistrationActivity.this, "data pushed", Toast.LENGTH_SHORT).show();
                            et_name.setText("");
                            et_age.setText("");
                        } else {
                            Toast.makeText(ResgistrationActivity.this, "not pushed", Toast.LENGTH_SHORT).show();
                        }

                }else{
                    Toast.makeText(ResgistrationActivity.this, "data should not null", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
