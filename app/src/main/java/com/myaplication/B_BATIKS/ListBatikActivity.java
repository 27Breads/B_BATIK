package com.myaplication.B_BATIKS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.myaplication.B_BATIKS.model.BatikModel;
import com.myaplication.B_BATIKS.model.HasilItem;
import com.myaplication.B_BATIKS.rest.ApiConfig;
import com.myaplication.B_BATIKS.rest.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBatikActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<HasilItem> hasilItems;
    private BatikAdapter batikAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_batik);

        initView();
        getData();
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData()
                .enqueue(new Callback<BatikModel>() {
                    @Override
                    public void onResponse(Call<BatikModel> call, Response<BatikModel> response) {
                        if(response.isSuccessful()){
                            hasilItems = (ArrayList<HasilItem>) response.body().getHasil();
                            batikAdapter = new BatikAdapter(hasilItems, getApplicationContext());
                            batikAdapter.notifyDataSetChanged();
                            rv.setAdapter(batikAdapter);
                            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        }
                    }

                    @Override
                    public void onFailure(Call<BatikModel> call, Throwable t) {
                        Toast.makeText(ListBatikActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }
}
