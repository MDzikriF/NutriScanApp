package com.example.nutriscanapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import com.example.nutriscanapp.model.ProductResponse;

public interface OpenFoodFactsApi {
    @GET("api/v0/product/{barcode}.json")
    Call<ProductResponse> getProduct(@Path("barcode") String barcode);
}

