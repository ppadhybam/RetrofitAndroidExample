package com.priyabrat.retrofitexample;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.priyabrat.retrofitexample.http.APIService;
import com.priyabrat.retrofitexample.models.City;
import com.priyabrat.retrofitexample.models.CityList;
import com.priyabrat.retrofitexample.utils.Config;
import com.priyabrat.retrofitexample.utils.CustomStringConverter;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Retrofit retrofit;
    private APIService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setTitle("Android Retrofit Example");
        retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(new CustomStringConverter())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public void consumeString(View view) {

        Call<String> callBack = apiService.getRawData();
        callBack.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String txt = response.body();
                Gson gson = new Gson();
                Type listType = new TypeToken<CityList>(){}.getType();
                CityList cities = (CityList) gson.fromJson(txt, listType);
                Log.d(TAG,"Data loading successful "+txt);
                startCityActivity(cities.getCities());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG,"Data loading Failed "+t.getMessage());
            }
        });
    }

    public void consumeObject(View view) {
        Call<CityList> cityCall = apiService.getAllCities();
        cityCall.enqueue(new Callback<CityList>() {
            @Override
            public void onResponse(Call<CityList> call, Response<CityList> response) {
                if(response==null)
                    Log.d(TAG,"Data loaded is null ");
                else{
                    ArrayList<City> citiesList = response.body().getCities();
                    startCityActivity(citiesList);
                }
            }

            @Override
            public void onFailure(Call<CityList> call, Throwable t) {
                Log.d(TAG,"Data loading Failed "+t.getMessage());
            }
        });
    }


    public void startCityActivity(ArrayList<City> cityList)
    {
        if(cityList!=null)
        {
            Intent intent = new Intent(this,CityListActivity.class);
            intent.putExtra("data",cityList);
            startActivity(intent);
        }
        else
        {
            Snackbar.make(getWindow().getDecorView().getRootView(),"Something went wrong",Snackbar.LENGTH_LONG).show();
        }
    }
}
