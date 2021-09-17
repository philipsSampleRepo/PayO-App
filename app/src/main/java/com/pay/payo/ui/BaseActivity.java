package com.pay.payo.ui;


import com.pay.payo.R;
import com.pay.payo.application.PayOApplication;
import com.pay.payo.application.di.ApplicationComponent;
import com.pay.payo.ui.di.PaymentMethodsActivityComponent;
import com.pay.payo.ui.di.PaymentMethodsActivityModule;
import com.pay.payo.utils.AppExecutors;
import com.pay.payo.viewmodels.NetworksViewModel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    NetworksViewModel notesViewModel;
    AppExecutors appExecutors;
    ApplicationComponent component;
    PaymentMethodsActivityComponent activityComponent;

    void initViewModel() {
        component = ((PayOApplication) getApplication()).getApplicationComponent();
        activityComponent = component.getActivityComponentFactory()
                .create(new PaymentMethodsActivityModule(this));
        notesViewModel = activityComponent.getNetworksViewModel();
        appExecutors = component.getAppExecutors();
    }

    void initUI() {
    }

    void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));
    }

    void initThreads() {
        appExecutors = new AppExecutors();
    }
}
