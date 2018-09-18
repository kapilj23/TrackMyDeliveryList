package com.example.kapiljack.trackit.Delivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kapiljack.trackit.R;

/**
 * This is the Activity class which will list all items that have been delivered
 */
public class ListDelivery extends AppCompatActivity implements IListDeliveryView{

    RecyclerView recyclerView = null;
    ProgressBar progressBar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_deliveries);
        getSupportActionBar().setTitle("Deliveries");
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recycler_view);

        DeliveryPresenter deliveryPresenter = new DeliveryPresenter(this,ListDelivery.this);
        InfoListDeliveries infoListDeliveries = new InfoListDeliveries();
        deliveryPresenter.getData(infoListDeliveries);
    }



    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Application Server Down. Please Reload The Application", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateListData(PostAdapterLoader postAdapterLoader) {
        recyclerView.setAdapter(postAdapterLoader);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}
