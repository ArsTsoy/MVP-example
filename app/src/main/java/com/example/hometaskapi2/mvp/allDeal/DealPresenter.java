package com.example.hometaskapi2.mvp.allDeal;

import com.example.hometaskapi2.rest.entities.MainDeal;

public class DealPresenter implements DealContract.Presenter {

    private DealContract.Model model;
    private DealContract.View view;

    public DealPresenter(DealContract.View view) {
        this.model = new DealModel();
        this.view = view;
    }

    @Override
    public void load(int page) {
        model.getDealList(this, page);
    }

    @Override
    public void loadingFinished(MainDeal mainDeal) {
        view.hideLoading();
        view.addNewDeals(mainDeal.getResultList());
    }

    @Override
    public void loadingFailed(Throwable throwable) {
        view.hideLoading();
        view.showError(throwable);
    }
}
