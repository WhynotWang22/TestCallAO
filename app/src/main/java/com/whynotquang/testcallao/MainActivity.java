package com.whynotquang.testcallao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.whynotquang.testcallao.Adapter.AoAdapter;
import com.whynotquang.testcallao.Api.ApiAo;
import com.whynotquang.testcallao.Model.Ao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.2:3000/api/products/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiAo apiAo = retrofit.create(ApiAo.class);
        Call<List<Ao>> call  = apiAo.getAo();
        call.enqueue(new Callback<List<Ao>>() {
            @Override
            public void onResponse(Call<List<Ao>> call, Response<List<Ao>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Ao> aoList = response.body();
                Log.e("erroor",aoList.get(0).getImg().get(0));
                AoAdapter adapter = new AoAdapter(aoList,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Ao>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "loi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}