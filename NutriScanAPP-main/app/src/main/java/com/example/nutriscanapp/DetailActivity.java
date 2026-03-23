package com.example.nutriscanapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nutriscanapp.model.Product;
import com.example.nutriscanapp.model.ProductResponse;
import com.example.nutriscanapp.network.OpenFoodFactsApi;
import com.example.nutriscanapp.helper.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    TextView tvNama, tvKalori, tvEnergi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNama = findViewById(R.id.tvNama);
        tvKalori = findViewById(R.id.tvKalori);
        tvEnergi = findViewById(R.id.tvEnergi);

        String barcode = getIntent().getStringExtra("barcode");
        getProductDetails(barcode);
    }

    private void getProductDetails(String barcode) {
        OpenFoodFactsApi api = RetrofitClient.getClient().create(OpenFoodFactsApi.class);
        Call<ProductResponse> call = api.getProduct(barcode);

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Product product = response.body().getProduct();
                    String name = product.getProductName();
                    float energy = product.getNutriments().getEnergyKcal();

                    // Update TextViews
                    tvNama.setText("Nama Produk: " + name);
                    tvEnergi.setText("Energi: " + energy + " kcal");
                    tvKalori.setText("Kalori: " + energy + " kalori"); // Jika ingin ditampilkan dua kali
                } else {
                    Toast.makeText(DetailActivity.this, "Produk tidak ditemukan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Toast.makeText(DetailActivity.this, "Gagal koneksi ke server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
