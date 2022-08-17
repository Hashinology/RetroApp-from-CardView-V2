package com.hashinology.myretroappfromcardviewv2.ui;

import com.hashinology.myretroappfromcardviewv2.model.ModelData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    String Base_URL = "https://jsonplaceholder.typicode.com/posts/";
    @GET(Base_URL)
    Call<List<ModelData>> getInterfaceMethod();
}
