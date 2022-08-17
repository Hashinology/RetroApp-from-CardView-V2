package com.hashinology.myretroappfromcardviewv2;

import com.hashinology.myretroappfromcardviewv2.ui.RetrofitInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private RetrofitInterface retrofitInterface;

    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitInterface.Base_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }


    public static synchronized RetrofitClient getInstanceSetup(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }
    public RetrofitInterface myAPI(){
        return retrofitInterface;
    }
}
