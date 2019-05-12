package com.example.hometaskapi2.mvp.allDeal;

import com.example.hometaskapi2.rest.entities.Deal;
import com.example.hometaskapi2.rest.entities.MainDeal;

import java.util.List;

public interface DealContract {
    interface View{
        void showLoading();
        void hideLoading();

        void addNewDeals(List<Deal> newDeal);
        void showError(Throwable throwable);

    }

    interface Presenter{
        void load(int page);
        void loadingFinished(MainDeal mainDeal);
        void loadingFailed(Throwable throwable);

    }

    interface Model{
        void getDealList(DealContract.Presenter presenter, int page);
    }
}
