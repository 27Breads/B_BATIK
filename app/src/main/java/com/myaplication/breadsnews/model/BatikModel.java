package com.myaplication.breadsnews.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BatikModel{

    @SerializedName("max_price")
    private Integer maxPrice;

    @SerializedName("min_price")
    private Integer minPrice;

    @SerializedName("total_halaman")
    private Integer totalHalaman;

    @SerializedName("hasil")
    private ArrayList<HasilItem> hasil;

    @SerializedName("total_element")
    private Integer totalElement;

    public void setMaxPrice(Integer maxPrice){
        this.maxPrice = maxPrice;
    }

    public Integer getMaxPrice(){
        return maxPrice;
    }

    public void setMinPrice(Integer minPrice){
        this.minPrice = minPrice;
    }

    public Integer getMinPrice(){
        return minPrice;
    }

    public void setTotalHalaman(Integer totalHalaman){
        this.totalHalaman = totalHalaman;
    }

    public Integer getTotalHalaman(){
        return totalHalaman;
    }

    public void setHasil(ArrayList<HasilItem> hasil){
        this.hasil = hasil;
    }

    public ArrayList<HasilItem> getHasil(){
        return hasil;
    }

    public void setTotalElement(Integer totalElement){
        this.totalElement = totalElement;
    }

    public Integer getTotalElement(){
        return totalElement;
    }
}