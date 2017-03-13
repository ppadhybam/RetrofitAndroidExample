package com.priyabrat.retrofitexample.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.priyabrat.retrofitexample.R;
import com.priyabrat.retrofitexample.models.City;

import java.util.ArrayList;

/**
 * Created by PriyabratP on 13-03-2017.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<City> cityArrayList;

    public CityAdapter(Activity activity, ArrayList<City> cityArrayList) {
        this.activity = activity;
        this.cityArrayList = cityArrayList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.single_row,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        City city = cityArrayList.get(position);
        holder.textView.setText(city.getName());
    }

    @Override
    public int getItemCount() {
        return cityArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
