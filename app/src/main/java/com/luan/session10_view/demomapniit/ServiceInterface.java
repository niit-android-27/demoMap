package com.luan.session10_view.demomapniit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceInterface {
  @GET("map.json")
  Call<ArrayList<StateModel>> getStates();
}
