package com.example.hometaskapi2.mvp.allDeal;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hometaskapi2.R;
import com.example.hometaskapi2.adapter.DealAdapter;
import com.example.hometaskapi2.adapter.ReachEndListener;
import com.example.hometaskapi2.rest.entities.Deal;

import java.util.List;

public class DealFragment extends Fragment implements DealContract.View {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private DealAdapter dealAdapter;

    private DealContract.Presenter dealPresenter;

    private int currentPage = 1;

    public DealFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deal, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setUp RecyclerView
        recyclerView = getActivity().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dealAdapter = new DealAdapter();
        recyclerView.setAdapter(dealAdapter);

        //init progress bar
        progressBar = getActivity().findViewById(R.id.progressBar);



        dealPresenter = new DealPresenter(this);

        dealPresenter.load(currentPage);

        dealAdapter.setReachEndListener(new ReachEndListener() {
            @Override
            public void onReachEnd() {
                currentPage++;
                dealPresenter.load(currentPage);
            }
        });
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void addNewDeals(List<Deal> newDeal) {
        dealAdapter.addDealList(newDeal);
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(getContext(), "Error " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
