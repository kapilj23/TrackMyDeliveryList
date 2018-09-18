package com.example.kapiljack.trackit.Location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kapiljack.trackit.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {
    private Context context;
    private Intent intent;
    public CustomInfoWindowGoogleMap(Context ctx,Intent intent) {
        context = ctx;
        this.intent = intent;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.custom_info_window, null);
        Intent intent = ((Activity) context).getIntent();

        TextView desc = view.findViewById(R.id.description);
        TextView add = view.findViewById(R.id.address);
        ImageView image = view.findViewById(R.id.rec_image);
        desc.setText(marker.getTitle());
        add.setText(marker.getSnippet());
        Bundle extras = intent.getExtras();
        byte[] b = extras.getByteArray("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
        image.setImageBitmap(bmp);
        return view;
    }
}
