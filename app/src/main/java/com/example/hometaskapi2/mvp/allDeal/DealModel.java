package com.example.hometaskapi2.mvp.allDeal;

import com.example.hometaskapi2.rest.NetworkService;
import com.example.hometaskapi2.rest.entities.MainDeal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealModel implements DealContract.Model {


    @Override
    public void getDealList(DealContract.Presenter presenter, int page) {

        Call<MainDeal> call = NetworkService.getInstance().getChocoApi().getDealList(1, 1, page);
        call.enqueue(new Callback<MainDeal>() {
            @Override
            public void onResponse(Call<MainDeal> call, Response<MainDeal> response) {
                presenter.loadingFinished(response.body());
            }

            @Override
            public void onFailure(Call<MainDeal> call, Throwable t) {
                presenter.loadingFailed(t);
            }
        });

    }
}
