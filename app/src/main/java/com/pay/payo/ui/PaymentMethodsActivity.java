package com.pay.payo.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.pay.payo.R;
import com.pay.payo.adapter.PaymentMethodsAdapter;
import com.pay.payo.databinding.ActivityPaymentMethodsBinding;
import com.pay.payo.model.ApplicableItem;
import com.pay.payo.model.NetworksResponseModel;
import com.pay.payo.network.NetworkClient;
import com.pay.payo.utils.Resource;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PaymentMethodsActivity extends BaseActivity {
    private final static String TAG = PaymentMethodsActivity.class.getSimpleName();
    private ActivityPaymentMethodsBinding paymentMethodsBinding;
    private RecyclerView recyclerView;
    private PaymentMethodsAdapter paymentMethodsAdapter;
    private List<ApplicableItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    @Override
    void initUI() {
        super.initUI();
        paymentMethodsBinding = ActivityPaymentMethodsBinding.inflate(getLayoutInflater());
        View view = paymentMethodsBinding.getRoot();

        setContentView(view);
        setTitle();
        initActionBar();

        initViewModel();
        initThreads();
        loadInfo();

        setPaymentMethodsItemListener();
        loadPaymentMethodsListWithData();
    }

    void setTitle() {
        setTitle(R.string.title);
    }

    private void loadInfo() {
        paymentMethodsAdapter = activityComponent.getPaymentMethodsAdapter();
        recyclerView = paymentMethodsBinding.payMethodList;
        notesViewModel.getNetworkInfoFromNetwork(NetworkClient.getSharedInstance()
                .provideAPIService(), appExecutors);
        notesViewModel.getNetworkData().observe(this,
                networksResponseModelResource -> {
                    if (networksResponseModelResource != null) {
                        Log.d(TAG, "onChanged: status: " + networksResponseModelResource.status);

                        if (networksResponseModelResource.data != null) {
                            switch (networksResponseModelResource.status) {
                                case LOADING: {
                                    Log.d(TAG, "onChanged: LOADING");
                                    paymentMethodsBinding.progress.setVisibility(View.VISIBLE);
                                    break;
                                }
                                case ERROR: {
                                    Log.e(TAG, "onChanged: cannot refresh the cache. ERROR");
                                    Log.e(TAG, "onChanged: ERROR message: "
                                            + networksResponseModelResource.message);
                                    setListUI(networksResponseModelResource);
                                    showSnackBar(paymentMethodsBinding.getRoot(),
                                            networksResponseModelResource.message);
                                    break;
                                }
                                case SUCCESS: {
                                    Log.d(TAG, "onChanged: cache has been refreshed.");
                                    Log.d(TAG, "onChanged: status: SUCCESS, #networks: "
                                            + networksResponseModelResource.data.getNetworks()
                                            .getApplicable().size());
                                    setListUI(networksResponseModelResource);
                                    break;
                                }
                            }
                        }
                    }
                });
    }

    private void setListUI(Resource<NetworksResponseModel> networksResponseModelResource) {
        paymentMethodsBinding.progress.setVisibility(View.INVISIBLE);
        itemList = networksResponseModelResource.data.getNetworks()
                .getApplicable();
        paymentMethodsAdapter.setPaymentMethods(itemList);
    }

    private void setPaymentMethodsItemListener() {
        paymentMethodsAdapter.setOnItemClickedListener(
                applicableItem -> {
                    if (applicableItem != null) {
                        Log.d(TAG, "Payment method clicked... " + applicableItem.getCode());
                        Toast.makeText(PaymentMethodsActivity.this,
                                applicableItem.getCode() + " selected...", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void loadPaymentMethodsListWithData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(paymentMethodsAdapter);
    }

    private void showSnackBar(View view, String message) {
        Snackbar.make(view, message,
                Snackbar.LENGTH_LONG).show();
    }
}