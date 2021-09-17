package com.pay.payo.viewmodels;

import android.app.Application;
import android.util.Log;

import com.pay.payo.application.PayOApplication;
import com.pay.payo.model.NetworksResponseModel;
import com.pay.payo.network.APIService;
import com.pay.payo.repository.Repository;
import com.pay.payo.utils.AppExecutors;
import com.pay.payo.utils.Resource;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;


public class NetworksViewModel extends AndroidViewModel {

    private static final String TAG = NetworksViewModel.class.getSimpleName();

    public static final String QUERY_EXHAUSTED = "No more results.";

    public enum ViewState {NETWORKS}

    private MutableLiveData<ViewState> viewState;
    private MediatorLiveData<Resource<NetworksResponseModel>> networkData = new MediatorLiveData<>();
    private Repository repository;

    private boolean cancelRequest;

    public NetworksViewModel(@NonNull Application application) {
        super(application);
        repository = ((PayOApplication) application).getApplicationComponent().getRepository();
        init();
    }

    private void init() {
        if (viewState == null) {
            viewState = new MutableLiveData<>();
            viewState.setValue(ViewState.NETWORKS);
        }
    }

    public LiveData<Resource<NetworksResponseModel>> getNetworkData() {
        return networkData;
    }


    public void getNetworkInfoFromNetwork(APIService apiService,
                                          AppExecutors executors) {
        cancelRequest = false;
        viewState.setValue(ViewState.NETWORKS);

        final LiveData<Resource<NetworksResponseModel>> repositorySource = repository
                .getNetworks(apiService, executors);
        networkData.addSource(repositorySource, listResource -> {
            if (!cancelRequest) {
                if (listResource != null) {
                    if (listResource.status == Resource.Status.SUCCESS) {
                        Log.d(TAG, "onChanged: " + listResource.data);

                        if (listResource.data != null) {
                            if (listResource.data.getNetworks().getApplicable().size() == 0) {
                                Log.d(TAG, "onChanged: query is exhausted...");
                                networkData.setValue(
                                        new Resource<>(
                                                Resource.Status.ERROR,
                                                listResource.data,
                                                QUERY_EXHAUSTED
                                        )
                                );
                            }
                        }
                        networkData.removeSource(repositorySource);
                    } else if (listResource.status == Resource.Status.ERROR) {
                        networkData.removeSource(repositorySource);
                    }
                    networkData.setValue(listResource);
                } else {
                    networkData.removeSource(repositorySource);
                }
            } else {
                networkData.removeSource(repositorySource);
            }
        });
    }
}
