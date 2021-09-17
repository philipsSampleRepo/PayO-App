package com.pay.payo.network;


import com.pay.payo.model.NetworksResponseModel;

import androidx.lifecycle.LiveData;
import retrofit2.http.GET;


public interface APIService {
    @GET("lists/listresult.json")
    LiveData<ApiResponse<NetworksResponseModel>> getPaymentMethods();
}
