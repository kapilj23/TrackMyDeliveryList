package com.example.kapiljack.trackit.Delivery;

import android.content.Context;

/**
 * DeliveryPresenter is a presenter that will communicate with ListDelivery(VIEW) and DeliveryInteractor(MODEL)
 */

public class DeliveryPresenter implements IDeliveryPresenter,IDeliveryInteractor.onListDataLoadingFinished {

    IListDeliveryView iListDeliveryView;
    IDeliveryInteractor iDeliveryInteractor;
    private Context context;
    public DeliveryPresenter(IListDeliveryView iListDeliveryView, Context ctx){
        this.context = ctx;
        this.iListDeliveryView = iListDeliveryView;
        this.iDeliveryInteractor = new DeliveryInteractor(ctx);

    }

    @Override
    public void getData(InfoListDeliveries infoListDeliveries) {
       iDeliveryInteractor.loadListData(infoListDeliveries,this);
    }

    @Override
    public void onError() {
        iListDeliveryView.onError();
    }

    @Override
    public void onSuccess(InfoListDeliveries infoListDeliveries) {
        iDeliveryInteractor.setAdapter(infoListDeliveries,this);


    }

    @Override
    public void onSetAdapter(PostAdapterLoader postAdapterLoader) {
        iListDeliveryView.hideProgress();
        iListDeliveryView.updateListData(postAdapterLoader);
    }
}
