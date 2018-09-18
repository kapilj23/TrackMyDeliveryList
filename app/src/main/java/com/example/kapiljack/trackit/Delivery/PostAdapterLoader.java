package com.example.kapiljack.trackit.Delivery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kapiljack.trackit.Location.MapsActivity;
import com.example.kapiljack.trackit.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class PostAdapterLoader extends RecyclerView.Adapter<PostAdapterLoader.ViewHolder>{

    ArrayList<String> description = null;
    ArrayList<String> address = null;
    ArrayList<String> imageURL = null;
    ArrayList<Double> latitude = null;
    ArrayList<Double> longitude = null;
    public Context context;
    public PostAdapterLoader(ArrayList<String> description, ArrayList<String> address,ArrayList<String> imageURL,ArrayList<Double> latitude,ArrayList<Double> longitude,Context context){

        this.description = description;
        this.address = address;
        this.imageURL = imageURL;
        this.latitude = latitude;
        this.longitude = longitude;
        this.context = context;


    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MapsActivity.class);
                intent.putExtra("Description",description.get(holder.getAdapterPosition()));
                intent.putExtra("Address",address.get(holder.getAdapterPosition()));
                intent.putExtra("latitude",latitude.get(holder.getAdapterPosition()));
                intent.putExtra("longitude",longitude.get(holder.getAdapterPosition()));
                Drawable drawable = holder.receiverProfile.getDrawable();
                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();
                intent.putExtra("image",b);

                context.startActivity(intent);
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.description.setText(description.get(position));
        holder.address.setText(address.get(position));
        Glide.with(context).load(imageURL.get(position)).into(holder.receiverProfile);
    }

    @Override
    public int getItemCount() {
        return description.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView receiverProfile;
        TextView description;
        TextView address;



        public ViewHolder(View itemView) {
            super(itemView);
            receiverProfile = itemView.findViewById(R.id.receiverImage);
            description = itemView.findViewById(R.id.description);
            address = itemView.findViewById(R.id.address);


        }


    }
}



