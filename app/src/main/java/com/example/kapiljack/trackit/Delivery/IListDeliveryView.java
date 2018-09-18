package com.example.kapiljack.trackit.Delivery;

public interface IListDeliveryView {

    void hideProgress();
    void onError();
    void updateListData(PostAdapterLoader postAdapterLoader);
}
