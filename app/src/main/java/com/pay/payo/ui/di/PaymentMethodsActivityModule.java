package com.pay.payo.ui.di;

import com.pay.payo.adapter.PaymentMethodsAdapter;
import com.pay.payo.di.PerActivityScope;
import com.pay.payo.viewmodels.NetworksViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module
public class PaymentMethodsActivityModule {

    private AppCompatActivity context;

    public PaymentMethodsActivityModule(AppCompatActivity context) {
        this.context = context;
    }

    @Provides
    public AppCompatActivity providesLifeCycleOwner() {
        return context;
    }

    @PerActivityScope
    @Provides
    public NetworksViewModel providesViewModel() {
        return ViewModelProviders.of(context).get(NetworksViewModel.class);
    }

    @PerActivityScope
    @Provides
    public PaymentMethodsAdapter providesAdapter() {
        return new PaymentMethodsAdapter();
    }
}
