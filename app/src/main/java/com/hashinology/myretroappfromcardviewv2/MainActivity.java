package com.hashinology.myretroappfromcardviewv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hashinology.myretroappfromcardviewv2.adapter.RetroAdapterRecyclerView;
import com.hashinology.myretroappfromcardviewv2.model.ModelData;
import com.hashinology.myretroappfromcardviewv2.ui.InterfaceAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements InterfaceAdapter {
    RecyclerView recyclerView;
    RetroAdapterRecyclerView retroAdapterRecyclerView;
    List<ModelData> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvList);

        getOnlineData();
    }

    private void getOnlineData() {
        Call<List<ModelData>> myList = RetrofitClient.getInstanceSetup().myAPI().getInterfaceMethod();
        myList.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
                if (response.isSuccessful()){
                    mData = response.body();
                    retroAdapterRecyclerView = new RetroAdapterRecyclerView(mData, getApplicationContext());
                    recyclerView.setAdapter(retroAdapterRecyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                    retroAdapterRecyclerView.getAdapterInterface(MainActivity.this);
                } else{
                    Toast.makeText(MainActivity.this, "Error from Online List, not you", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void myInterfaceClcicked(View view, int position) {
        Toast.makeText(this, "Current Position is: "+ position, Toast.LENGTH_SHORT).show();
    }
}