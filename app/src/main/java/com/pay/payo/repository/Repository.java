package com.pay.payo.repository;


import android.content.Context;
import android.util.Log;


import com.pay.payo.application.PayOApplication;
import com.pay.payo.model.NetworksResponseModel;
import com.pay.payo.network.APIService;
import com.pay.payo.network.ApiResponse;
import com.pay.payo.persistence.NetworksInfoDAO;
import com.pay.payo.utils.AppExecutors;
import com.pay.payo.utils.NetworkBoundResource;
import com.pay.payo.utils.Resource;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

public class Repository {

    private static final String TAG = Repository.class.getSimpleName();

    private static Repository instance;
    private NetworksInfoDAO networksInfoDAO;

    public static Repository getInstance(Context context) {
        if (instance == null) {
            instance = new Repository(context);
        }
        return instance;
    }

    private Repository(Context context) {
        networksInfoDAO = ((PayOApplication) context.getApplicationContext())
                .getApplicationComponent().getNetworkInfoDb().getNetworksDAO();
    }

    public LiveData<Resource<NetworksResponseModel>> getNetworks(APIService apiService,
                                                                 AppExecutors executors) {
        return new NetworkBoundResource<NetworksResponseModel, NetworksResponseModel>(executors) {

            @Override
            protected void saveCallResult(@NonNull NetworksResponseModel item) {
                if (item != null && item.getNetworks().getApplicable() != null &&
                        item.getNetworks().getApplicable().size() > 0) {
                    Log.d(TAG, "saveCallResult: " + item.getNetworks().getApplicable().size());
                    networksInfoDAO.insertCameraItem(item);
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable NetworksResponseModel data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<NetworksResponseModel> loadFromDb() {
                return networksInfoDAO.getPaymentInfo();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<NetworksResponseModel>> createCall() {
                LiveData<ApiResponse<NetworksResponseModel>> responseLiveData =
                        apiService.getPaymentMethods();
                return responseLiveData;
            }
        }.getAsLiveData();
    }
}