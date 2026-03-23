package com.example.nutriscanapp.model;

import com.google.gson.annotations.SerializedName;

public class ProductResponse {

    @SerializedName("status")
    private int status;

    @SerializedName("code")
    private String code;

    @SerializedName("product")
    private Product product;

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public Product getProduct() {
        return product;
    }
}
