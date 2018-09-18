package com.example.kapiljack.trackit.Delivery;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This is a model class that will implement all logic
 */
public class DeliveryInteractor implements IDeliveryInteractor {
    private static final String Api_URL = "https://mock-api-mobile.dev.lalamove.com/deliveries/?offset=0&limit=20";
    private Context context;
    private RequestQueue mqueue;


    public DeliveryInteractor(Context context){
        this.context = context;
        this.mqueue = Volley.newRequestQueue(context);
    }


    @Override
    public void loadListData(final InfoListDeliveries infoListDeliveries, final onListDataLoadingFinished listener) {


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Api_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for(int i=0; i<response.length(); i++){
                        JSONObject info = response.getJSONObject(i);
                        infoListDeliveries.setDescription(info.getString("description"));
                        infoListDeliveries.setImageURL(info.getString("imageUrl"));
                        JSONObject location = info.getJSONObject("location");
                        infoListDeliveries.setLatitude(location.getDouble("lat"));
                        infoListDeliveries.setLongitude(location.getDouble("lng"));
                        infoListDeliveries.setAddress(location.getString("address"));

                    }

                 listener.onSuccess(infoListDeliveries);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError();
            }
        });
        //add json request to the queue
        mqueue.add(jsonArrayRequest);

    }

    @Override
    public void setAdapter(InfoListDeliveries infoListDeliveries,onListDataLoadingFinished listener) {
        PostAdapterLoader postAdapterLoader = new PostAdapterLoader(infoListDeliveries.getDescription(),infoListDeliveries.getAddress(),infoListDeliveries.getImageURl(),infoListDeliveries.getLatitude(),infoListDeliveries.getLongitude(),context);
        listener.onSetAdapter(postAdapterLoader);
    }
}
