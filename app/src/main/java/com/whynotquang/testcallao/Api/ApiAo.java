package com.whynotquang.testcallao.Api;

import com.whynotquang.testcallao.Model.Ao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiAo {

    @GET("getall")
    Call<List<Ao>> getAo();

}
