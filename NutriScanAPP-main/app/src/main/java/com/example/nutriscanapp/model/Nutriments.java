package com.example.nutriscanapp.model;

import com.google.gson.annotations.SerializedName;

public class Nutriments {

    @SerializedName("energy-kcal")
    private float energyKcal;

    @SerializedName("carbohydrates")
    private float carbohydrates;

    @SerializedName("fat")
    private float fat;

    @SerializedName("saturated-fat")
    private float saturatedFat;

    @SerializedName("proteins")
    private float proteins;

    @SerializedName("sodium")
    private float sodium;

    @SerializedName("fiber")
    private float fiber;

    @SerializedName("vitamin-a")
    private float vitaminA;

    @SerializedName("vitamin-b1")
    private float vitaminB1;

    public float getEnergyKcal() {
        return energyKcal;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public float getFat() {
        return fat;
    }

    public float getSaturatedFat() {
        return saturatedFat;
    }

    public float getProteins() {
        return proteins;
    }

    public float getSodium() {
        return sodium;
    }

    public float getFiber() {
        return fiber;
    }

    public float getVitaminA() {
        return vitaminA;
    }

    public float getVitaminB1() {
        return vitaminB1;
    }
}
