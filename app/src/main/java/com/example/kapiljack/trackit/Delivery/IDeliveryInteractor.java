package com.example.kapiljack.trackit.Delivery;

import android.content.Context;

public interface IDeliveryInteractor {

    public interface onListDataLoadingFinished{
        void onError();
        void onSuccess(InfoListDeliveries infoListDeliveries);
        void onSetAdapter(PostAdapterLoader postAdapterLoader);
    }

    void loadListData(InfoListDeliveries infoListDeliveries,onListDataLoadingFinished listener);
    void setAdapter(InfoListDeliveries infoListDeliveries,onListDataLoadingFinished listener);
}
