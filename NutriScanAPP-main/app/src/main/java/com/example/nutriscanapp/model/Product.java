package com.example.nutriscanapp.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Product {

    @SerializedName("product_name")
    private String productName;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("nutriments")
    private Nutriments nutriments;

    @SerializedName("allergens_tags")
    private List<String> allergens;

    public String getProductName() {
        return productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Nutriments getNutriments() {
        return nutriments;
    }

    public List<String> getAllergens() {
        return allergens;
    }
}
