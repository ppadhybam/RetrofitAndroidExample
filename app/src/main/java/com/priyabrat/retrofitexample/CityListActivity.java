package com.priyabrat.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.priyabrat.retrofitexample.adapters.CityAdapter;
import com.priyabrat.retrofitexample.models.City;

import java.util.ArrayList;

public class CityListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CityAdapter adapter;
    private ArrayList<City> cityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        //getActionBar().setTitle("Cities");
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        cityList = (ArrayList<City>) getIntent().getSerializableExtra("data");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CityAdapter(this,cityList);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
