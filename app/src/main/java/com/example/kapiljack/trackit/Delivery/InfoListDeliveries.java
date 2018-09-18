package com.example.kapiljack.trackit.Delivery;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class InfoListDeliveries {
   private ArrayList<String>  Description   = new ArrayList<>();
   private ArrayList<String>  Address       = new ArrayList<>();
   private ArrayList<Double>  latitude      = new ArrayList<>();
   private ArrayList<Double>  longitude     = new ArrayList<>();
   public  ArrayList<String>  imageURl      = new ArrayList<>();

   public void setImageURL(String url){
       this.imageURl.add(url);
   }

   public ArrayList<String> getImageURl()
   {
       return imageURl;
   }
    public ArrayList<Double> getLatitude() {
        return latitude;
    }

    public ArrayList<Double> getLongitude() {
        return longitude;
    }

    public ArrayList<String> getDescription() {
        return Description;
    }

    public void setLongitude(Double longitude) {
        this.longitude.add(longitude);
    }

    public void setLatitude(Double latitude) {
        this.latitude.add(latitude);
    }

    public ArrayList<String> getAddress() {
        return Address;
    }


    public void setDescription(String description) {
        this.Description.add(description);
    }

    public void setAddress(String address) {
        this.Address.add(address);
    }


}
