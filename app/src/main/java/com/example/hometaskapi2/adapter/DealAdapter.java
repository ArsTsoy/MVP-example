package com.example.hometaskapi2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.hometaskapi2.R;
import com.example.hometaskapi2.rest.entities.Deal;

import java.util.ArrayList;
import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<DealViewHolder> {

    private List<Deal> dealList;
    private View view;
    private ReachEndListener reachEndListener;

    public void setReachEndListener(ReachEndListener reachEndListener) {
        this.reachEndListener = reachEndListener;
    }

    public DealAdapter() {
        this.dealList = new ArrayList<>();
    }

    public void setDealList(List<Deal> dealList) {
        this.dealList.clear();
        this.dealList.addAll(dealList);
        notifyDataSetChanged();
    }

    public void addDealList(List<Deal> dealList) {
        this.dealList.addAll(dealList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item, viewGroup, false);
        return new DealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder dealViewHolder, int position) {
        dealViewHolder.bind(dealList.get(position));
        if(position > dealList.size() - 3){

            reachEndListener.onReachEnd();

        }
    }

    @Override
    public int getItemCount() {
        return dealList.size();
    }
}
