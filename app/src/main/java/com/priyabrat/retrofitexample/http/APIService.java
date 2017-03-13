package com.priyabrat.retrofitexample.http;

import com.priyabrat.retrofitexample.models.City;
import com.priyabrat.retrofitexample.models.CityList;
import com.priyabrat.retrofitexample.utils.Config;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by PriyabratP on 13-03-2017.
 */

public interface APIService {

    @GET(Config.API_NEWS)
    Call<String> getRawData();

    @GET(Config.API_NEWS)
    Call<CityList> getAllCities();
}
